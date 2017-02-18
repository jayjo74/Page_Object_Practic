package Page_Object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by jayjo on 2/5/2017.
 */
public class SearchHotel_Page_Object extends General_Functions{

    WebDriver driver;

    By pageCheck_Hello = By.name("username_show");
    By locationBox = By.name("location");
    By hotelsBox = By.name("hotels");
    By roomTypeBox = By.name("room_type");
    By numRoomsBox = By.name("room_nos");
    By checkInBox = By.name("datepick_in");
    By checkOutBox = By.name("datepick_out");
    By adultRoomCBox = By.name("adult_room");
    By childRoomCBox = By.name("child_room");
    By searchButton = By.name("Submit");
    By resetButton = By.name("Reset");


    //constroctor
    public SearchHotel_Page_Object(WebDriver driver){
        this.driver = driver;
    }

    public void selectLocation(String location) {
        //  new Select(driver.findElement(locationBox)).selectByVisibleText(location);
        select_DropDown_ByVisibleText(driver.findElement(locationBox), location);
        String acturalValue = get_SelectedOption(driver.findElement(locationBox));
        // System.out.println(acturalValue);
        //Assert.assertEquals(acturalValue,location);
        if (location.equals(acturalValue)) {
            Reporter.log("Location : " + location, true);
        } else {
            Reporter.log("Failed input the location : " + location);
        }
    }

    public void selectHotel(String hotel) {
        select_DropDown_ByVisibleText(driver.findElement(hotelsBox),hotel);
        String acturalValue = get_SelectedOption(driver.findElement(hotelsBox));

        if(hotel.equals(acturalValue)){
            Reporter.log("Hotel : "+hotel,true);
        }else {
            Reporter.log("Failed input the Hotel : "+hotel);
        }

    }

    public void selectRoomType(String room) {
        select_DropDown_ByVisibleText(driver.findElement(numRoomsBox),room);
        String acturalValue = get_SelectedOption(driver.findElement(numRoomsBox));

        if(room.equals(acturalValue)){
            Reporter.log("Room : "+room,true);
        }else {
            Reporter.log("Failed input the Room : "+room);
        }

    }


    public void selectNumRoom(String room) {
        select_DropDown_ByVisibleText(driver.findElement(numRoomsBox),room);
        String acturalValue = get_SelectedOption(driver.findElement(numRoomsBox));

        if(room.equals(acturalValue)){
            Reporter.log("Room : "+room,true);
        }else {
            Reporter.log("Failed input the Room : "+room);
        }

    }

}
