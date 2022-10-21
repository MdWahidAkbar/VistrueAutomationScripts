package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Menu_Bar extends Abstract_Class {


    ExtentTest logger;

    // selector
    By menubar = By.xpath("//*[@class = 'menu-gray']");
    By storeinventory = By.xpath("//span[contains(text(),'Store Inventory')]");


    public Menu_Bar(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor


    public Menu_Bar xyz(String userValue){
        Reuseable_Library.userKeys(driver,"",userValue,"",logger);
        return new Menu_Bar(driver);
    }//end of method

    public Menu_Bar zxy(){
        Reuseable_Library.click(driver,"","",logger);
        return new Menu_Bar(driver);
    }//end of method

    public Menu_Bar menu_Bar(){
        Reuseable_Library.mouseClick(driver,"//*[@class = 'menu-gray']","Menu Bar",logger);
        return new Menu_Bar(driver);
    }//end of method

    public Menu_Bar menu_Bar_ForMenuOn2ndPageMenu(){
        Reuseable_Library.mouseClick(driver,"(//ion-toolbar[1]/div[2]/i[1])[2]","Menu Bar",logger);
        return new Menu_Bar(driver);
    }//end of method

    public Menu_Bar menu_Bar_ForMenuOn12345PageMenu(){
        Reuseable_Library.mouseClick(driver,"","Menu Bar",logger);
        return new Menu_Bar(driver);
    }//end of method


    public Menu_Bar dashboard(){
        Reuseable_Library.click(driver,"//*[contains(text(),'Dashboard ')]","Dashboard",logger);
        return new Menu_Bar(driver);
    }//end of method

    public Menu_Bar store_Inventory(){
        Reuseable_Library.mouseClick(driver,"//span[contains(text(),'Store Inventory')]","Store Inventory",logger);
        return new Menu_Bar(driver);
    }//end of method

    public Menu_Bar transaction_History(){
        Reuseable_Library.mouseClick(driver,"//span[contains(text(),'Transaction History')]","Transaction History",logger);
        return new Menu_Bar(driver);
    }//end of method

    public Menu_Bar logOut(){
        Reuseable_Library.mouseClick(driver,"//span[contains(text(),'Logout')]","Log Out",logger);
        return new Menu_Bar(driver);
    }//end of method














}//end of main class
