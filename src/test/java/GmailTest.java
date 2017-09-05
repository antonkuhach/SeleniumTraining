import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

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

    @Test
    public void gmailLoginTest() {
        EmailInboxPage emailInboxPage = new EmailInputPage(driver).open().fillEmailInput("sumkin11fedor@gmail.com").confirmEmail().fillPasswordInput("0Jp2t75T").comfirmPassword().verifyLoading();
        String expectedText = "Несортированные";
        assertEquals(expectedText, emailInboxPage.getCathegoryName());
    }

    @Test
    public void createLetterTest() {

    }

    @AfterClass(description = "Close browser")
    public void teardown() {
        driver.close();
    }
}
