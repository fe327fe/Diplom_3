import PageObject.ForgotPasswordPage;
import PageObject.MainPage;
import PageObject.RegisterPage;
import TestModel.User.UserClient;
import TestModel.User.UserCredentials;
import TestModel.User.UserModel;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestUserLogin extends BaseTest{

    private UserClient userClient;
    private UserCredentials creds;
    private UserModel user;
    private String bearerToken;

    @Before
    public void setUp() {

        userClient = new UserClient();
        user = UserModel.getRandom();
        creds = UserCredentials.from(user);

        userClient.registerNewUser(user);
        bearerToken = userClient.login(creds)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @After
    public void teardown(){

        userClient.delete(user.getEmail(), bearerToken);
    }

    @Test
    @DisplayName("Check user is able to login successfully via the login button from the main page")
    public void successfullyLoginUserUsingLoginButtonOnTheMainPage () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // клик по кнопке <Войти в аккаунт>
        // вход пользователя
        // проверяем наличие кнопки <Оформить заказ>

        final boolean orderButtonDisplayed = Selenide.open (MainPage.URL, MainPage.class)
                .clickLoginButton()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Check user is able to login successfully via the profile link from the main page")
    public void successfullyLoginUserUsingProfileLinkOnTheMainPage () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // клик по ссылке <Личный Кабинет>
        // вход пользователя
        // проверяем наличие кнопки <Оформить заказ>

        final boolean orderButtonDisplayed = Selenide.open (MainPage.URL, MainPage.class)
                .clickProfileLink()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Check user is able to login successfully via the login link from the register page")
    public void successfullyLoginUserUsingLoginLinkOnTheRegisterPage () {

        // открывается страница регистрации и создаётся экземпляр класса страницы
        // клик по ссылке <Зарегистрироваться>
        // клик по кнопке <Войти>
        // вход пользователя
        // проверяем наличие кнопки <Оформить заказ>

        final boolean orderButtonDisplayed = Selenide.open (RegisterPage.URL, RegisterPage.class)
                .clickLoginLink()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Check user is able to login successfully via the login link from the restore password page")
    public void successfullyLoginUserUsingLoginLinkOnTheRestorePasswordPage () {

        // открывается страница восстановления пароля и создаётся экземпляр класса страницы
        // клик по ссылке <Войти>
        // вход пользователя
        // проверяем наличие кнопки <Оформить заказ>

        final boolean orderButtonDisplayed = Selenide.open (ForgotPasswordPage.URL, ForgotPasswordPage.class)
                .clickLoginLink()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }
}
