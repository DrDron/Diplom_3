package Test;

import Pages.HeaderBar;
import Pages.LogInPage;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogOutTest {
    private WebDriver driver;
    final String EMAIL = "testUser@test.ru";
    final String PASSWORD = "testUser@test.ru";
    private HeaderBar headerBar;
    private LogInPage logInPage;
    private ProfilePage profilePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    public void LogOutAccountTest(){
        headerBar = new HeaderBar(driver);
        logInPage = new LogInPage(driver);
        profilePage = new ProfilePage(driver);

        logInPage.logInUser(EMAIL,PASSWORD,driver);
        headerBar.clickAccountButton(true);
        profilePage.clickExitButton();

        headerBar.clickAccountButton(false);
        driver.findElement(By.xpath("//h2[text() = 'Вход']")).isDisplayed();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
