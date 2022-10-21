package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShippingLanding_Page extends Abstract_Class {


    ExtentTest logger;

    //selector
    By newshipping = By.xpath("//span[contains(text(),'New Shipping')]");
    By pullback = By.xpath("(//*[contains(@class,'interactive hydrated')])[1]");
    By next = By.xpath("//ion-button[contains(text(),'Next')]");

    //We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public ShippingLanding_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public ShippingLanding_Page newShipping_Button(){
        Reuseable_Library.click(driver,"//span[contains(text(),'New Shipping')]","New Shipping Button",logger);
        return new ShippingLanding_Page(driver);

    }//end of method

    public ShippingLanding_Page pullBack(){
        Reuseable_Library.click(driver,"(//*[contains(@class,'interactive hydrated')])[1]","Pull Back",logger);
        return new ShippingLanding_Page(driver);

    }//end of method

    public ShippingLanding_Page pullBack_DEV(){
        Reuseable_Library.click(driver,"(//*[contains(@class,'interactive hydrated')])[2]","Pull Back",logger);
        return new ShippingLanding_Page(driver);

    }//end of method

    public ShippingLanding_Page returnDefective_DEV(){
        Reuseable_Library.click(driver,"(//*[contains(@class,'interactive hydrated')])[3]","Return Defective",logger);
        return new ShippingLanding_Page(driver);

    }//end of method

    public ShippingLanding_Page next_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next')]","Next Button",logger);
        return new ShippingLanding_Page(driver);

    }//end of method







}//end of main class
