package Test_Cases;

import Page_Object.LogIn_Page_Object;
import Page_Object.SearchHotel_Page_Object;
import Page_Object.SelectHotel_Page_Object;
import org.apache.log4j.PropertyConfigurator;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @BeforeMethod
    public void setUp() throws IOException {

        //Create Properties object
        p = new Properties();
        //Input file
        fi = new FileInputStream("C:\\Users\\jayjo\\Work_Space\\Page_Object_Practic\\src\\test\\java\\variable.properties");
        //load file in to properties
        p.load(fi);

        String url_value = p.getProperty("url");

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

//    @AfterMethod
//    public void closeURL() throws InterruptedException {
//        driver.quit();
//        Thread.sleep(4000);
//    }

    @Test
    public void TC_101(){

        String userName = p.getProperty("userID_value");
        String passwordName = p.getProperty("password_value");

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
        String userName = p.getProperty("userID_value");
        String passwordName = p.getProperty("password_value");
        String locationValue = p.getProperty("location_Value");
        String hotelValue = p.getProperty("hotel_value");
        String roomTypeValue = p.getProperty("roomType_value");
        String num_roomValue = p.getProperty("numberRoom_value");
        String adultPerRoomValue = p.getProperty("adultPerRoom_value");

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
        sh.selectRoomType(roomTypeValue);

        //select no of rooms  1
        sh.selectNumRoom(num_roomValue);
        //Launch hotel Enter check in date later than the check out date field as in test data - chekc in data - today +7, check out date -today +5

        //create check in and out time use Joda API
        DateTime today = new DateTime();
        DateTime checkInTime = today.plusDays(6);
        DateTime checkOutTime = today.plusDays(3);
        String checkInTimeValue = checkInTime.toString("dd/MM/yyyy");
        String checkOutTimeValue = checkOutTime.toString("dd/MM/yyyy");

            //Input check in date
            sh.setCheckInDate(checkInTimeValue);

            //Input check out date
            sh.setCheckOutDate(checkOutTimeValue);

        //Input Adult per room
        sh.setAdultRoomBox(adultPerRoomValue);

        //Click Search button
        sh.clickSerarchButton();

       //Verify that system give an error saying check in date should not be later than checkout data
        sh.verify_checkInSpan();

    }

    @Test
    public void TC_104(){

        String userName = p.getProperty("userID_value");
        String passwordName = p.getProperty("password_value");
        String locationValue = p.getProperty("location_Value");
        String hotelValue = p.getProperty("hotel_value");
        String roomTypeValue = p.getProperty("roomType_value");
        String num_roomValue = p.getProperty("numberRoom_value");
        String adultPerRoomValue = p.getProperty("adultPerRoom_value");
        String num_ChildsValue = p.getProperty("numberOfChild_value");

        LogIn_Page_Object li = new LogIn_Page_Object(driver);
        SearchHotel_Page_Object sh = new SearchHotel_Page_Object(driver);

//        2. Login to the application using username and password as in test data.
        li.setUserID(userName);
        li.setPassWord(passwordName);
        li.clickLogInButton();

//        3. Select location as in test data.  Location: Sydney
        sh.selectLocation(locationValue);

//        4. Select hotel as in test data. Hotel: Hotel Creek
        sh.selectHotel(hotelValue);

//        5. Select room type as in test data. Room type: standard
        sh.selectRoomType(roomTypeValue);

//        6. Select no-of-rooms as in test data. No-of-rooms:1
        sh.selectNumRoom(num_roomValue);

//        7. Enter check-out-date as in test data. Check-in-date: today’s  date Checko-utdate:today+1 date
        DateTime today = new DateTime();
        DateTime checkInTime = today.plusDays(1);
        DateTime checkOutTime = today.plusDays(2);
        String checkInTimeValue = checkInTime.toString("dd/MM/yyyy");
        String checkOutTimeValue = checkOutTime.toString("dd/MM/yyyy");

        sh.setCheckInDate(checkInTimeValue);
        sh.setCheckOutDate(checkOutTimeValue);

//        8. Select No-of-adults as in test data.No-of-adults:1
        sh.setAdultRoomBox(adultPerRoomValue);

//        9. Select No-of-children as in test data.No-of-children: 0
        sh.selectNumchild(num_ChildsValue);

//        10. Click on Search button.
        sh.clickSerarchButton();

//        11. Verify that hotel displayed is the same as selected in search Hotel form.
        sh.verify_SelectHotel_Page();

    }

    @Test
     public void TC_105(){

         String userName = p.getProperty("userID_value");
         String passwordName = p.getProperty("password_value");
         String locationValue = p.getProperty("location_Value");
         String hotelValue = p.getProperty("hotel_value");
         String roomTypeValue = p.getProperty("roomType_value");
         String num_roomValue = p.getProperty("numberRoom_value");
         String adultPerRoomValue = p.getProperty("adultPerRoom_value");
         String num_ChildsValue = p.getProperty("numberOfChild_value");

         LogIn_Page_Object li = new LogIn_Page_Object(driver);
         SearchHotel_Page_Object sh = new SearchHotel_Page_Object(driver);
         SelectHotel_Page_Object sl = new SelectHotel_Page_Object(driver);

//        2. Login to the application using username and password as in test data.
         li.setUserID(userName);
         li.setPassWord(passwordName);
         li.clickLogInButton();

//        3. Select location as in test data.  Location: Sydney
         sh.selectLocation(locationValue);

//        4. Select hotel as in test data. Hotel: Hotel Creek
         sh.selectHotel(hotelValue);

//        5. Select room type as in test data. Room type: standard
         sh.selectRoomType(roomTypeValue);

//        6. Select no-of-rooms as in test data. No-of-rooms:1
         sh.selectNumRoom(num_roomValue);

//        7. Enter check-out-date as in test data. Check-in-date: today’s  date Checko-utdate:today+1 date
         DateTime today = new DateTime();
         DateTime checkInTime = today.plusDays(1);
         DateTime checkOutTime = today.plusDays(2);
         String checkInTimeValue = checkInTime.toString("dd/MM/yyyy");
         String checkOutTimeValue = checkOutTime.toString("dd/MM/yyyy");

         sh.setCheckInDate(checkInTimeValue);
         sh.setCheckOutDate(checkOutTimeValue);

//        8. Select No-of-adults as in test data.No-of-adults:1
         sh.setAdultRoomBox(adultPerRoomValue);

//        9. Select No-of-children as in test data.No-of-children: 0
         sh.selectNumchild(num_ChildsValue);

//        10. Click on Search button.
         sh.clickSerarchButton();
         sh.verify_SelectHotel_Page();

//         11. Verify that check-indate and check-outdates are the same as selected in search hotel form.

        if (checkInTimeValue.equals(sl.get_arriveDateText())){
            Reporter.log("Verified check in date - "+checkInTimeValue,true);
        } else {
            Reporter.log("Check In date is not equle",true );
        }

         if (checkOutTimeValue.equals(sl.get_departureDateText())){
             Reporter.log("Verified check out date - "+checkOutTimeValue,true);
         } else {
             Reporter.log("Check In date is not equle",true );
         }



     }
}
