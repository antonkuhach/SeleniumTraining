import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class GmailLoadingPage extends AbstractPage{
    WebDriver driver;
    private static final By LOADING_PAGE_LOCATOR = By.xpath("//*[@id=\"loading\"]/div[1]/div[1]");

    public GmailLoadingPage(WebDriver driver) {
        super(driver);
    }

    public EmailBoxPage verifyLoading() {
        waitForElementVisible(LOADING_PAGE_LOCATOR);
        return new EmailBoxPage(driver);
    }
}
