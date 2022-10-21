package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PackingSlipandLabel_Page extends Abstract_Class {


    ExtentTest logger;

    //selector
    By newshipping = By.xpath("//ion-button[contains(text(),'Done')]");


    //We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public PackingSlipandLabel_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public PackingSlipandLabel_Page done_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Done')]","Done Button on Packing Slip and Label Page",logger);
        return new PackingSlipandLabel_Page(driver);

    }//end of method









}//end of main class
