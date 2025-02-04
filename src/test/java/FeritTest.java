import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeritTest {

    public WebDriver driver;
    public String testURL = "https://www.ferit.unios.hr/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void navigateToStudyPrograms() {
        driver.manage().window().maximize();

        WebElement upisiLink = driver.findElement(By.linkText("Upisi i studiji"));
        upisiLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement pregledStudijaLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Pregled studijskih programa")));

        pregledStudijaLink.click();

        wait.until(ExpectedConditions.urlToBe("https://www.ferit.unios.hr/upisi-i-studiji/pregled-studija"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ferit.unios.hr/upisi-i-studiji/pregled-studija");

        System.out.println("Stranica je uspješno učitana: " + driver.getCurrentUrl());
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}