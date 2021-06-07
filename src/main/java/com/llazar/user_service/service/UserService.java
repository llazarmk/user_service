package com.llazar.user_service.service;


import com.llazar.user_service.model.UserModel;
import com.llazar.user_service.repository.UserRepository;
import com.llazar.user_service.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService{

    /* User service depends on bcrypt_encoder service */
    private static final BCryptPasswordEncoder BCRYPT_ENCODER = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;


    /**
     * Service class function that takes the user request parameter (Json format) {@link UserRequest}
     * and saves a new user in the database
     * @param  request logged in user to create a JWT token for.
     */

    public UserModel createUser(UserRequest request) throws ParseException {

        String username = request.getUsername();
        String email = request.getEmail();
        String password = BCRYPT_ENCODER.encode(request.getPassword());
        String firstname = request.getFirst_name();
        String lastname = request.getLast_name();
        String address = request.getAddress();
        Date birthday = Parser.parseDate(request.getBirthday());

        UserModel userModel = new UserModel(username, email,password,firstname, lastname, address,birthday);
        return userModel;

    }

    public UserModel save(UserRequest request) throws ParseException {
        UserModel userModel = createUser(request);
        userRepository.save(userModel);
        return userModel;
    }

    /**
     * Service class function that takes the user username
     * and call the data model interface to return this particular user
     * @param  username username of the user to find
     */

    public UserModel findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    /**
     * Service class function that takes the user username
     * and call the data model interface to return this particular user
     * @param  username username of the user to login
     * @param  password password of the user to login
     */

    public String loginByUsernameAndPassword(String username,String password) {


        UserModel userModel = findByUsername(username);
        if (userModel == null)
        {
            return "Error: User does not exists.";
        }

        if (!BCRYPT_ENCODER.matches(password, userModel.getPassword())) {

            return "Error: Incorrect password.";
        }
        String jsonToken = new JSONObject().put("token", jwtTokenProvider.createJwtToken(userModel)).toString();

        return jsonToken;
    }


}
