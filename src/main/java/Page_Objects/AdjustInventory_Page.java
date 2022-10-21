package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdjustInventory_Page extends Abstract_Class {

    ExtentTest logger;


    public AdjustInventory_Page (WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;
    }//end of constructor


    public AdjustInventory_Page available_from_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location from-location md hydrated']/span[1]/ion-item/tr-ion-radio/ion-radio","From Available bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page returnDefective_from_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location from-location md hydrated']/span[2]/ion-item/tr-ion-radio/ion-radio","From Return Defective Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page upgradeTradeIn_from_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location from-location md hydrated']/span[3]/ion-item/tr-ion-radio/ion-radio","From Upgrade TradeIn Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page lost_from_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location from-location md hydrated']/span[4]/ion-item/tr-ion-radio/ion-radio","From Lost Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page reserved_from_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location from-location md hydrated']/span[5]/ion-item/tr-ion-radio/ion-radio","From Reserved Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method



    public AdjustInventory_Page available_To_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location to-location md hydrated']/span[1]/ion-item/tr-ion-radio/ion-radio","To Available Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page returnDefective_to_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location to-location md hydrated']/span[2]/ion-item/tr-ion-radio/ion-radio","To Return Defective Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page UpgradeTradeIn_to_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location to-location md hydrated']/span[3]/ion-item/tr-ion-radio/ion-radio","To Upgrade TradeIn Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page lost_to_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location to-location md hydrated']/span[4]/ion-item/tr-ion-radio/ion-radio","To Lost Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page reserved_to_Bucket() {
        Reuseable_Library.click(driver,"//*[@class='location to-location md hydrated']/span[5]/ion-item/tr-ion-radio/ion-radio","To Reserved Bucket",logger);
        return new AdjustInventory_Page(driver);

    }//end Method


    public AdjustInventory_Page amountToBe_Adjusted() {
        Reuseable_Library.click(driver,"//*[@class='add-circle button']","Amount to be Adjusted",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page reasonForSerialized() {
        Reuseable_Library.click(driver,"(//*[@class='chevron-down status-chevron'])[1]","Reason",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page reasonForNonSerialized() {
        Reuseable_Library.click(driver,"(//*[@class='chevron-down status-chevron'])[2]","Reason",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page selecting_reason() {
        Reuseable_Library.click(driver,"//*[text()='Item was miscounted']","Item Was Miscounted",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page adjustInventory_Button() {
        Reuseable_Library.click(driver,"//*[contains(@class,'complete-button')]","Adjust Inventory Button",logger);
        return new AdjustInventory_Page(driver);

    }//end Method

    public AdjustInventory_Page submitAdjustment_Button() {
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Submit Adjustment')]","Submit Adjust Button",logger);
        return new AdjustInventory_Page(driver);

    }//end Method







}//end of mail class
