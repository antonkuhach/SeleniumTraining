import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class PasswordInputPage extends AbstractPage{
    WebDriver driver;
    private static final By PASSWORD_INPUT_LOCATOR = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
    private static final By NEXT_BUTTON_LOCATOR =By.cssSelector("#passwordNext > content > span");

    public PasswordInputPage(WebDriver driver) {
        super(driver);
    }

    public PasswordInputPage fillPasswordInput(String query) {
        waitForElementVisible(PASSWORD_INPUT_LOCATOR);
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(query);
        return this;
    }

    public GmailLoadingPage comfirmPassword() {
        waitForElementVisible(NEXT_BUTTON_LOCATOR);
        driver.findElement(NEXT_BUTTON_LOCATOR).click();
        return new GmailLoadingPage(driver);
    }
}