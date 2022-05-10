package pageobjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected final static String BASE_URL = "https://terrapizza.by/";

    protected WebDriver driver;
    protected final static int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

}
