package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SKULookUp_Page extends Abstract_Class {

    ExtentTest logger;

    //CSS selector
    By pagetitle = By.xpath("//*[@class='page-title']");
    By IMEISKUlookupsearchbox = By.xpath("//*[@class='native-input sc-ion-input-md']");
    By IMEISKULookUpSearchClick = By.xpath("//*[@class='mag-glass search-icon']");
    By adjustbutton = By.xpath("//ion-button[contains(text(),'Adjust')]");


    public SKULookUp_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public SKULookUp_Page page_Title() {
        //String pageTitle = Reuseable_Library.captureText(driver,"//*[@class='page-title']","Page Title",logger);
        Reuseable_Library.captureText(driver,"//*[@class='page-title']","Page Title",logger);
        return new SKULookUp_Page(driver);

    }//end of getLogin Method

    public SKULookUp_Page IMEISKULookUpSearch_Field(String userValue) {
        Reuseable_Library.userKeys(driver,"(//*[@class='native-input sc-ion-input-md'])[2]",userValue,"IMEI/SKU LookUp Search Field",logger);
        return new SKULookUp_Page(driver);
    }//end of getLogin Method

    public SKULookUp_Page IMEISKUlookupsearchField_Click() {
        Reuseable_Library.click(driver,"(//*[@class='mag-glass search-icon'])[2]","IMEI/SKU lookup search field click",logger);
        return new SKULookUp_Page(driver);

    }//end of getLogin Method

    public SKULookUp_Page adjust_Button() {
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Adjust')]","Adjust Button",logger);
        return new SKULookUp_Page(driver);

    }//end of getLogin Method









}//end of main class
