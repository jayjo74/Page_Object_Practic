package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by jayjo on 2/16/2017.
 */
public class General_Functions {






    public void verify_ObjectText(WebElement element, String expectedText) {
           String currentTextValue = element.getText();
           if(currentTextValue.equals(expectedText)){
               System.out.println("Verified Object Text : "+expectedText);
           }else {
               System.out.println("Failed verity the Object Text : expected-"+expectedText+" ,actural-"+currentTextValue);
           }
    }

    public String get_SelectedOption(WebElement element) {
        Select select = new Select(element);
        WebElement selectedElement = select.getFirstSelectedOption();
        String selectedOption = selectedElement.getText();
        return selectedOption;
    }


    public void select_The_Checkbox(WebElement element) {
        try {
            if (element.isSelected()) {
                System.out.println("Checkbox: " + element + "is already selected");
            } else {
                // Select the checkbox
                element.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + element);
        }

    }

    public static void select_DropDown_ByVisibleText(WebElement element, String sVisibleTextOptionToSelect) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(sVisibleTextOptionToSelect);
        } catch (NoSuchElementException e) {
            System.out.println("Option value not find in dropdown");
        }
    }

    public static void select_DropDown_ByIndexVal(WebElement element, int indexVal) {
        try {
            Select select = new Select(element);
            select.selectByIndex(indexVal);
        } catch (NoSuchElementException e) {
            System.out.println("Value not find in dropdown");
        }
    }


    public static void select_DropDown_ByValue(WebElement element,String sValueTextToSelect ) {
        try {
            Select select = new Select(element);
            select.selectByValue(sValueTextToSelect);
        } catch (NoSuchElementException e) {
            System.out.println("Option value not find in dropdown");
        }
    }


    public static boolean verify_Values_In_Dropdown(List<WebElement> listOfElements, String[] strValues) {
        boolean bValue=false;
        List<String> list = new ArrayList<String>();
        for (String strValue : strValues) {
            boolean bflag = false;
            for (WebElement element : listOfElements) {
                String elementValue = element.getText();
                if (strValue.equals(elementValue)) {
                    bflag= true;
                }
            }
            if (!bflag)
                list.add(strValue);
        }
        if (list.size() > 0) {
            for(String strList : list) {
                System.out.println("Value not present in dropdown: "+strList);
            }
            //Assign false if any of the value not found in dropdown
            bValue = false;
        } else {
            //Assign true if all values found in dropdown
            System.out.println("All value(s) found in dropdown");
            bValue=true;
        }
        return bValue;
    }


    public void deSelect_The_Checkbox(WebElement element) {
        try {
            if (element.isSelected()) {
                //De-select the checkbox
                element.click();
            } else {
                System.out.println("Checkbox: "+element+"is already deselected");
            }
        } catch (Exception e) {
            System.out.println("Unable to deselect checkbox: "+element);
        }
    }


    public void select_The_CheckBox_from_List(WebElement element, String valueToSelect) {
        List<WebElement> allOptions = element.findElements(By.tagName("input"));
        for (WebElement option : allOptions) {
            System.out.println("Option value "+option.getText());
            if (valueToSelect.equals(option.getText())) {
                option.click();
                break;
            }
        }
    }

}

