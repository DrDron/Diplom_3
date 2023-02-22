package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    private WebDriver driver;
    private By emailField = By.xpath("//label[text() = 'Email']/following-sibling::input");
    private By passwordField = By.xpath("//input[@name = 'Пароль']");
    private By logInButton = By.xpath("//button[text() = 'Войти']");

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailField(String value){
        driver.findElement(emailField).sendKeys(value);
    }

    public void setPasswordField(String value){
        driver.findElement(passwordField).sendKeys(value);
    }

    public void clickLogInButton(){
        driver.findElement(logInButton).click();
    }

    public void logInUser(String email, String password, WebDriver driver){
        LogInPage logInPage = new LogInPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/login"));
        logInPage.setEmailField(email);
        logInPage.setPasswordField(password);
        logInPage.clickLogInButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }
}
