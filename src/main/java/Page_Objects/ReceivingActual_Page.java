package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReceivingActual_Page extends Abstract_Class {


    ExtentTest logger;

    // selector
    By enterItem = By.xpath("(//*[@class='native-input sc-ion-input-md'])[2]");
    By itemaddbutton = By.xpath("//*[@class='add-circle add-button']");
    By addtoinventory = By.xpath("//ion-button[contains(text(),'Add to Inventory')]");
    By nonserializedskuinput = By.xpath("//tbody/tr[1]/td[5]/input[1]");
    By continue_Button = By.xpath("//ion-button[contains(text(),'Continue')]");


    public ReceivingActual_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor

    public ReceivingActual_Page xyz(String userValue){
        Reuseable_Library.userKeys(driver,"",userValue,"",logger);
        return new ReceivingActual_Page(driver);
    }//end of method

    public ReceivingActual_Page zxy(){
        Reuseable_Library.click(driver,"","",logger);
        return new ReceivingActual_Page(driver);
    }//end of method

    public ReceivingActual_Page enterItem_Field(String userValue){
        Reuseable_Library.userKeys(driver,"(//*[@class='native-input sc-ion-input-md'])[2]",userValue,"Enter Item Field",logger);
        return new ReceivingActual_Page(driver);
    }//end of method

    public ReceivingActual_Page itemAdd_Button(){
        Reuseable_Library.click(driver,"//*[@class='add-circle add-button']","Item Add Button",logger);
        return new ReceivingActual_Page(driver);
    }//end of method

    public ReceivingActual_Page addToInventory_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Add to Inventory')]","Add to Inventory Button",logger);
        return new ReceivingActual_Page(driver);
    }//end of method


    public ReceivingActual_Page nonSerializedAKUInput_Field(String userValue){
        Reuseable_Library.userKeys(driver,"//tbody/tr[1]/td[5]/input[1]",userValue,"Non Serialized SKU input field",logger);
        return new ReceivingActual_Page(driver);
    }//end of method

    public ReceivingActual_Page continue_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Continue')]","Continue",logger);
        return new ReceivingActual_Page(driver);
    }//end of method

    public ReceivingActual_Page cancel_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Cancel')]","Cancel",logger);
        return new ReceivingActual_Page(driver);
    }//end of method

    public ReceivingActual_Page popUpOK_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Ok')]","OK on PopUp",logger);
        return new ReceivingActual_Page(driver);
    }//end of method



    public ReceivingActual_Page xinventoryDashboard(){
        Reuseable_Library.click(driver,"(//*[@class='xinventory-icon'])[2]","Xinventory Dashboard",logger);
        return new ReceivingActual_Page(driver);

    }//end of method

    public ReceivingActual_Page continuORxinventoryDashboard(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Continue')] OR (//*[@class='xinventory-icon'])[2]","Continue or Xinventory Dashboard",logger);
        return new ReceivingActual_Page(driver);

    }//end of method








}//end of main class
