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

    private final String pizzaName = "Пицца Маргарита";
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

        assertTrue(pizzaPage.isPizzaInCart(pizzaName));
        assertTrue(barPage.isDrinkInCart(drinkName));
        //Thread.sleep(5000);

    }
}
