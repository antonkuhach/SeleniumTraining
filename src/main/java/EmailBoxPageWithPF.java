import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class EmailBoxPageWithPF extends AbstractPage{
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\":3o\"]/div/div")
    WebElement createNewEmail;

    @FindBy(xpath = "//textarea[@aria-label=\"Кому\"]")
    WebElement recipientAddress;

    @FindBy(xpath = "//input[@name=\"subjectbox\"]")
    WebElement emailTopic;

    @FindBy(xpath = "//div[@aria-label=\"Тело письма\"]")
    WebElement emailBody;

    @FindBy(xpath = "//img[@aria-label=\"Сохранить и закрыть\"]")
    WebElement closeAndSaveEmail;

    @FindBy(xpath = "//a[contains(@href, '#drafts')]")
    WebElement draftFolder;

    @FindBy(xpath = "//span[text() = 'Testing with Selenium']")
    WebElement draftLetter;

    @FindBy(xpath = "//div[text() = 'Отправить']")
    WebElement sendButton;


    public EmailBoxPageWithPF(WebDriver driver) {
        super(driver);
    }

    public String getCathegoryTitle() {
        return driver.getTitle();
    }

    public EmailBoxPageWithPF createNewEmail() {
        createNewEmail.click();
        return this;
    }

    public EmailBoxPageWithPF writeRecipientAddress(String query) {
        recipientAddress.sendKeys(query);
        return this;
    }

    public EmailBoxPageWithPF writeLetterTopic(String query) {
        emailTopic.sendKeys(query);
        return this;
    }

    public EmailBoxPageWithPF writeLetterBody(String query) {
        emailBody.sendKeys(query);
        return this;
    }

    public EmailBoxPageWithPF saveEmailAsADraft() {
        closeAndSaveEmail.click();
        return this;
    }

    public EmailBoxPageWithPF goToDraftFolder() {
        draftFolder.click();
        return this;
    }

    public EmailBoxPageWithPF openDraftLetter() {
        draftLetter.click();
        return this;
    }

    public EmailBoxPageWithPF sendDraftLetter() {
        sendButton.click();
        return this;
    }

    public EmailBoxPageWithPF refreshMailbox() {
        //driver.findElement()
        return this;
    }
}
