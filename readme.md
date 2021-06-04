# User Authentification

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
- Create repository interface of the users
- Connect repository with the 

## Create Data Model




