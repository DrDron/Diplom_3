package Test;

import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConstructorTransitionsTest {
    private WebDriver driver;
    private MainPage mainPage;

    final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        driver.get(MAIN_PAGE_URL);
    }

    @Test
    public void constructorTransitionBun(){
        mainPage = new MainPage(driver);

        mainPage.clickConstructorBarFilling();
        mainPage.clickConstructorBarBan();

        driver.findElement(By.xpath("//div[contains(@class, 'current')]/span[text() = 'Булки']")).isDisplayed();
    }

    @Test
    public void constructorTransitionSauce(){
        mainPage = new MainPage(driver);

        mainPage.clickConstructorBarSauce();

        driver.findElement(By.xpath("//div[contains(@class, 'current')]/span[text() = 'Соусы']")).isDisplayed();
    }

    @Test
    public void constructorTransitionFilling(){
        mainPage = new MainPage(driver);

        mainPage.clickConstructorBarFilling();

        driver.findElement(By.xpath("//div[contains(@class, 'current')]/span[text() = 'Начинки']")).isDisplayed();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
