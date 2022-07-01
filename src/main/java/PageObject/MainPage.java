package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.Selenide;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    final public static String URL = "https://stellarburgers.nomoreparties.site";

    // локатор кнопки <Войти в аккаунт>
    @FindBy(how = How.XPATH,using = ("//button[text()='Войти в аккаунт']"))
    private SelenideElement loginButton;

    // локатор кнопки <Оформить заказ>
    @FindBy(how = How.XPATH,using = ("//button[text()='Оформить заказ']"))
    private SelenideElement orderButton;

    // локатор ссылки для входа <Личный Кабинет>
    @FindBy(how = How.XPATH,using = ("//p[text()='Личный Кабинет']"))
    private SelenideElement profileLink;

    // локатор элемента <Соберите бургер>
    @FindBy(how = How.XPATH,using = ("//h1[text()='Соберите бургер']"))
    private SelenideElement createBurgerText;

    // локатор раздела <Булки>
    @FindBy(how = How.XPATH,using = ("//span[text()='Булки']"))
    private SelenideElement availableBuns;

    // локатор раздела <Соусы>
    @FindBy(how = How.XPATH,using = ("//span[text()='Соусы']"))
    private SelenideElement availableSauces;

    // локатор раздела <Начинки>
    @FindBy(how = How.XPATH,using = ("//span[text()='Начинки']"))
    private SelenideElement availableFillings;

    // локатор текстового элемента <Булки>
    @FindBy(how = How.XPATH,using = ("//h2[text()='Булки']"))
    private SelenideElement bunsText;

    // локатор текстового элемента <Соусы>
    @FindBy(how = How.XPATH,using = ("//h2[text()='Соусы']"))
    private SelenideElement saucesText;

    // локатор текстового элемента <Начинки>
    @FindBy(how = How.XPATH,using = ("//h2[text()='Начинки']"))
    private SelenideElement fillingsText;

    // метод клика по кнопке <Войти в аккаунт>
    public LoginPage clickLoginButton() {

        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    // метод клика по кнопке <Оформить заказ>
    public LoginPage clickOrderButton() {

        orderButton.click();
        return Selenide.page(LoginPage.class);
    }

    // метод проверки видимости кнопки <Оформить заказ>
    public boolean isOrderButtonDisplayed() {

        return orderButton.shouldBe(visible).isDisplayed();
    }

    // метод клика по ссылке <Личный Кабинет>
    public LoginPage clickProfileLink() {

        profileLink.click();
        return Selenide.page(LoginPage.class);
    }

    // метод клика по ссылке <Личный Кабинет> при залогиненом пользователе
    public ProfilePage clickProfileLinkUserLogged() {

        profileLink.click();
        return Selenide.page(ProfilePage.class);
    }

    // метод проверки видимости текстового элемента <Соберите бургер>
    public boolean isCreateBurgerTextDisplayed() {

        return createBurgerText.shouldBe(visible).isDisplayed();
    }

    // метод клика по ссылке <Булки>
    public MainPage displayAvailableBuns() {

        availableBuns.click();
        return this;
    }

    // метод клика по ссылке <Соусы>
    public MainPage displayAvailableSauces() {

        availableSauces.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    // метод клика по ссылке <Начинки>
    public MainPage displayAvailableFillings() {

        availableFillings.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    // метод проверки видимости текстового элемента <Булки>
    public boolean isBunsTextDisplayed() {

        return bunsText.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
    }

    // метод проверки видимости текстового элемента <Соусы>
    public boolean isSaucesTextDisplayed() {

        return saucesText.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
    }

    // метод проверки видимости текстового элемента <Начинки>
    public boolean isFillingsTextDisplayed() {

        return fillingsText.shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
    }

}