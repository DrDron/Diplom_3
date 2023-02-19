package Test;

import Pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    private WebDriver driver;
    Faker faker = new Faker();
    final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";


    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    public void userRegistrationWithInvalidPassword(){
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setNameField(faker.name().lastName());
        registrationPage.setEmailField(faker.internet().emailAddress());
        registrationPage.setPasswordField(faker.internet().password(1,5));
        registrationPage.clickRegistrationButton();

        driver.findElement(By.xpath("//p[text() = 'Некорректный пароль']")).isDisplayed();
    }

    @Test
    public void userRegistration(){
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setNameField(faker.name().lastName());
        registrationPage.setEmailField(faker.internet().emailAddress());
        registrationPage.setPasswordField(faker.internet().password(6,10));
        registrationPage.clickRegistrationButton();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
