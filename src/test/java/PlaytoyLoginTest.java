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

public class PlaytoyLogin {

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

        driver.get("https://sso.hrvatskitelekom.hr/auth/realms/Playtoy/protocol/openid-connect-ext/auth?client_id=playtoy&redirect_uri=https%3a%2f%2fplaytoy.tportal.hr%2fsso%2fcallback2.aspx&response_type=code&scope=openid%20profile");

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
        usernameInput.sendKeys("Zdenko margarin");

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        passwordInput.sendKeys("burek123");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='kc-login']")));
        loginButton.click();

        wait.until(ExpectedConditions.urlToBe("https://playtoy.tportal.hr/"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://playtoy.tportal.hr/", "Prijavljivanje je uspjelo.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
