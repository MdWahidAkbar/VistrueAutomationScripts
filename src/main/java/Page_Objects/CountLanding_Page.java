package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CountLanding_Page extends Abstract_Class {

    ExtentTest logger;


    public CountLanding_Page (WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }//end of constructor

    public CountLanding_Page create_Count(){
        //Reuseable_Library.click(driver,"//*[@class='create-button-text']","Create Count",logger);
        Reuseable_Library.click_JS(driver,"//span[contains(text(),'Create Count')]","Create Count",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page weekly_Count(){
        Reuseable_Library.click(driver,"(//*[@class='md in-item interactive hydrated'])[1]","Weekly Count",logger);
        return new CountLanding_Page(driver);

    }//end of method
    public CountLanding_Page corrective_Count(){
        Reuseable_Library.click(driver,"(//*[@class='md in-item interactive hydrated'])[2]","Corrective Count",logger);
        return new CountLanding_Page(driver);

    }//end of method


    public CountLanding_Page physical_Count(){
        Reuseable_Library.click(driver,"(//*[@class='md in-item interactive hydrated'])[3]","Physical Count",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page returnDefective_Count(){
        Reuseable_Library.click(driver,"(//*[@class='md in-item interactive hydrated'])[4]","Return-Defective Count",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page upgradeTradeIn_Count(){
        Reuseable_Library.click(driver,"(//*[@class='md in-item interactive hydrated'])[5]","Upgrade_TradeIn Count",logger);
        return new CountLanding_Page(driver);

    }//end of method


    public CountLanding_Page next_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next')]","Next",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page count_Link(){
        Reuseable_Library.click_JS(driver,"//*[@class='link-out']","Count Link Icon",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page firstTranNum(){
        Reuseable_Library.click_JS(driver,"(//*[@role='rowgroup'])[5]/tr[1]/td[2]/span","Click on TranNum",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page specificTranNum(String tranNum){
        Reuseable_Library.click(driver,"//*[contains(text(),'"+tranNum+"')]","Click on TranNum : '"+tranNum+"'",logger);
        //*[contains(text(),'22000B124')]
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page activitySince_Tab(){
        Reuseable_Library.click(driver,"(//*[@class='chevron-down status-chevron'])[1]","Activity Since Tab",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page past30_Days(){
        Reuseable_Library.click_JS(driver,"//div[contains(text(),'Past 30 Days')]","Past 30 Days",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page countType_Tab(){
        //Reuseable_Library.click_JS(driver,"(//*[@class='chevron-down status-chevron'])[3]","Count Type",logger);
        Reuseable_Library.click_JS(driver,"//body/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-reconciliation[1]/app-reconciliation-overview[1]/ion-content[1]/app-main-content[1]/ion-grid[1]/ion-row[1]/ion-col[2]/div[1]/div[3]/app-dropdownbox[1]/i[1]","Count Type",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page pysicalCount(){
        //Reuseable_Library.click(driver,"(//*[@class='dx-checkbox-container'])[4]","Physical Count",logger);
        Reuseable_Library.click(driver,"//div[contains(text(),'Physical Count')]","Physical Count",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page apply(){
        Reuseable_Library.click_JS(driver,"//ion-button[contains(text(),'Apply')]","Apply Button",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page checkVariance_Button(){
        Reuseable_Library.click(driver,"//body/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-reconciliation[1]/app-reconciliation-overview[1]/ion-content[1]/app-reconciliation-overview-buttons[1]/div[1]/ion-button[2]","Check Variance Button",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page void_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Void')]","Void Button",logger);
        return new CountLanding_Page(driver);

    }//end of method

    public CountLanding_Page confirm_void_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Continue')]","Confirm for Void",logger);
        return new CountLanding_Page(driver);

    }//end of method










}//end of mail class
