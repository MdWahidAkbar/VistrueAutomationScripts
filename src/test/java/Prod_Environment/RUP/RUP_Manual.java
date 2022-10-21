package Prod_Environment.RUP;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class RUP_Manual extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void Rup_Manual() throws InterruptedException, IOException {

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdIEMISKULookup.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);

        rowcount = sheet1.getLastRowNum();

        //For prod......................................................
        driver.navigate().to("https://cceis.mintek.com/eisweb/");
        logger.log(LogStatus.INFO,"Navigation to Prod LogIn page");
        Thread.sleep(1000);

        //Getting Logged In
        String UserName = sheet1.getRow(1).getCell(0).getStringCellValue();
        Base_Class.login_Page().userID(UserName);
        Thread.sleep(500);
        String PassWord = sheet1.getRow(1).getCell(1).getStringCellValue();
        Base_Class.login_Page().userPass(PassWord);
        Thread.sleep(500);
        Base_Class.login_Page().rememberMe();
        Thread.sleep(500);
        Base_Class.login_Page().logInButton();
        Thread.sleep(2000);

        Base_Class.landing_page().site_Visibility();
        Thread.sleep(500);
        Base_Class.landing_page().site_Visibility_SearchBox();
        Thread.sleep(500);
        String SiteVisibility = sheet1.getRow(1).getCell(2).getStringCellValue();
        Base_Class.landing_page().site_Visibility_Input(SiteVisibility);
        Thread.sleep(2000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(1000);
        Base_Class.landing_page().xinventory();
        Thread.sleep(500);
        Base_Class.landing_page().dashboard();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        driver.manage().window().maximize();
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(2000);

        String IMEItoLookup = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(3));
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearch_Field(IMEItoLookup);
        Thread.sleep(700);
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearchField_Click();
        Thread.sleep(1000);


        //Navigating to SKU Lookup page
        for (int i = 1; i<=rowcount; i++) {
            String SKU = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(4));

            //To skip the Null or Empty Cell
            if(SKU == null || SKU.equalsIgnoreCase("") || SKU.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.skuLookUp_page().IMEISKULookUpSearch_Field(SKU);
            Thread.sleep(700);
            Base_Class.skuLookUp_page().IMEISKUlookupsearchField_Click();
            Thread.sleep(1000);
            Base_Class.skuLookUp_page().adjust_Button();
            Thread.sleep(1000);

            WebElement SKUmoveFromAvailable = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > ion-app > ion-router-outlet > app-adjust > app-adjust-form > div > div.buckets > div:nth-child(1) > ion-radio-group > span:nth-child(1) > ion-item > tr-ion-radio > ion-radio\").shadowRoot.querySelector(\"div > div.radio-inner\")");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SKUmoveFromAvailable);
            Thread.sleep(1000);
            logger.log(LogStatus.INFO,"Clicked on From Available bucket");

            WebElement SKUmoveToReturnDefective = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > ion-app > ion-router-outlet > app-adjust > app-adjust-form > div > div.buckets > div:nth-child(2) > ion-radio-group > span:nth-child(2) > ion-item > tr-ion-radio > ion-radio\").shadowRoot.querySelector(\"div > div.radio-inner\")");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SKUmoveToReturnDefective);
            Thread.sleep(1000);
            logger.log(LogStatus.INFO,"Clicked on to Return Defective bucket");

            //Need to put for amount to adjust=======================================================================
            //String NOS = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(5));


            int NOS = (int) sheet1.getRow(i).getCell(5).getNumericCellValue();
            for (int j=1; j<=NOS; j++){

                    Base_Class.adjustInventory_page().amountToBe_Adjusted();
                    Thread.sleep(500);
                }
                Thread.sleep(500);
                Base_Class.adjustInventory_page().reasonForNonSerialized();
                Thread.sleep(1000);
                Base_Class.adjustInventory_page().selecting_reason();
                Thread.sleep(1000);
                Base_Class.adjustInventory_page().adjustInventory_Button();
                Thread.sleep(1000);
                Base_Class.adjustInventory_page().submitAdjustment_Button();
                Thread.sleep(3000);


        }//end for SKU loop

        for (int i = 1; i<=rowcount; i++) {
            String IMEI = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(3));

            //To skip the Null or Empty Cell
            if (IMEI == null || IMEI.equalsIgnoreCase("") || IMEI.isEmpty()) {
                break;
            }
            Thread.sleep(500);
            Base_Class.imeiLookUp_page().IMEISKULookUpSearch_Field(IMEI);
            Thread.sleep(700);
            Base_Class.imeiLookUp_page().IMEISKUlookupsearchField_Click();
            Thread.sleep(700);
            Base_Class.imeiLookUp_page().adjust_Button();
            Thread.sleep(1000);

            WebElement IMEImoveToReturnDefective = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > ion-app > ion-router-outlet > app-adjust > app-adjust-form > div > div.buckets > div > ion-radio-group > span:nth-child(2) > ion-item > tr-ion-radio > ion-radio\").shadowRoot.querySelector(\"div > div.radio-inner\")");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", IMEImoveToReturnDefective);
            Thread.sleep(1000);

            //Base_Class.adjustInventory_page().reason(); //For Serialized there is one chevron locator
            Reuseable_Library.click(driver,"//*[@class='chevron-down status-chevron']","Reason", logger);
            Thread.sleep(1000);
            Base_Class.adjustInventory_page().selecting_reason();
            Thread.sleep(1000);
            Base_Class.adjustInventory_page().adjustInventory_Button();
            Thread.sleep(1000);
            Base_Class.adjustInventory_page().submitAdjustment_Button();
            Thread.sleep(3000);


        }//END of IMEI Loop









    }//end of @Test









}//end of Main Class
