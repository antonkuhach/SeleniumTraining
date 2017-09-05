import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class PasswordInputPage {
    WebDriver driver;
    private static final By PASSWORD_INPUT_LOCATOR = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
    private static final By NEXT_BUTTON_LOCATOR =By.cssSelector("#passwordNext > content > span");

    public PasswordInputPage(WebDriver driver) {
        this.driver = driver;
    }

    public PasswordInputPage fillPasswordInput(String query) {
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailInboxPage comfirmPassword() {
        driver.findElement(NEXT_BUTTON_LOCATOR).click();
        return new EmailInboxPage(driver);
    }
}