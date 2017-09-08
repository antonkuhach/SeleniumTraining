import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailInputPageWithPF extends AbstractPage{
    WebDriver driver;

    @FindBy(css = "#identifierId")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/content/span")
    WebElement nextButton;

    public EmailInputPageWithPF(WebDriver driver) {
        super(driver);
    }

    public EmailInputPageWithPF fillEmailInput(String query) {
        emailInput.sendKeys(query);
        return this;
    }

    public PasswordInputPage confirmEmail() {
        nextButton.click();
        return new PasswordInputPage(driver);
    }

    public EmailInputPageWithPF open() {
        driver.get("https://gmail.com");
        return this;
    }
}
