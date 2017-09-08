import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class GmailLoadingPageWithPF extends AbstractPage{
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"loading\"]/div[1]/div[1]")
    WebElement loadingPage;

    public GmailLoadingPageWithPF(WebDriver driver) {
        super(driver);
    }

    public EmailBoxPage verifyLoading() {
        return new EmailBoxPage(driver);
    }
}
