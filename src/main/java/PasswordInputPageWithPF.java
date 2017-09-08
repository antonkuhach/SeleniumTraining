import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class PasswordInputPageWithPF extends AbstractPage{
    WebDriver driver;

    @FindBy(css = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
    WebElement passwordInput;

    @FindBy(css = "#passwordNext > content > span")
    WebElement nextButton;

    public PasswordInputPageWithPF(WebDriver driver) {
        super(driver);
    }

    public PasswordInputPageWithPF fillPasswordInput(String query) {
        passwordInput.sendKeys(query);
        return this;
    }

    public GmailLoadingPage comfirmPassword() {
        nextButton.click();
        return new GmailLoadingPage(driver);
    }
}