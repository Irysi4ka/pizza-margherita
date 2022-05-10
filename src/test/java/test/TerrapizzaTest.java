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
    public void testAddPizzaToCart() throws InterruptedException {
        homePage = new HomePage(driver)
                .openPage()
                .clickButtonMenuPizza();


        pizzaPage = new PizzaPage(driver)
                .clickButtonAddPizzaToCart()
                .clickButtonOrder()
                .clickCloseButtonOrderOpened();

        homePage
                .clickButtonMenuBar();

        barPage = new BarPage(driver)
                .clickButtonAddDrinkToCart()
                .clickButtonOrder();

        assertTrue(barPage.isDrinkInCart(drinkName));
        assertTrue(pizzaPage.isPizzaInCart(pizzaName));

        Thread.sleep(5000);
    }
}
