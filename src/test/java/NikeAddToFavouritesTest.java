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

public class NikeAddFavourites {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testNikeSearch() {
        driver.get("https://www.nike.com/hr/jordan");

        WebElement searchButton = driver.findElement(By.id("nav-search-icon"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.id("gn-search-input"));
        searchInput.sendKeys("Tech Fleece");
        searchInput.submit();

        WebElement firstProductImage = driver.findElement(By.cssSelector("img.product-card__hero-image"));
        firstProductImage.click();

        WebElement favouriteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Sign in to favourite']")));
        favouriteButton.click();

        wait.until(ExpectedConditions.urlContains("https://accounts.nike.com/lookup"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://accounts.nike.com/lookup?client_id=4fd2d5e7db76e0f85a6bb56721bd51df&redirect_uri=https://www.nike.com/auth/login&response_type=code&scope=openid%20nike.digital%20profile%20email%20phone%20flow%20country&state=f1c16652262e464c98bbb158a4120ca6&ui_locales=en-HR&code_challenge=C40ejwklpvvn3ptVrg15EolfHOTLzPpNu5jNgira0Vo&code_challenge_method=S256", "Login redirect URL is incorrect.");
    }

    @AfterMethod
    public void teardown() {
        // Quit the driver after the test
        driver.quit();
    }
}
