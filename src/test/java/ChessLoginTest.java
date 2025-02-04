import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChessLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testLogin() {

        driver.get("https://www.chess.com/login_and_go?returnUrl=https://www.chess.com/");

        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='username-input-field']/div/input")));
        usernameInput.sendKeys("sahist221");

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='password-input-field']/div/input")));
        passwordInput.sendKeys("Cevapi123");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login']")));
        loginButton.click();

        boolean loginSuccessful = wait.until(ExpectedConditions.urlContains("home"));
        Assert.assertTrue(loginSuccessful, "Prijavljivanje nije uspjelo.");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
