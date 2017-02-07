package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by jayjo on 2/5/2017.
 */
public class SearchHotel_Page_Object {

    WebDriver driver;

    By pageCheck_Hello = By.name("username_show");
    By locationCBox = By.name("location");
    By hotelsCBox = By.name("hotels");
    By roomTypeCBox = By.name("room_type");
    By numRoomsCBox = By.name("room_nos");
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





}
