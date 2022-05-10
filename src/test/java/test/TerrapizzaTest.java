package test;

import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.PizzaPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TerrapizzaTest extends AbstractTest {
    HomePage homePage;
    PizzaPage pizzaPage;
    private final String pizzaName = "Маргарита";

    @Test
    public void testAddPizzaToCart() throws InterruptedException {
        homePage = new HomePage(driver)
                .openPage()
                .clickButtonMenuPizza();


        pizzaPage = new PizzaPage(driver)
                .clickButtonAddPizzaToCart()
                .clickButtonOrder();

        assertTrue(pizzaPage.isPizzaInCart(pizzaName));

        Thread.sleep(5000);
    }
}
