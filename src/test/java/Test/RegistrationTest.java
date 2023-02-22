package Test;

import Pages.HeaderBar;
import Pages.LogInPage;
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

public class RegistrationTest {
    private WebDriver driver;
    Faker faker = new Faker();

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
        HeaderBar headerBar = new HeaderBar(driver);
        LogInPage logInPage = new LogInPage(driver);
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(6,10);

        registrationPage.setNameField(faker.name().lastName());
        registrationPage.setEmailField(email);
        registrationPage.setPasswordField(password);
        registrationPage.clickRegistrationButton();

        headerBar.clickAccountButton(false);
        logInPage.logInUser(email,password,driver);
        headerBar.clickAccountButton(true);

        driver.findElement(By.xpath("//input[@value = '" + email.toLowerCase() + "']")).isDisplayed();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
