import PageObject.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestBurgerIngredients extends BaseTest{


    @Test
    @DisplayName("Check clicking the buns link displays the  list of available buns")
    public void successfullyDisplayBunsTextElement () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // клик по ссылке <Начинки>
        // клик по ссылке <Соусы>
        // клик по ссылке <Булки>
        // проверяем наличие текстового элемента <Булки>

        final boolean bunsTextDisplayed = Selenide.open (MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableSauces()
                .displayAvailableBuns()
                .isBunsTextDisplayed();

        assertTrue(bunsTextDisplayed);
    }

    @Test
    @DisplayName("Check clicking the sauces link displays the list of available sauces")
    public void successfullyDisplaySaucesTextElement () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // клик по ссылке <Начинки>
        // клик по ссылке <Булки>
        // клик по ссылке <Соусы>
        // проверяем наличие текстового элемента <Соусы>

        final boolean saucesTextDisplayed = Selenide.open (MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableBuns()
                .displayAvailableSauces()
                .isSaucesTextDisplayed();

        assertTrue(saucesTextDisplayed);
    }

    @Test
    @DisplayName("Check clicking the fillings link displays the list of available fillings")
    public void successfullyDisplayFillingsTextElement () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // клик по ссылке <Соусы>
        // клик по ссылке <Булки>
        // клик по ссылке <Начинки>
        // проверяем наличие текстового элемента <Начинки>

        final boolean fillingsTextDisplayed = Selenide.open (MainPage.URL, MainPage.class)
                .displayAvailableSauces()
                .displayAvailableBuns()
                .displayAvailableFillings()
                .isFillingsTextDisplayed();

        assertTrue(fillingsTextDisplayed);
    }

}
