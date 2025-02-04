import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ZalandoSearch {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void filterSearchTest() throws InterruptedException {
        driver.get("https://www.zalando.hr/muskarci-home/");

        Thread.sleep(2000);

        WebElement shoes = driver.findElement(By.cssSelector("a._ZDS_REF_SCOPE_.CDD5jc.l9TUOd.CKDt_l.LyRfpJ.JT3_zV._9ia6Xz.uMACAo._5Yd-hZ"));
        shoes.click();

        Thread.sleep(2000);

        WebElement brandElement = driver.findElement(By.xpath("//button[.//div[text()='Brend']]"));
        brandElement.click();

        Thread.sleep(5000);

        WebElement adidasElement = driver.findElement(By.xpath("//span[contains(@class, 'hDNRPv') and span[text()='adidas (Sve)']]"));
        adidasElement.click();

        Thread.sleep(5000);

        WebElement saveElement = driver.findElement(By.xpath("//button[span[text()='Spremi']]"));
        saveElement.click();

        Thread.sleep(10000);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
