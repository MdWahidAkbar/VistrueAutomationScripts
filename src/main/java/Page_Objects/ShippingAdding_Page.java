package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShippingAdding_Page extends Abstract_Class {


    ExtentTest logger;

    //We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public ShippingAdding_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    //method for user ID field
    public ShippingAdding_Page enterSKUIMEI(String userValue){
        Reuseable_Library.userKeys(driver,"(//*[@class='native-input sc-ion-input-md'])[2]",userValue,"Enter SKU/IMEI Field ",logger);
        return new ShippingAdding_Page(driver);

    }//end of method

    public ShippingAdding_Page add_Button(){
        Reuseable_Library.click(driver,"//*[@class='add-circle add-button']","Add Button",logger);
        return new ShippingAdding_Page(driver);

    }//end of method

    public ShippingAdding_Page nonSerializededit_Field(String userKey){
        Reuseable_Library.userKeys(driver,"(//*[@class='native-input sc-ion-input-md'])[3]",userKey,"Non-Serialized Edit Button",logger);
        return new ShippingAdding_Page(driver);

    }//end of method

    public ShippingAdding_Page shippingDetaild_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Shipping Details')]","Shipping Details Button",logger);
        return new ShippingAdding_Page(driver);

    }//end of method

    public ShippingAdding_Page submit_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Submit')]","Submit Button",logger);
        return new ShippingAdding_Page(driver);

    }//end of method

    public ShippingAdding_Page void_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Void')]","Void Button",logger);
        return new ShippingAdding_Page(driver);

    }//end of method

    public ShippingAdding_Page continue_void(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Continue')]","Continue for Void",logger);
        return new ShippingAdding_Page(driver);

    }//end of method




}//end of main class
