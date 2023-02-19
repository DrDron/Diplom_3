package Test;

import Pages.HeaderBar;
import Pages.LogInPage;
import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransitionPageTest {
    private WebDriver driver;
    final String EMAIL = "testUser@test.ru";
    final String PASSWORD = "testUser@test.ru";
    final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        driver.get("https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    public void transitionToAccountPage(){
        HeaderBar headerBar = new HeaderBar(driver);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logInUser(EMAIL,PASSWORD,driver);

        headerBar.clickAccountButton(true);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(PROFILE_PAGE_URL));
    }

    @Test
    public void transitionFromAccountPageThroughConstructor(){
        HeaderBar headerBar = new HeaderBar(driver);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logInUser(EMAIL,PASSWORD,driver);
        headerBar.clickAccountButton(true);

        headerBar.clickConstructorButton();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }

    @Test
    public void transitionFromAccountPageThroughLogo(){
        HeaderBar headerBar = new HeaderBar(driver);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logInUser(EMAIL,PASSWORD,driver);
        headerBar.clickAccountButton(true);

        headerBar.clickLogoButton();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
