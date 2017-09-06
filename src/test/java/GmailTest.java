import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @BeforeClass(description = "Start browser")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void gmailLoginTest() {
        EmailBoxPage emailBoxPage;
        String EMAIL_LOGIN = "sumkin11fedor@gmail.com";
        String PASSWORD = "0Jp2t75T";
        String EXPECTED_TEXT = "Входящие";

        emailBoxPage = new EmailInputPage(driver).open().fillEmailInput(EMAIL_LOGIN).confirmEmail().fillPasswordInput(PASSWORD).comfirmPassword().verifyLoading();
        assertTrue(emailBoxPage.getCathegoryTitle().contains(EXPECTED_TEXT));
    }

    @Test(priority = 1)
    public void createLetterTest() {
        String RECIPIENT = "anton_kuhach@epam.com";
        String LETTER_TOPIC = "Testing with Selenium";
        String LETTER_BODY = "Test body.";

        new EmailBoxPage(driver).createNewEmail().writeRecipientAddress(RECIPIENT).writeLetterTopic(LETTER_TOPIC).writeLetterBody(LETTER_BODY).saveEmailAsADraft().goToDraftFolder();
        assertTrue(driver.findElements(By.xpath("//span[text() = 'Testing with Selenium']")).size() > 0);
    }

    //@Test(priority = 2)
    //public void

    @AfterClass(description = "Close browser")
    public void teardown() {
        driver.close();
    }
}