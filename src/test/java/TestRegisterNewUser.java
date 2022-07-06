import TestModel.User.UserClient;
import TestModel.User.UserCredentials;
import TestModel.User.UserModel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.MainPage;
import com.codeborne.selenide.Selenide;
import static org.junit.Assert.assertTrue;


public class TestRegisterNewUser extends BaseTest{

    private UserClient userClient;
    private UserCredentials creds;
    private UserModel user;
    private boolean afterToBeLaunched;

    @Before
    public void setUp() {

        afterToBeLaunched = true;

        userClient = new UserClient();
        user = UserModel.getRandom();
        creds = UserCredentials.from(user);
    }

    @After
    public void teardown(){

        if(!afterToBeLaunched) {
            return;
        }
        String bearerToken = userClient.login(creds)
                .then().log().all()
                .extract()
                .path("accessToken");

        userClient.delete(user.getEmail(), bearerToken);
    }

    @Test
    @DisplayName("Check successfully registering a new user")
    public void successfullyRegisterNewUser () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // клик по кнопке <Войти в аккаунт>
        // клик по ссылке <Зарегистрироваться>
        // проверяем наличие кнопки <Оформить заказ>

        final boolean orderButtonDisplayed = Selenide.open (MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegisterLink()
                .registerNewUser(user)
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Check registering a new user with an incorrect pass, with less than 6 symbols, fails")
    public void registerNewUserWithIncorrectPassFails () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // клик по кнопке <Войти в аккаунт>
        // клик по ссылке <Зарегистрироваться>
        // проверяем видимость элемента <Некорректный пароль>

        user.setPassword("five");

        final boolean incorrectPasswordWarningDisplayed = Selenide.open (MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegisterLink()
                .registerNewUserWithIncorrectPass(user)
                .isIncorrectPassDisplayed();

        assertTrue(incorrectPasswordWarningDisplayed);
        afterToBeLaunched = false;
    }
}
