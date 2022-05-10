package test;

import org.junit.jupiter.api.Test;
import pageobjects.BarPage;
import pageobjects.HomePage;
import pageobjects.PizzaPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TerrapizzaTest extends AbstractTest {
    HomePage homePage;
    PizzaPage pizzaPage;
    BarPage barPage;

    private final String pizzaName = "Маргарита";
    private final String drinkName = "Имбирь-клюква";

    @Test
    public void testAddPizzaToCart() {
        homePage = new HomePage(driver)
                .openPage()
                .clickButtonMenuPizza();

        pizzaPage = new PizzaPage(driver)
                .clickButtonAddPizzaToCart();

        homePage
                .clickButtonMenuBar();

        barPage = new BarPage(driver)
                .clickButtonAddDrinkToCart()
                .clickButtonOrder();

        assertTrue(pizzaPage.isPizzaInCart(pizzaName));
        assertTrue(barPage.isDrinkInCart(drinkName));

    }
}
