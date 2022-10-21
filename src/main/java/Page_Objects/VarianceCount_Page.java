package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VarianceCount_Page extends Abstract_Class {

    ExtentTest logger;


    public VarianceCount_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public VarianceCount_Page SKUIMEIsearch_Field(String SKUIMEI){
        //Reuseable_Library.userKeys(driver,"//*[@placeholder='Enter SKU/IMEI']",SKUIMEI,"SKU IMEI Search Field",logger);
        Reuseable_Library.userKeys(driver,"//div[@class='item-scan-search']/div[1]/ion-input[1]/input[1]",SKUIMEI,"SKU IMEI Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page SKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"//*[@class='add-circle add-button']","SKU IMEI Search Field Click to add",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page NonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"(//*[@class='native-input sc-ion-input-md'])[3]",SKU,"Non Serialized SKU Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method


    public VarianceCount_Page returnDefective_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next: RETURN-DEFECTIVE')]","Return Defective Bucket Button",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page reserved_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next: RESERVED')]","Reserved Bucket Button",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page ReturnSKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"//div[@class='dx-multiview-item-container']/div[2]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/ion-input[1]/input[1]",SKUIMEI,"Return Defective SKU IMEI Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page returnSKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"//div[@class='dx-multiview-item-container']/div[2]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/i[1]","SKU IMEI Search Field Click to add",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page returnNonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"(//tbody/tr[1]/td[3]/ion-input[1]/input[1])[1]",SKU,"Non Serialized SKU Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page returnNonSerializedSKU_Input_Variance2_Page(String SKU){
        Reuseable_Library.userKeys(driver,"(//tbody/tr[1]/td[3]/ion-input[1]/input[1])[1]",SKU,"Non Serialized SKU Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method


    public VarianceCount_Page upgradeTradein_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Next: UPGRADE-TRADEIN')]","Upgrade TradeIn Bucket Button",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page UpgradeSKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"//div[@class='dx-multiview-item-container']/div[3]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/ion-input[1]/input[1]",SKUIMEI,"Upgrade TradeIn SKU IMEI Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page upgradeSKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"//div[@class='dx-multiview-item-container']/div[3]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/i[1]","SKU IMEI Search Field Click to add",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page reserved_Weekly_SKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"//div[@class='dx-multiview-item-container']/div[2]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/ion-input[1]/input[1]",SKUIMEI,"Reserved SKU IMEI Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page reserved_Weekly_SKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"//div[@class='dx-multiview-item-container']/div[2]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/i[1]","SKU IMEI Search Field Click to add",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page reserved_Weekly_NonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"(//tbody/tr[1]/td[3]/ion-input[1]/input[1])[2]",SKU,"Non Serialized SKU Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page reserved_Physical_SKUIMEIsearch_Field(String SKUIMEI){
        Reuseable_Library.userKeys(driver,"//body/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-reconciliation[1]/app-conduct-variance[1]/div[1]/dx-tab-panel[1]/div[2]/div[1]/div[1]/div[4]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/ion-input[1]/input[1]",SKUIMEI,"Reserved SKU IMEI Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page reserved_Physical_SKUIMEIsearchFiled_AddButton(){
        Reuseable_Library.click(driver,"//body/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-reconciliation[1]/app-conduct-variance[1]/div[1]/dx-tab-panel[1]/div[2]/div[1]/div[1]/div[4]/div[1]/app-conduct-variance-scanning[1]/div[1]/div[1]/i[1]","SKU IMEI Search Field Click to add",logger);
        return new VarianceCount_Page(driver);

    }//end of method

    public VarianceCount_Page reserved_Physical_NonSerializedSKU_Input(String SKU){
        Reuseable_Library.userKeys(driver,"//body[1]/app-root[1]/ion-app[1]/ion-router-outlet[1]/app-reconciliation[1]/app-conduct-variance[1]/div[1]/dx-tab-panel[1]/div[2]/div[1]/div[1]/div[4]/div[1]/app-conduct-variance-scanning[1]/app-variance-grid[1]/table[1]/tbody[1]/tr[1]/td[3]/ion-input[1]/input[1]",SKU,"Non Serialized SKU Search Field",logger);
        return new VarianceCount_Page(driver);

    }//end of method





















    public VarianceCount_Page done_Button(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Done')]","Done Button",logger);
        return new VarianceCount_Page(driver);

    }//end of method



















}//end of mail class
