package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BarPage extends AbstractPage{
    @FindBy(xpath = "//div[@class='cart-button']//button[@data-id='1451']")
    private WebElement buttonAddDrinkToCart;
    @FindBy(xpath = "//div[@class='basket__btn-top basket__top basket__btn-top--sm']")
    private WebElement buttonOrder;
    @FindBy(xpath = "//li[@id='basket-el-1']//div[@class='basket__products-item-name']")
    private WebElement labelDrink;

    public BarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BarPage clickButtonAddDrinkToCart(){
        buttonAddDrinkToCart.click();
        return this;
    }

    public boolean isDrinkInCart(String drinkName){
        return labelDrink.getText().contains(drinkName);
    }

    public BarPage clickButtonOrder(){
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonOrder))
                .click();
        return this;
    }
}
