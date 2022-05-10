package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//li[@class='menu-navigation__item']/a[@href='/menu/cat/picca']")
    private WebElement buttonMenuPizza;

    @FindBy(xpath = "//li[@class='menu-navigation__item']/a[@href='/menu/cat/bar']")
    private WebElement buttonMenuBar;

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

    public HomePage clickButtonMenuBar(){
        buttonMenuBar.click();
        return this;
    }
}
