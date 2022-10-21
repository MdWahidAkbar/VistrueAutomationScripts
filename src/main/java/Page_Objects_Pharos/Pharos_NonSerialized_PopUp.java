package Page_Objects_Pharos;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pharos_NonSerialized_PopUp extends Abstract_Class {


    ExtentTest logger;

    public Pharos_NonSerialized_PopUp(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor


    public Pharos_NonSerialized_PopUp fromLocation(String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtLocationLookupID']",userValue,"From Location",logger);//txtLocationLookupID
        return new Pharos_NonSerialized_PopUp(driver);
    }//end of method

    public Pharos_NonSerialized_PopUp model(String userValue){
        Reuseable_Library.userKeys(driver,"//input[@id='txtModelLookupDescription']",userValue,"Model",logger);
        return new Pharos_NonSerialized_PopUp(driver);
    }//end of method

    public Pharos_NonSerialized_PopUp quantity(String userValue){
        Reuseable_Library.userKeys(driver,"//input[@id='txtQuantity']",userValue,"Quantity",logger);
        return new Pharos_NonSerialized_PopUp(driver);
    }//end of method

    public Pharos_NonSerialized_PopUp add(){
        Reuseable_Library.click(driver,"//*[@type='submit']","Add",logger);
        return new Pharos_NonSerialized_PopUp(driver);
    }//end of method

    public Pharos_NonSerialized_PopUp saveForLater(){
        Reuseable_Library.click(driver,"//*[@id='PopupToolbar_lbl_custom_btnUpdate']","Save for Later",logger);
        return new Pharos_NonSerialized_PopUp(driver);
    }//end of method












}//end of main class
