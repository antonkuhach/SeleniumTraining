import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailInboxPage {
    WebDriver driver;
    private static final By INBOX_CATHEGORY_LOCATOR = By.xpath("//*[@id=\":2i\"]");
    private static final By CREATE_NEW_EMAIL_LOCATOR = By.xpath("//*[@id=\":3o\"]/div/div");
    private static final By RECIPIENT_ADDRESS_LOCATOR = By.xpath("//*[@id=\":8u\"]");
    private static final By EMAIL_TOPIC_LOCATOR = By.xpath("//*[@id=\":8d\"]");


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

    public EmailInboxPage writeRecipientAddress(String query) {
        driver.findElement(RECIPIENT_ADDRESS_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailInboxPage writeLetterTopic(String query) {
        driver.findElement(EMAIL_TOPIC_LOCATOR).sendKeys(query);
        return this;
    }
}
