package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Abstract_Class {


    ExtentTest logger;

    // selector
    By email = By.cssSelector("#txtUsername");
    By password = By.cssSelector("#txtPassword");
    By rememberme = By.xpath("//label[contains(text(),'Remember Me')]");
    By login = By.xpath("//button[contains(text(),'Log In')]");

    //We need a contractor method that define
    //driver and logger to be reuse locally to this page class
    public Login_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    //method for user ID field
    public Login_Page userID(String userID){
        Reuseable_Library.userKeys(driver,"//*[@id='txtUsername']",userID,"User ID",logger);
        return new Login_Page(driver);

    }//end of method

    public Login_Page userPass(String userPass){
        Reuseable_Library.userKeys(driver,"//*[@id='txtPassword']",userPass,"User PassWord",logger);
        return new Login_Page(driver);

    }//end of method

    public Login_Page rememberMe(){
        Reuseable_Library.click(driver,"//*[@class='css-label']","Remember Me",logger);
        return new Login_Page(driver);

    }//end of method

    public Login_Page logInButton(){
        Reuseable_Library.click(driver,"//*[contains(text(),'Log In')]","Login Button",logger);
        return new Login_Page(driver);

    }//end of method



}//end of main class
