package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class XinventoryDashboard_Page extends Abstract_Class {

    ExtentTest logger;

    //selector
    By xinventorydashboard = By.xpath("(//*[@class='xinventory-icon'])[2]");
    By IMEISKULookUpSearchBox = By.xpath("//*[@class='native-input sc-ion-input-md']");
    By IMEISKULookUpSearchClick = By.xpath("//*[@class='icon']");
    By count = By.xpath("//*[@class='count-icon module-icon']");
    By receiving = By.xpath("//div[contains(text(),'Receiving')]");
    By shipping = By.xpath("//div[contains(text(),'Shipping')]");

    public XinventoryDashboard_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }//end of constructor

    public XinventoryDashboard_Page xinventoryDashboard(){
        Reuseable_Library.click(driver,"(//*[@class='xinventory-icon'])[3]","Xinventory Dashboard",logger);
        return new XinventoryDashboard_Page(driver);

    }//end of method

    public XinventoryDashboard_Page XinventoryOnXinventoryDashboard(){
        Reuseable_Library.click(driver,"//*[contains(@class,'xinventory')]","Xinventory on Xinventory Dashboard",logger);
        return new XinventoryDashboard_Page(driver);

    }//end of method

    public XinventoryDashboard_Page IMEISKULookUpSearch_Field(String userValue){
        Reuseable_Library.userKeys(driver,"//*[@class='native-input sc-ion-input-md']",userValue,"IMEI/SKU/LookUp/Search Field",logger);
        return new XinventoryDashboard_Page(driver);

    }//end of method

    public XinventoryDashboard_Page IMEISKULookUpSearchField_Click(){
        Reuseable_Library.click(driver,"//*[@class='icon']","IMEI/SKU LookUp Search Field Click",logger);
        return new XinventoryDashboard_Page(driver);

    }//end of method


    public XinventoryDashboard_Page count(){
        Reuseable_Library.click_JS(driver,"//*[@class='count-icon module-icon']","Count",logger);
        return new XinventoryDashboard_Page(driver);

    }//end of method

    public XinventoryDashboard_Page shipping(){
        Reuseable_Library.click_JS(driver,"//div[contains(text(),'Shipping')]","Shipping",logger);
        return new XinventoryDashboard_Page(driver);

    }//end of method

    public XinventoryDashboard_Page receiving(){
        Reuseable_Library.click(driver,"//div[contains(text(),'Receiving')]","Receiving",logger);
        return new XinventoryDashboard_Page(driver);

    }//end of method




}//end of mail class
