package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;
    private By exitButton = By.xpath("//button[text() = 'Выход']");

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }
}
