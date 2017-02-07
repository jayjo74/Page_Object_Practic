package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jayjo on 2/4/2017.
 */
public class LogIn_Page_Object {


    WebDriver driver;
    WebDriverWait wait;

    By userID = By.name("username");
    By passWord = By.name("password");
    By loginButton = By.name("login");

    //constroctor
    public LogIn_Page_Object(WebDriver driver){

        this.driver = driver;

    }

    public void setUserID(String user){
        driver.findElement(userID).sendKeys(user);
    }

    public void setPassWord(String pass){
        driver.findElement(passWord).sendKeys(pass);
    }

    public void clickLogInButton(){
        driver.findElement(loginButton).click();
    }



}
