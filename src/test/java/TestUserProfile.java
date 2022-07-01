import PageObject.LoginPage;
import TestModel.User.UserClient;
import TestModel.User.UserCredentials;
import TestModel.User.UserModel;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestUserProfile extends BaseTest{

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
    @DisplayName("Check user is able to get into the user profile successfully")
    public void successfullyDisplayUserProfile () {

        // открывается страница для входа и создаётся экземпляр класса страницы
        // вход пользователя
        // переход в Личный Кабинет
        // проверяем наличие текстового элемента <В этом разделе вы можете изменить свои персональные данные>

        final boolean profileTextDisplayed = Selenide.open (LoginPage.URL, LoginPage.class)
                .userLogin(user)
                .clickProfileLinkUserLogged()
                .isProfileTextDisplayed();

        assertTrue(profileTextDisplayed);
    }

    @Test
    @DisplayName("Check user is able to click the create burger link from the user profile page")
    public void successfullyDisplayCreateBurgerTextByClickingTheCreateBurgerLink () {

        // открывается страница для входа и создаётся экземпляр класса страницы
        // вход пользователя
        // переход в Личный Кабинет
        // переход по ссылке <Конструктор>
        // проверяем наличие текстового элемента <Соберите бургер>

        final boolean createBurgerTextDisplayed = Selenide.open (LoginPage.URL, LoginPage.class)
                .userLogin(user)
                .clickProfileLinkUserLogged()
                .clickCreateBurger()
                .isCreateBurgerTextDisplayed();

        assertTrue(createBurgerTextDisplayed);
    }

    @Test
    @DisplayName("Check user is able to click the stellar burger logo from the user profile page")
    public void successfullyDisplayCreateBurgerTextByClickingTheBurgerLogo () {

        // открывается страница для входа и создаётся экземпляр класса страницы
        // вход пользователя
        // переход в Личный Кабинет
        // переход по ссылке из логотипа <Stellar Burgers>
        // проверяем наличие текстового элемента <Соберите бургер>

        final boolean createBurgerTextDisplayed = Selenide.open (LoginPage.URL, LoginPage.class)
                .userLogin(user)
                .clickProfileLinkUserLogged()
                .clickBurgerLogo()
                .isCreateBurgerTextDisplayed();

        assertTrue(createBurgerTextDisplayed);
    }

    @Test
    @DisplayName("Check user is able to logout successfully")
    public void successfullyLogoutUser () {

        // открывается страница для входа и создаётся экземпляр класса страницы
        // вход пользователя
        // клик по кнопке <Личный Кабинет>
        // клик по кнопке <Выход>
        // проверяем наличие текстового элемента <Вход>

        final boolean cuserLoginTextDisplayed = Selenide.open (LoginPage.URL, LoginPage.class)
                .userLogin(user)
                .clickProfileLinkUserLogged()
                .clickLogoutButton()
                .isUserLoginTextDisplayed();

        assertTrue(cuserLoginTextDisplayed);
    }

}
