package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CountSummary_Page extends Abstract_Class {


    ExtentTest logger;
    //selector
    By checkvariance = By.xpath("//div[contains(text(),'Check Variances')]");

    public CountSummary_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor


    public CountSummary_Page done_Button(){
        Reuseable_Library.click(driver,"(//ion-button[contains(text(),'Done')])[2]","Done Button",logger);
        return new CountSummary_Page(driver);

    }//end of method
    public CountSummary_Page doneJS_Button(){
        Reuseable_Library.click_JS(driver,"//*[contains(text(),'Done')]","Done Button",logger);
        return new CountSummary_Page(driver);

    }//end of method

    public CountSummary_Page share_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Share')]","Share Button",logger);
        return new CountSummary_Page(driver);

    }//end of method

    public CountSummary_Page countSummaryData_count(){
        Reuseable_Library.click(driver,"","Count Summary Data: Count",logger);
        return new CountSummary_Page(driver);
    }//end of method

    public CountSummary_Page countyData_Total(){
        Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[2]/td[2]","Count Summary Data: Total",logger);
        return new CountSummary_Page(driver);
    }//end of method

    public CountSummary_Page exit_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Exit')]","Exit Button",logger);
        return new CountSummary_Page(driver);
    }//end of method




}//end of mail class
