package Test_Cases;

import Page_Object.LogIn_Page_Object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jayjo on 2/4/2017.
 */
public class HottelApp {

    public static WebDriver driver = null;
    public static String userName = null;
    public static String passwordName = null;

    @BeforeTest
    public void setUp() throws IOException {

        Properties p = new Properties();
        FileInputStream fi = new FileInputStream("C:\\Users\\jayjo\\workspace\\Page_Object_Practic\\src\\test\\java\\variable.properties");

        p.load(fi);

        if(p.getProperty("browser").contains("firefox")){
            driver = new FirefoxDriver();
        }
        else if(p.getProperty("browser").contains("chrome"))
        {
            driver = new ChromeDriver();
        }
        else
        {
            //driver = new InternetExplorerDriver();
        }

        userName = p.getProperty("userID_value");
        passwordName = p.getProperty("password_value");


     //   driver.get("http://adactin.com/HotelAppBuild2/");
        driver.get(p.getProperty("url"));
        driver.manage().window().maximize();

    }

  //  @AfterTest
  //  public void closeURL(){
  //      driver.quit();
  //  }


    @Test
    public void TC_101(){

        //Login to the application
        LogIn_Page_Object li = new LogIn_Page_Object(driver);

        li.setUserID("jayzzang");
        li.setPassWord("seattle123");
        li.clickLogInButton();

    }

    @Test
    public void TC_102(){
        //login

        LogIn_Page_Object li = new LogIn_Page_Object(driver);
        li.setUserID(userName);
        li.setPassWord(passwordName);
        li.clickLogInButton();

        //select location Sydney

        //select hotel Hotel Creek

        //select room type standard

        //select no of rooms  1

        //Launch hotel Enter check in date later than the check out date field as in test data - chekc in data - today +7, check out date -today +5

        //Verify that system give an error saying check in date should not be later than checkout data



    }


}
