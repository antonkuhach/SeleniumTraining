import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailInboxPage {
    WebDriver driver;
    private static final By INBOX_CATHEGORY_LOCATOR = By.xpath("//*[@id=\":2i\"]");
    private static final By CREATE_NEW_EMAIL_LOCATOR = By.xpath("//*[@id=\":3o\"]/div/div");


    public EmailInboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCathegoryName() {
        return driver.findElement(INBOX_CATHEGORY_LOCATOR).getText();
    }

    public EmailInboxPage createNewEmail() {
        driver.findElement(CREATE_NEW_EMAIL_LOCATOR).click();
        return this;
    }
}
