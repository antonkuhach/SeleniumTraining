import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class GmailLoadingPage {
    WebDriver driver;
    private static final By LOADING_PAGE_LOCATOR = By.xpath("//*[@id=\"loading\"]/div[1]/div[1]");

    public GmailLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailBoxPage verifyLoading() {
        return driver.findElement(LOADING_PAGE_LOCATOR).isEnabled() ? new EmailBoxPage(driver) : null;
    }
}
