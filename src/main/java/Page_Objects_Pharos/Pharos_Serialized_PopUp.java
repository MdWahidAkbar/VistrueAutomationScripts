package Page_Objects_Pharos;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pharos_Serialized_PopUp extends Abstract_Class {


    ExtentTest logger;

    public Pharos_Serialized_PopUp(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor


    public Pharos_Serialized_PopUp serial_Input(String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtAddBySerialListSerials']",userValue,"Typing Serial in the Box",logger);
        return new Pharos_Serialized_PopUp(driver);
    }//end of method

    public Pharos_Serialized_PopUp add(){
        Reuseable_Library.click(driver,"//*[@id='_ctl43_pcAddBySerialList_btnAdd']","Add for Serialized",logger);
        return new Pharos_Serialized_PopUp(driver);
    }//end of method












}//end of main class
