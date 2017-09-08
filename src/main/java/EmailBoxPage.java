import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailBoxPage extends AbstractPage{
    WebDriver driver;
    private static final By CREATE_NEW_EMAIL_LOCATOR = By.xpath("//*[@id=\":3o\"]/div/div");
    private static final By RECIPIENT_ADDRESS_LOCATOR = By.xpath("//textarea[@aria-label=\"Кому\"]");
    private static final By EMAIL_TOPIC_LOCATOR = By.xpath("//input[@name=\"subjectbox\"]");
    private static final By EMAIL_BODY_LOCATOR = By.xpath("//div[@aria-label=\"Тело письма\"]");
    private static final By CLOSE_AND_SAVE_EMAIL_LOCATOR = By.xpath("//img[@aria-label=\"Сохранить и закрыть\"]");
    private static final By DRAFT_FOLDER_LOCATOR = By.xpath("//a[contains(@href, '#drafts')]");
    private static final By DRAFT_LETTER_LOCATOR = By.xpath("//span[text() = 'Testing with Selenium']");
    private static final By SEND_BUTTON_LOCATOR = By.xpath("//div[text() = 'Отправить']");


    public EmailBoxPage(WebDriver driver) {
        super(driver);
    }

    public String getCathegoryTitle() {
        return driver.getTitle();
    }

    public EmailBoxPage createNewEmail() {
        waitForElementVisible(CREATE_NEW_EMAIL_LOCATOR);
        driver.findElement(CREATE_NEW_EMAIL_LOCATOR).click();
        return this;
    }

    public EmailBoxPage writeRecipientAddress(String query) {
        waitForElementVisible(RECIPIENT_ADDRESS_LOCATOR);
        driver.findElement(RECIPIENT_ADDRESS_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailBoxPage writeLetterTopic(String query) {
        waitForElementVisible(EMAIL_TOPIC_LOCATOR);
        driver.findElement(EMAIL_TOPIC_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailBoxPage writeLetterBody(String query) {
        waitForElementVisible(EMAIL_BODY_LOCATOR);
        driver.findElement(EMAIL_BODY_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailBoxPage saveEmailAsADraft() {
        waitForElementVisible(CLOSE_AND_SAVE_EMAIL_LOCATOR);
        driver.findElement(CLOSE_AND_SAVE_EMAIL_LOCATOR).click();
        return this;
    }

    public EmailBoxPage goToDraftFolder() {
        waitForElementVisible(DRAFT_FOLDER_LOCATOR);
        driver.findElement(DRAFT_FOLDER_LOCATOR).click();
        return this;
    }

    public EmailBoxPage openDraftLetter() {
        waitForElementVisible(DRAFT_LETTER_LOCATOR);
        driver.findElement(DRAFT_LETTER_LOCATOR).click();
        return this;
    }

    public EmailBoxPage sendDraftLetter() {
        waitForElementVisible(SEND_BUTTON_LOCATOR);
        driver.findElement(SEND_BUTTON_LOCATOR).click();
        return this;
    }

    public EmailBoxPage refreshMailbox() {
        //driver.findElement()
        return this;
    }
}
