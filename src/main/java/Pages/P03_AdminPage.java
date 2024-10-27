package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P03_AdminPage {
    SHAFT.GUI.WebDriver driver;
    static int originalNumberOfRecords, numberOfRecordsAfterAddingUser;

    //Constructor
    public P03_AdminPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //Locators
    By numberOfRecordsEle = By.xpath("//span[@class=\"oxd-text oxd-text--span\"] [contains(.,'Records')]");
    By addButton = By.xpath("//i[contains(@class,'oxd-button-icon')]//parent::button");
    By successMsg = By.xpath("//div[@class=\"oxd-toast-start\"]//p[contains(.,'Successfully Saved')]");


    //Methods
    public int getNumberOfRecords() {
        int numberOfRecords = Integer.parseInt(driver.element().getText(numberOfRecordsEle).replaceAll("[^0-9]",""));
        return numberOfRecords;
    }

    @Step("Get Original Number of Record before adding new user")
    public P03_AdminPage getOriginalRecords(){
    originalNumberOfRecords = getNumberOfRecords();
        System.out.println("Original Number Of Records Found: " + originalNumberOfRecords);
        return this;
    }

    public P03_AdminPage getNumberOfRecords_AfterAddingNewUser(){
        numberOfRecordsAfterAddingUser = getNumberOfRecords();
        System.out.println("Current Number Of Records Found After Adding new User: " + numberOfRecordsAfterAddingUser);
        return this;
    }

    public P04_AddNewUser clickOnAddBtn(){
        driver.element().click(addButton);
        return new P04_AddNewUser(driver);
    }

    public P03_AdminPage formSubmittedSuccessfully(){
        driver.element().assertThat(successMsg).exists().perform();
        return this;
    }

    public void numberOfRecord_IncreasedBy1(){
        SHAFT.Validations.verifyThat().object(numberOfRecordsAfterAddingUser).isEqualTo(originalNumberOfRecords +1).perform();
    }

}
