package TestModel.User;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@AllArgsConstructor
public class UserModel {

    private String email;
    private String name;
    private String password;

    public static UserModel getRandom () {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String name = faker.name().fullName();
        String password = RandomStringUtils.randomAlphabetic(10);

        return new UserModel(email, name, password);
    }
}
