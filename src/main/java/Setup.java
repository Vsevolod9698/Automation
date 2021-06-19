import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class Setup {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "q")
    public WebElement googleSearch;
    @FindBy(xpath = "//h3[text()='What is Test Automation? Automated Testing 101 | SmartBear']")
    public WebElement clickLink;
    @FindBy(xpath = "//h1[text()='What is Automated Testing?']")
    public List <WebElement> visibleAutomated;

    public Setup(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }
    public void searchSite(){
        googleSearch.sendKeys("Test Automation");
        googleSearch.sendKeys(Keys.ENTER);
        clickLink.click();
    }
    public List <String> verificationTitle(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.visibleAutomated));
        List<String> results1 = new ArrayList<>();
        this.visibleAutomated.forEach((result->results1.add(result.getText())));
        return results1;
    }
}
