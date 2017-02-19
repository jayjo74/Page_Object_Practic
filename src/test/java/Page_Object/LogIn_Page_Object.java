package Page_Object;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by jayjo on 2/4/2017.
 */
public class LogIn_Page_Object {


    WebDriver driver;
    WebDriverWait wait;

    By userID = By.name("username");
    By passWord = By.name("password");
    By loginButton = By.name("login");
    By searchLocation = By.name("location");

    //constroctor
    public LogIn_Page_Object(WebDriver driver){
        this.driver = driver;
    }

    public void setUserID(String user){
        driver.findElement(userID).clear();
        driver.findElement(userID).sendKeys(user);
        Reporter.log("Log in user : "+user,true);
           }

    public void setPassWord(String pass){
        driver.findElement(passWord).clear();
        driver.findElement(passWord).sendKeys(pass);
        Reporter.log("Log in password : "+pass,true);
         }

    public void clickLogInButton(){
        driver.findElement(loginButton).click();
        Reporter.log("Clicked Log in button.",true);
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocation));
        Reporter.log("Successfuly logged in",true);
    }



}
