# User Service Authentification Spring Boot

User login with jwt

```
 POST api/auth/signin
               
              post(user,password) 
 CLIENT ----------------------------> SERVER Authenticate(user,password) -> JWTToken
          
          response  token jwt
          (user info, type,authorities...)
 CLIENT <---------------------------- SERVER
 
 
 Server: 
 
       Authenticate(user,password)
       
       Validate(JwtToken)
       
       Refresh(Token)
 ```

- Create Data Model(MySQL) for the user
- Create Repository interface of the users
- Create User Service
- Test User Service  







