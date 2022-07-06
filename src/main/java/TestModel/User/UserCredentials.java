package TestModel.User;

import lombok.*;

@Setter

public class UserCredentials {
    private String email;
    private String password;

    public UserCredentials(UserModel user){
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public static UserCredentials from (UserModel user){

        return new UserCredentials(user);
    }
}
