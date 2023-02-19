package Test;

import Pages.*;
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

public class LogInTest {
    private WebDriver driver;
    final String EMAIL = "testUser@test.ru";
    final String PASSWORD = "testUser@test.ru";
    final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    public void logInMainPage(){
        MainPage mainPage = new MainPage(driver);
        LogInPage logInPage = new LogInPage(driver);

        mainPage.clickLogInButton();
        logInPage.logInUser(EMAIL, PASSWORD, driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }

    @Test
    public void logInAccountButton(){
        HeaderBar headerBar = new HeaderBar(driver);
        LogInPage logInPage = new LogInPage(driver);

        headerBar.clickAccountButton(false);
        logInPage.logInUser(EMAIL, PASSWORD, driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }

    @Test
    public void logInRegistrationPage(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LogInPage logInPage = new LogInPage(driver);

        registrationPage.clickLogIn();
        logInPage.logInUser(EMAIL, PASSWORD, driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }

    @Test
    public void logInForgotPasswordPage(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        LogInPage logInPage = new LogInPage(driver);

        forgotPasswordPage.clickLogIn();
        logInPage.logInUser(EMAIL, PASSWORD, driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
