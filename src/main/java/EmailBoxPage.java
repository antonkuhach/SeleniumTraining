import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailBoxPage {
    WebDriver driver;
    WebDriverWait wait;
    private static final By CREATE_NEW_EMAIL_LOCATOR = By.xpath("//*[@id=\":3o\"]/div/div");
    private static final By RECIPIENT_ADDRESS_LOCATOR = By.xpath("//textarea[@aria-label=\"Кому\"]");
    private static final By EMAIL_TOPIC_LOCATOR = By.xpath("//input[@name=\"subjectbox\"]");
    private static final By EMAIL_BODY_LOCATOR = By.xpath("//div[@aria-label=\"Тело письма\"]");
    private static final By CLOSE_AND_SAVE_EMAIL_LOCATOR = By.xpath("//img[@aria-label=\"Сохранить и закрыть\"]");
    private static final By DRAFT_FOLDER_LOCATOR = By.xpath("//a[@href=\"https://mail.google.com/mail/#drafts\"]");
    private static final By DRAFT_LETTER_LOCATOR = By.xpath("//span[text() = 'Testing with Selenium']");
    private static final By SEND_BUTTON_LOCATOR = By.xpath("//div[text() = 'Отправить']");


    public EmailBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public String getCathegoryTitle() {
        return driver.getTitle();
    }

    public EmailBoxPage createNewEmail() {
        driver.findElement(CREATE_NEW_EMAIL_LOCATOR).click();
        return this;
    }

    public EmailBoxPage writeRecipientAddress(String query) {
        driver.findElement(RECIPIENT_ADDRESS_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailBoxPage writeLetterTopic(String query) {
        driver.findElement(EMAIL_TOPIC_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailBoxPage writeLetterBody(String query) {
        driver.findElement(EMAIL_BODY_LOCATOR).sendKeys(query);
        return this;
    }

    public EmailBoxPage saveEmailAsADraft() {
        driver.findElement(CLOSE_AND_SAVE_EMAIL_LOCATOR).click();
        return this;
    }

    public EmailBoxPage goToDraftFolder() {
        driver.findElement(DRAFT_FOLDER_LOCATOR).click();
        wait.until(ExpectedConditions.titleContains("Черновики"));
        return this;
    }

    public EmailBoxPage openDraftLetter() {
        driver.findElement(DRAFT_LETTER_LOCATOR).click();
        return this;
    }

    public EmailBoxPage sendDraftLetter() {
        driver.findElement(SEND_BUTTON_LOCATOR).click();
        return this;
    }

    public EmailBoxPage refreshMailbox() {
        //driver.findElement()
        return this;
    }
}
