package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public P02_HomePage(SHAFT.GUI.WebDriver driver){this.driver=driver;}


    //Locators
    By adminTab = By.xpath("//a[@class=\"oxd-main-menu-item\"]//span[contains(.,'Admin')]");



    //Methods
    public P03_AdminPage clickOnAdminTab(){
        driver.element().click(adminTab);
        return new P03_AdminPage(driver);
    }

}
