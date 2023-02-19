package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderBar {
    private WebDriver driver;
    private By profileButton = By.xpath("//p[text() = 'Личный Кабинет']");
    private By constructorButton = By.xpath("//p[text() = 'Конструктор']");
    private By ordersButton = By.xpath("//p[text() = 'Лента Заказов']");
    private By logoButton =  By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");
    public HeaderBar(WebDriver driver){
        this.driver = driver;
    }

    public void clickAccountButton(Boolean isLoggedIn){
        driver.findElement(profileButton).click();
        if(isLoggedIn)
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/account/profile"));
        else
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }

    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }

    public void clickOrdersButton(){
        driver.findElement(ordersButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/feed"));
    }

    public void clickLogoButton(){
        driver.findElement(logoButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }
}
