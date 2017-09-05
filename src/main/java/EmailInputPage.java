import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailInputPage {
    WebDriver driver;
    private static final By EMAIL_INPUT_LOCATOR = By.cssSelector("#identifierId");
    private static final By NEXT_BUTTON_LOCATOR = By.xpath("//*[@id=\"identifierNext\"]/content/span");

    public EmailInputPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailInputPage fillEmailInput(String query) {
        driver.findElement(EMAIL_INPUT_LOCATOR).sendKeys(query);
        return this;
    }

    public PasswordInputPage confirmEmail() {
        driver.findElement(NEXT_BUTTON_LOCATOR).click();
        return new PasswordInputPage(driver);
    }

    public EmailInputPage open() {
        driver.get("https://gmail.com");
        return this;
    }
}
