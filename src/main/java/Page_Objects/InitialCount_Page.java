package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitialCount_Page extends Abstract_Class {

    ExtentTest logger;

    public InitialCount_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public InitialCount_Page SKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"//*[@placeholder='Enter SKU/IMEI']",SKUIMEI,"SKU IMEI Search Field",logger);
        return new InitialCount_Page(driver);

    }//end of method


    public InitialCount_Page SKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"//*[@class='add-circle add-button']","SKU IMEI Search Field Click to add",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page NonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"(//*[@class='native-input sc-ion-input-md'])[3]",SKU,"Non Serialized SKU Search Field",logger);
        return new InitialCount_Page(driver);

    }//end of method


    public InitialCount_Page returnDefective_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next: RETURN-DEFECTIVE')]","Return Defective Bucket Button",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page ReturnSKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"(//*[@placeholder='Enter SKU/IMEI'])[2]",SKUIMEI,"Return Defective SKU IMEI Search Field",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page returnSKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"(//*[@class='add-circle add-button'])[2]","SKU IMEI Search Field Click to add",logger);
        return new InitialCount_Page(driver);

    }//end of method


    public InitialCount_Page returnNonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"(//tr[contains(@class,'highlight')])[2]/td[3]/div[1]/ion-input[1]/input[1]",SKU,"Non Serialized SKU Search Field",logger);
        //Reuseable_Library.userKeys(driver,"//body[1]/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-reconciliation[1]/app-count[1]/div[1]/dx-tab-panel[1]/div[2]/div[1]/div[1]/div[2]/div[1]/app-count-scanning[1]/div[2]/app-reconcile-detail-grid[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/ion-input[1]/input[1]",SKU,"Non Serialized SKU Search Field",logger);
        return new InitialCount_Page(driver);

    }//end of method


    public InitialCount_Page upgradeTradein_Button(){
        //Reuseable_Library.click(driver,"(//*[contains(@class,'confirm-button')])[2]","Upgrade TradeIn Bucket Button",logger);
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next: UPGRADE-TRADEIN')]","Upgrade TradeIn Bucket Button",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page UpgradeSKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"(//*[@placeholder='Enter SKU/IMEI'])[3]",SKUIMEI,"Upgrade TradeIn SKU IMEI Search Field",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page upgradeSKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"(//*[@class='add-circle add-button'])[3]","SKU IMEI Search Field Click to add",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page reserved_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next: RESERVED')]","Reserved Button",logger);
        return new InitialCount_Page(driver);

    }//end of method


    public InitialCount_Page reserved_Weekly_SKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"(//*[@placeholder='Enter SKU/IMEI'])[2]",SKUIMEI,"Reserved SKU IMEI Search Field",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page reserved_Weekly_SKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"(//*[@class='add-circle add-button'])[2]","SKU IMEI Search Field Click to add",logger);
        return new InitialCount_Page(driver);

    }//end of method


    public InitialCount_Page reserved_Weekly_NonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"(//tr[contains(@class,'highlight')]/td[3]/div/ion-input/input)[2]",SKU,"Non Serialized SKU count field",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page reserved_Physical_SKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"(//*[@placeholder='Enter SKU/IMEI'])[4]",SKUIMEI,"Reserved SKU IMEI Search Field",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page reserved_Physical_SKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"(//*[@class='add-circle add-button'])[4]","SKU IMEI Search Field Click to add",logger);
        return new InitialCount_Page(driver);

    }//end of method


    public InitialCount_Page reserved_Physical_NonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"(//tr[contains(@class,'highlight')]/td[3]/div/ion-input/input)[4]",SKU,"Non Serialized SKU count field",logger);
        return new InitialCount_Page(driver);

    }//end of method










    public InitialCount_Page done_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Done')]","Done Button",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page void_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Void')]","Void Button",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page confirm_void(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Confirm')]","Confirm for Void",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page ok_viod_confirm_void(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Ok')]","OK to Confirm for Void",logger);
        return new InitialCount_Page(driver);

    }//end of method

    public InitialCount_Page yes_Corctive_NoScan(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Yes')]","Yes button for Not Scanning PopUp",logger);
        return new InitialCount_Page(driver);

    }//end of method















}//end of mail class
