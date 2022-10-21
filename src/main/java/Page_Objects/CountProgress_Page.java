package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CountProgress_Page extends Abstract_Class {


    ExtentTest logger;
    //selector
    By checkvariance = By.xpath("//div[contains(text(),'Check Variances')]");

    public CountProgress_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public CountProgress_Page checkVariance_Button(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Check Variances')]","Check Variance Button",logger);
        return new CountProgress_Page(driver);

    }//end of method


    public CountProgress_Page void_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Void')]","Void Button",logger);
        return new CountProgress_Page(driver);

    }//end of method

    public CountProgress_Page continue_void_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Continue')]","Confirm for Void",logger);
        return new CountProgress_Page(driver);

    }//end of method




}//end of mail class
