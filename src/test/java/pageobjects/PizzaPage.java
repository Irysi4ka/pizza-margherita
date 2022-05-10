package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PizzaPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='cart-button']/button[@data-id='364']")
    private WebElement buttonAddPizzaToCart;
    @FindBy(xpath = "//div[@class='basket__btn-top basket__top basket__btn-top--sm']")
    private WebElement buttonOrder;
    @FindBy(xpath = "//li[@id='basket-el-0']//div[@class='basket__products-item-name']")
    private WebElement labelPizza;
    @FindBy(xpath = "//div[@id='basket-btn']")
    private WebElement buttonOrderOpened;

    public PizzaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PizzaPage clickButtonAddPizzaToCart() {
        buttonAddPizzaToCart.click();
        return this;
    }

    public boolean isPizzaInCart(String pizzaName) {
        return labelPizza.getText().contains(pizzaName);
    }

    public PizzaPage clickButtonOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonOrder))
                .click();
        return this;
    }
}
