package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//li[@class='menu-navigation__item'][3]")
    private WebElement buttonMenuPizza;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(BASE_URL);
        return this;
    }

    public HomePage clickButtonMenuPizza(){
        buttonMenuPizza.click();
        return this;
    }
}
