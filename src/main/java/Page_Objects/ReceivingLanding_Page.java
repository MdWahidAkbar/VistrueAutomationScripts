package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReceivingLanding_Page extends Abstract_Class {


    ExtentTest logger;


    public ReceivingLanding_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);

        this.logger = super.logger;

    }//end of constructor


    public ReceivingLanding_Page xyz(String userValue){
        Reuseable_Library.userKeys(driver,"",userValue,"",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page zxy(){
        Reuseable_Library.click(driver,"","",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page activitySince_Tab(){
        Reuseable_Library.click_JS(driver,"(//*[@class='chevron-down status-chevron'])[1]","Activity Since Tab",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page past30_Days(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Past 30 Days')]","Past 30 Days",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page status_Tab(){
        Reuseable_Library.click(driver,"(//*[@class='chevron-down status-chevron'])[2] | //body/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-receiving[1]/app-receiving-overview[1]/ion-content[1]/app-main-content[1]/ion-grid[1]/ion-row[1]/ion-col[2]/div[1]/div[2]/app-dropdownbox[1]/i[1]","Status Tab",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page open(){
        Reuseable_Library.click(driver,"(//*[@class='dx-checkbox-container'])[3]","Open",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page closed(){
        Reuseable_Library.click(driver,"(//*[@class='dx-checkbox-container'])[5]","Closed",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page incomplete(){
        Reuseable_Library.click(driver,"(//*[@class='dx-checkbox-container'])[4]","Incomplete",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page apply(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Apply')]","Apply Button",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method

    public ReceivingLanding_Page carton_ID(){
        Reuseable_Library.click(driver,"//*[contains(@class,'main-receiving')]/tbody[1]/tr[1]/td[1]/span[1]","Carton ID",logger);
        return new ReceivingLanding_Page(driver);

    }//end of method


}//end of main class
