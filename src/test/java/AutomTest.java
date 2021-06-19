import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class AutomTest {
    public WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        this.driver = new ChromeDriver(options);
        this.driver.get("https://www.google.com/");
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void quit(){
        driver.quit();
    }

    @Test
    public void automationTest(){
        Setup setup = new Setup(driver);
        setup.searchSite();
        setup.verificationTitle();
        assertTrue(setup.verificationTitle().stream().anyMatch(result->result.contains("Automated")));
    }
}
