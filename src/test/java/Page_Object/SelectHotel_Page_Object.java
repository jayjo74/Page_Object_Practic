package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jayjo on 2/19/2017.
 */
public class SelectHotel_Page_Object extends General_Functions {
    WebDriver driver;
    WebDriverWait wait;

    By arriveDateBox = By.name("arr_date_0");
    By departureDateBox = By.name("dep_date_0");

    public SelectHotel_Page_Object(WebDriver driver){
        this.driver = driver;
    }

    public String get_arriveDateText(){
        String arriveDate = driver.findElement(arriveDateBox).getAttribute("value");
        return arriveDate;
    }

    public String get_departureDateText(){
        String deprtureDate = driver.findElement(departureDateBox).getAttribute("value");
        return deprtureDate;
    }



}
