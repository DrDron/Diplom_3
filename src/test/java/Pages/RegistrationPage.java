package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    private By nameField = By.xpath("//label[text() = 'Имя']/following-sibling::input");
    private By emailField = By.xpath("//label[text() = 'Email']/following-sibling::input");
    private By passwordField = By.xpath("//input[@name = 'Пароль']");
    private By logInLink = By.xpath("//a[text() = 'Войти']");

    private By registrationButton = By.xpath("//button[text() = 'Зарегистрироваться']");

    public RegistrationPage(WebDriver webDriver){
        this.driver = webDriver;
    }

    public void setNameField(String value){
        driver.findElement(nameField).sendKeys(value);
    }

    public void setEmailField(String value){
        driver.findElement(emailField).sendKeys(value);
    }

    public void setPasswordField(String value){
        driver.findElement(passwordField).sendKeys(value);
    }

    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    public void clickLogIn(){
        driver.findElement(logInLink).click();
    }
}
