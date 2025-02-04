import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChessTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() throws InterruptedException {

        driver.get("https://www.chess.com/login_and_go?returnUrl=https://www.chess.com/");

        WebElement usernameInput = driver.findElement(By.xpath("//*[@id='username-input-field']/div/input"));
        usernameInput.sendKeys("sahist221");

        Thread.sleep(2000);

        WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password-input-field']/div/input"));
        passwordInput.sendKeys("Cevapi123");

        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']"));
        loginButton.click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Prijavljivanje nije uspjelo.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}