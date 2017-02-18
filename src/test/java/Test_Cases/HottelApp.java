package Test_Cases;

import Page_Object.LogIn_Page_Object;
import Page_Object.SearchHotel_Page_Object;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by jayjo on 2/4/2017.
 */
public class HottelApp {

    public static WebDriver driver = null;
    public static Properties p = null;
    public static FileInputStream fi = null;
    public String userName;
    public String passwordName;
    public String url_value;


    @BeforeTest
    public void setUp() throws IOException {

        //Create Properties object
        p = new Properties();
        //Input file
        fi = new FileInputStream("C:\\Users\\jayjo\\Work_Space\\Page_Object_Practic\\src\\test\\java\\variable.properties");
        //load file in to properties
        p.load(fi);

        url_value = p.getProperty("url");

        if(p.getProperty("browser").contains("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Selenium_Browsers\\Firefox_geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else if(p.getProperty("browser").contains("chrome"))
        {
            driver = new ChromeDriver();
        }
        else
        {
            //driver = new InternetExplorerDriver();
        }

        //read url data from property file
        driver.get(url_value);

        Reporter.log("Browser Opened with "+url_value);
        driver.manage().window().maximize();

    }

  //  @AfterTest
  //  public void closeURL(){
  //      driver.quit();
  //  }


    @Test
    public void TC_101(){

        userName = p.getProperty("userID_value");
        passwordName = p.getProperty("password_value");

        //Login to the application
        LogIn_Page_Object li = new LogIn_Page_Object(driver);

        li.setUserID(userName);
        //Reporter.log("Input username - "+userName,true);

        li.setPassWord(passwordName);
        //Reporter.log("Input password - "+passwordName,true);

        li.clickLogInButton();
        //Reporter.log("Clicked Log In button.",true);
    }

    @Test
    public void TC_102() {
        //login
        userName = p.getProperty("userID_value");
        passwordName = p.getProperty("password_value");
        String locationValue = p.getProperty("location_Value");
        String hotelValue = p.getProperty("hotel_value");
        String roomTypeValue = p.getProperty("roomType_value");
        String roomValue = p.getProperty("numberRoom_value");



        LogIn_Page_Object li = new LogIn_Page_Object(driver);
        SearchHotel_Page_Object sh = new SearchHotel_Page_Object(driver);

        li.setUserID(userName);
        li.setPassWord(passwordName);
        li.clickLogInButton();

        //select location Sydney
        sh.selectLocation(locationValue);

        //select hotel Hotel Creek
        sh.selectHotel(hotelValue);
        //select room type standard


        //select no of rooms  1
        sh.selectNumRoom(roomValue);
        //Launch hotel Enter check in date later than the check out date field as in test data - chekc in data - today +7, check out date -today +5

        //Verify that system give an error saying check in date should not be later than checkout data



    }


}
