package Test;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogInTest {
    private WebDriver driver;
    final String EMAIL = "testUser@test.ru";
    final String PASSWORD = "testUser@test.ru";

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
        HeaderBar headerBar = new HeaderBar(driver);

        mainPage.clickLogInButton();
        logInPage.logInUser(EMAIL, PASSWORD, driver);
        headerBar.clickAccountButton(true);
        driver.findElement(By.xpath("//input[@value = '" + EMAIL.toLowerCase() + "']")).isDisplayed();
    }

    @Test
    public void logInAccountButton(){
        HeaderBar headerBar = new HeaderBar(driver);
        LogInPage logInPage = new LogInPage(driver);

        headerBar.clickAccountButton(false);
        logInPage.logInUser(EMAIL, PASSWORD, driver);

        headerBar.clickAccountButton(true);
        driver.findElement(By.xpath("//input[@value = '" + EMAIL.toLowerCase() + "']")).isDisplayed();
    }

    @Test
    public void logInRegistrationPage(){
        HeaderBar headerBar = new HeaderBar(driver);
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LogInPage logInPage = new LogInPage(driver);

        registrationPage.clickLogIn();
        logInPage.logInUser(EMAIL, PASSWORD, driver);

        headerBar.clickAccountButton(true);
        driver.findElement(By.xpath("//input[@value = '" + EMAIL.toLowerCase() + "']")).isDisplayed();
    }

    @Test
    public void logInForgotPasswordPage(){
        HeaderBar headerBar = new HeaderBar(driver);
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        LogInPage logInPage = new LogInPage(driver);

        forgotPasswordPage.clickLogIn();
        logInPage.logInUser(EMAIL, PASSWORD, driver);

        headerBar.clickAccountButton(true);
        driver.findElement(By.xpath("//input[@value = '" + EMAIL.toLowerCase() + "']")).isDisplayed();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
