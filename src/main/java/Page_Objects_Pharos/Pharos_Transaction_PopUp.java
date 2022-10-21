package Page_Objects_Pharos;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pharos_Transaction_PopUp extends Abstract_Class {

    ExtentTest logger;

    public Pharos_Transaction_PopUp(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor


    public Pharos_Transaction_PopUp reference (String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtReferenceNum']",userValue,"Reference Field",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp order (String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtOrderNumber']",userValue,"Order Filed",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp toSite (String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtSiteIDLookupID']",userValue,"To Site Field",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method


    public Pharos_Transaction_PopUp toStatus(String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='cbISMStatus_I']",userValue,"To Status",logger);//cbISMStatus_I
        return new Pharos_Transaction_PopUp(driver);
    }//end of method


    public Pharos_Transaction_PopUp inTransit (String userValue){
        Reuseable_Library.userKeys(driver,"txtLocationLookupDescription",userValue,"In Transit",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp toLocation (String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtLocationLookupID']",userValue,"To Location",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp toLocation2 (String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='']",userValue,"To Location",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp trannum (String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtTransactionLookupTrannum']",userValue,"Transaction Number",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp carrier (String userValue){
        Reuseable_Library.userKeys(driver,"//input[@id='txtCarrier']",userValue,"Carrier as UPS",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp wayBill (String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='txtWayBill']",userValue,"Way Bill",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method


    public Pharos_Transaction_PopUp fileImport(){
        Reuseable_Library.click(driver,"//*[text()='File Import']","File Import",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp save(){
        Reuseable_Library.click(driver,"//*[@id='PopupToolbar_lblSave']","Save Button",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp serialiList(){
        Reuseable_Library.click(driver,"//*[@id='tdSerialList']/div","Serial List",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method

    public Pharos_Transaction_PopUp non_Serialized(){
        Reuseable_Library.click(driver,"//*[text()='Non Serialized']","Non-Serialized",logger);
        return new Pharos_Transaction_PopUp(driver);
    }//end of method











}//end of main class
