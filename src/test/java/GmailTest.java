import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


/**
 * Created by Anton_Kuhach on 9/5/2017.
 */
public class GmailTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private EmailBoxPage emailBoxPage;
    private String RECIPIENT;
    private String LETTER_TOPIC;
    private String LETTER_BODY;



    @BeforeClass(description = "Start browser")
    public void setup() {
        RECIPIENT = "anton_kuhach@epam.com";
        LETTER_TOPIC = "Testing with Selenium";
        LETTER_BODY = "Test body.";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void gmailLoginTest() {
        String EMAIL_LOGIN = "sumkin11fedor@gmail.com";
        String PASSWORD = "0Jp2t75T";
        String EXPECTED_TEXT = "Входящие";

        emailBoxPage = new EmailInputPage(driver).open().fillEmailInput(EMAIL_LOGIN).confirmEmail().fillPasswordInput(PASSWORD).comfirmPassword().verifyLoading();
        assertTrue(emailBoxPage.getCathegoryTitle().contains(EXPECTED_TEXT));
    }

    @Test(priority = 1)
    public void createLetterTest() {
        emailBoxPage.createNewEmail().writeRecipientAddress(RECIPIENT).writeLetterTopic(LETTER_TOPIC).writeLetterBody(LETTER_BODY).saveEmailAsADraft().goToDraftFolder();
        assertTrue(driver.findElements(By.xpath("//span[text() = 'Testing with Selenium']")).size() > 0);
    }

    @Test(priority = 2)
    public void draftEmailContentTest() {
        emailBoxPage.openDraftLetter();
        assertTrue(driver.findElements(By.xpath("//span[@email='anton_kuhach@epam.com']")).size() > 0);
    }

    @Test(priority = 3)
    public void draftRemoveTest() {
        emailBoxPage.sendDraftLetter();
        assertTrue(driver.findElement(By.xpath("//span[text() = 'Testing with Selenium']")).isDisplayed());
    }

    @AfterClass(description = "Close browser")
    public void teardown() {
        driver.close();
    }
}