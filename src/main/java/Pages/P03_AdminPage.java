package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import javax.ws.rs.PUT;

public class P03_AdminPage {
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public P03_AdminPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //Locators
    By numberOfRecordsEle = By.xpath("//span[@class=\"oxd-text oxd-text--span\"] [contains(.,'Records')]");
    By addButton = By.xpath("//i[contains(@class,'oxd-button-icon')]//parent::button");

    //Methods
    public void getNumberOfRecords() {
        String txt = driver.element().getText(numberOfRecordsEle).replaceAll("[^0-9]","");
        System.out.println("Number of Records Found: " + txt);
    }

    public P04_AddNewUser clickOnAddBtn(){
        driver.element().click(addButton);
        return new P04_AddNewUser(driver);
    }

}
