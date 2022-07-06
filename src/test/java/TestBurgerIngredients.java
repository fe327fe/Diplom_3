import PageObject.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestBurgerIngredients extends BaseTest{

    private final String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";


    @Test
    @DisplayName("Check the buns tab gets activated successfully")
    public void checkBunsTabGetsActivatedSuccessfully() {

        // открывается главная страница и создаётся экземпляр класса страницы
        // активируем вкладку <Начинки>
        // активируем вкладку <Соусы>
        // активируем вкладку <Булки>
        // проверяем, что вкладка <Булки> является активной

        final String actual = Selenide.open (MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableSauces()
                .displayAvailableBuns()
                .getBunsTabClassValue();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check the sauces tab gets activated successfully")
    public void checkSaucesTabGetsActivatedSuccessfully () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // активируем вкладку <Начинки>
        // активируем вкладку <Булки>
        // активируем вкладку <Соусы>
        // проверяем, что вкладка <Соусы> является активной

        final String actual = Selenide.open (MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableBuns()
                .displayAvailableSauces()
                .getSaucesTabClassValue();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check the fillings tab gets activated successfully")
    public void checkFillingsTabGetsActivatedSuccessfully () {

        // открывается главная страница и создаётся экземпляр класса страницы
        // активируем вкладку <Соусы>
        // активируем вкладку <Булки>
        // активируем вкладку <Начинки>
        // проверяем, что вкладка <Начинки> является активной

        final String actual = Selenide.open (MainPage.URL, MainPage.class)
                .displayAvailableSauces()
                .displayAvailableBuns()
                .displayAvailableFillings()
                .getFillingsTabClassValue();

        assertEquals(expected, actual);
    }

}
