package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page extends Abstract_Class {

    ExtentTest logger;

    //selector
    By sitevisibility = By.xpath("//*[@id='cbp-thmenu-vis']");
    By sitevisibilitysearchbox = By.xpath("//*[@id='select2-slVisSearch-container']");
    By sitevisibilitysearchboxinput= By.xpath("//*[@class='select2-search__field']");
    By xinventory= By.xpath("//a[contains(text(),'Inventory 2.0')]");
    By dashboardpage= By.xpath("//a[contains(text(),'Dashboard Page')]");


    //For DEV............
    By DEV_XinventoryTab= By.xpath("(//*[contains(text(),'Xinventory')])[1]");
    By DEV_XinventoryToXMPage= By.xpath("(//*[contains(text(),'Xinventory')])[3]");




    public Landing_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public Landing_Page site_Visibility(){
        Reuseable_Library.click(driver,"//*[@id='cbp-thmenu-vis']","Site Visibility",logger);
        return new Landing_Page(driver);
        //the driver that I used is returning you tha same Yahoo_Homepage

    }//end of method

    public Landing_Page site_Visibility_SearchBox(){
        Reuseable_Library.click(driver,"//*[@id='select2-slVisSearch-container']","Site Visibility search field",logger);
        return new Landing_Page(driver);
        //the driver that I used is returning you tha same Yahoo_Homepage

    }//end of method

    public Landing_Page site_Visibility_Input(String SiteVisibility){
        Reuseable_Library.userKeys(driver,"//*[@class='select2-search__field']",SiteVisibility,"Enter Site for Visibility",logger);
        return new Landing_Page(driver);
        //the driver that I used is returning you tha same Yahoo_Homepage

    }//end of method

    public Landing_Page site_Visibility_Click(){
        Reuseable_Library.KeyDownAndEnter(driver,"//*[@class='select2-search__field']","Site Visibility Click",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page site_Visibility_findClick(String SiteVisibility){
        Reuseable_Library.click(driver,"//li[contains(text(),'"+SiteVisibility+"')]","Site Visibility Find and Click",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page xinventory(){
        Reuseable_Library.click(driver,"//a[contains(text(),'Inventory 2.0')]","XInventory",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page dashboard(){
        Reuseable_Library.click(driver,"//a[contains(text(),'Dashboard Page')]","Dashboard",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page Dev_XinventoryTab(){
        Reuseable_Library.click(driver,"(//*[contains(text(),'Xinventory')])[1]","Xinventory 2.0",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page Dev_XinventoryToXM_page(){
        Reuseable_Library.click(driver,"(//*[contains(text(),'Xinventory')])[3]","Xinventory to XM page",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page pharos_Transaction(){
        Reuseable_Library.click(driver,"(//*[text()='Transactions'])[2]","Transaction 2 Tab in Pharos",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page pharos_TransactionDEV(){
        Reuseable_Library.click_JS(driver,"//*[text()='Inventory']","Inventory Tab in Pharos",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page pharos_TransactionTest(){
        Reuseable_Library.click(driver,"//*[@id='Transactions']/a","Transaction Tab in Pharos",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page pharon_CurrentTransaction(){
        Reuseable_Library.click(driver,"//*[text()='Current Transactions']","Current Transaction",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page pharos_receive(){
        Reuseable_Library.click(driver,"//*[@id='MintekLabel1']","TRC",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page pharos_Menu_Bar(){
        Reuseable_Library.click(driver,"/html[1]/body[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/h5[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]","Menu for Log Out",logger);
        return new Landing_Page(driver);
    }//end of method

    public Landing_Page pharos_LogOut(){
        Reuseable_Library.click(driver,"//a[contains(text(),'Logoff')]","Log Out",logger);
        return new Landing_Page(driver);
    }//end of method






















}//end of main class
