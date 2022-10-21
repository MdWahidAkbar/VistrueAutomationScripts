package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FORMAT extends Abstract_Class {


    ExtentTest logger;

    // selector
    By rememberme = By.xpath("//label[contains(text(),'Remember Me')]");
    By login = By.xpath("//button[contains(text(),'Log In')]");


    public FORMAT(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor


    public FORMAT SendKeys(String userValue){
        Reuseable_Library.userKeys(driver,"",userValue,"",logger);
        return new FORMAT(driver);
    }//end of method

    public FORMAT Click(){
        Reuseable_Library.click(driver,"","",logger);
        return new FORMAT(driver);
    }//end of method












}//end of main class
