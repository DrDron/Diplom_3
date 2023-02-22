package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By logInLink = By.xpath("//a[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLogIn(){
        driver.findElement(logInLink).click();
    }
}
