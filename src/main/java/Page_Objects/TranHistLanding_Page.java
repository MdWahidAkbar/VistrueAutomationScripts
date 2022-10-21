package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TranHistLanding_Page extends Abstract_Class {

    ExtentTest logger;


    public TranHistLanding_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }//end of constructor


    public TranHistLanding_Page Status_Tab(){
        Reuseable_Library.click(driver,"(//*[@class='chevron-down status-chevron'])[1]","Status Tab",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page completed(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Completed')]","Completed",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page activity_Since(){
        Reuseable_Library.click(driver,"(//*[@class='chevron-down status-chevron'])[1]","Activity Since",logger);
        return new TranHistLanding_Page(driver);

    }//end of method



    public TranHistLanding_Page custom(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Custom')]","Custom",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page previousMonth(){
        Reuseable_Library.click(driver,"//*[@class='dx-icon dx-icon-chevronleft']","Previous Month",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page nextMonth(){
        Reuseable_Library.click(driver,"//*[@class='dx-icon dx-icon-chevronright']","Next Month",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page date_1_PreviousMonth(){
        Reuseable_Library.click(driver,"(//*[text()='10'])[1]","10th Day of the Previous Month",logger);
        return new TranHistLanding_Page(driver);

    }//end of method


    public TranHistLanding_Page date_25_CurrentMonth(){
        Reuseable_Library.click(driver,"(//*[text()='25'])[1]","25th Day of the Current Month",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page continue_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Continue')]","Continue Button",logger);
        return new TranHistLanding_Page(driver);

    }//end of method


    public TranHistLanding_Page type(){
        Reuseable_Library.click(driver,"(//*[@class='chevron-down status-chevron'])[3]","Transaction Type",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page returnDefective_CountType(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Count (Return Bucket Count')]","Return Defective Count Type",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page upgradeTradeIn_CountType(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Count (Upgrade Bucket Count')]","Upgrade TradeIn Count Type",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page weekly_CountType(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Count (Weekly Cycle Count')]","Weekly Count Type",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page physical_CountType(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Count (Physical Count')]","Physical Count Type",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page apply(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Apply')]","Apply Button",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page checkbox1(){
        Reuseable_Library.click(driver,"(//*[@type='checkbox'])[2]","Checkbox 1 ",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page checkbox2(){
        Reuseable_Library.click(driver,"(//*[@type='checkbox'])[3]","Checkbox 2 ",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page checkbox3(){
        Reuseable_Library.click(driver,"(//*[@type='checkbox'])[4]","Checkbox 3 ",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page checkbox4(){
        Reuseable_Library.click(driver,"(//*[@type='checkbox'])[5]","Checkbox 4 ",logger);
        return new TranHistLanding_Page(driver);

    }//end of method

    public TranHistLanding_Page shareModal(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Share')]","Share Modal",logger);
        return new TranHistLanding_Page(driver);

    }//end of method












}//end of mail class
