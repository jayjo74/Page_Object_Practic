package Page_Object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by jayjo on 2/5/2017.
 */
public class SearchHotel_Page_Object extends General_Functions{

    WebDriver driver;
    WebDriverWait wait;

    By pageCheck_Hello = By.name("username_show");
    By locationBox = By.name("location");
    By hotelsBox = By.name("hotels");
    By roomTypeBox = By.name("room_type");
    By numRoomsBox = By.name("room_nos");
    By checkInBox = By.name("datepick_in");
    By checkOutBox = By.name("datepick_out");
    By adultRoomCBox = By.name("adult_room");
    By childRoomBox = By.name("child_room");
    By searchButton = By.name("Submit");
    By resetButton = By.name("Reset");
    By checkInSpan = By.id("checkin_span");
    By continueBtuoon = By.name("continue");

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
            Reporter.log("Failed input the Hotel : "+hotel,true);
        }

    }

    public void selectRoomType(String roomType) {
        select_DropDown_ByVisibleText(driver.findElement(roomTypeBox),roomType);
        String acturalValue = get_SelectedOption(driver.findElement(roomTypeBox));

        if(roomType.equals(acturalValue)){
            Reporter.log("Room type : "+roomType,true);
        }else {
            Reporter.log("Failed input the Room type : "+roomType,true);
        }
    }


    public void selectNumRoom(String room) {
        select_DropDown_ByVisibleText(driver.findElement(numRoomsBox),room);
        String acturalValue = get_SelectedOption(driver.findElement(numRoomsBox));

        if(room.equals(acturalValue)){
            Reporter.log("Number of room : "+room,true);
        }else {
            Reporter.log("Failed input the number of room : "+room,true);
        }

    }

    public void selectNumchild(String numChilds) {
        select_DropDown_ByVisibleText(driver.findElement(childRoomBox),numChilds);
        String acturalValue = get_SelectedOption(driver.findElement(childRoomBox));

        if(numChilds.equals(acturalValue)){
            Reporter.log("Number of child : "+numChilds,true);
        }else {
            Reporter.log("Failed input the number of child : "+numChilds,true);
        }

    }

    public void setCheckInDate(String checkInDate){
        driver.findElement(checkInBox).clear();
        driver.findElement(checkInBox).sendKeys(checkInDate);
        Reporter.log("Check In date : "+checkInDate,true);
    }

    public void setCheckOutDate(String checkOutDate){
        driver.findElement(checkOutBox).clear();
        driver.findElement(checkOutBox).sendKeys(checkOutDate);
        Reporter.log("Check Out date : "+checkOutDate,true);
    }


    public void setAdultRoomBox(String adultRoom){
        select_DropDown_ByVisibleText(driver.findElement(adultRoomCBox),adultRoom);
        String acturalValue = get_SelectedOption(driver.findElement(adultRoomCBox));

        if(acturalValue.equals(adultRoom)){
            Reporter.log("Adult per room : "+adultRoom,true);
        } else {
            Reporter.log("Failed input the Adult per room : "+adultRoom,true);
        }
    }

    public void clickSerarchButton(){
        driver.findElement(searchButton).click();
        Reporter.log("Clicked Search button",true);
    }

    public void verify_checkInSpan(){
        wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(checkInSpan));
            String spanMessage = driver.findElement(checkInSpan).getText();
            Reporter.log("Verify Message : "+spanMessage,true);
        } catch (Exception e){
            Reporter.log("Failed to verify message.",true);
        }
    }

    public void verify_SelectHotel_Page(){
        wait = new WebDriverWait(driver,20);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtuoon));
            Reporter.log("Successfuly moved to Select Hotel Page",true);

        } catch (Exception e){
            Reporter.log("Failed to verify the Select Hotel Page",true);
        }
    }

}
