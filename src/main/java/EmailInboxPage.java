import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailInboxPage {
    WebDriver driver;
    private static final By INBOX_CATHEGORY_LOCATOR = By.xpath("//*[@id=\":3w\"]/div/div[2]/span/a");


    public EmailInboxPage(WebDriver driver) {
        this.driver = driver;
    }
}
