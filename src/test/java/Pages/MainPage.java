package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private By logInButton = By.xpath("//button[text() = 'Войти в аккаунт']");

    private By constructorBarBan = By.xpath("//span[text() = 'Булки']");
    private By constructorBarSauce = By.xpath("//span[text() = 'Соусы']");
    private By constructorBarFilling = By.xpath("//span[text() = 'Начинки']");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLogInButton(){
        driver.findElement(logInButton).click();
    }

    public void clickConstructorBarBan(){
        driver.findElement(constructorBarBan).click();
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void clickConstructorBarSauce(){
        driver.findElement(constructorBarSauce).click();
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void clickConstructorBarFilling(){
        driver.findElement(constructorBarFilling).click();
        new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
