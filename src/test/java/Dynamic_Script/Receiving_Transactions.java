package Dynamic_Script;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Receiving_Transactions extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void Receiving_Test() throws InterruptedException, IOException {

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\Receiving.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);

        rowcount = sheet1.getLastRowNum();


        driver.navigate().to("https://cceistest.mintek.com/eisweb/");
        logger.log(LogStatus.INFO,"Navigation to TEST LogIn page");
        Thread.sleep(2000);

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

        //Navigate to Shipping page
        Base_Class.xinventoryDashboard_page().receiving();
        Thread.sleep(2000);
        Base_Class.receivingLanding_page().activitySince_Tab();
        Thread.sleep(700);
        Base_Class.receivingLanding_page().past30_Days();
        Thread.sleep(700);
        Base_Class.receivingLanding_page().status_Tab();
        Thread.sleep(700);
        Base_Class.receivingLanding_page().open();
        Thread.sleep(700);
        Base_Class.receivingLanding_page().incomplete();
        Thread.sleep(700);
        Base_Class.receivingLanding_page().apply();
        Thread.sleep(3000);


        //either take the First one to receive
        //This is to receive the first open transaction
        Base_Class.receivingLanding_page().carton_ID();

/*
        //or take specific Carton ID to receive
        //If we have SPECIFIC Carton ID to receive
        String cartonID = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(3));
        Reuseable_Library.click(driver,"//span[contains(text(),'"+cartonID+"')]","Carton ID is :"+cartonID,logger);

 */

        for (int i=1; i<=rowcount; i++) {
            String IMEItoReceive = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(5));

            //To skip the Null or Empty Cell
            if(IMEItoReceive == null || IMEItoReceive.equalsIgnoreCase("") || IMEItoReceive.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.receivingActual_page().enterItem_Field(IMEItoReceive);
            Thread.sleep(500);
            Base_Class.receivingActual_page().itemAdd_Button();
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Entered IMEI is :"+IMEItoReceive);

        }//END OF FOR LOOP FOR IMEI


        for (int i=1; i<=rowcount; i++) {

            String SKU = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(6));

            //To skip the Null or Empty Cell
            if(SKU == null || SKU.equalsIgnoreCase("") || SKU.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.receivingActual_page().enterItem_Field(SKU);
            Thread.sleep(500);
            Base_Class.receivingActual_page().itemAdd_Button();
            Thread.sleep(1000);
            String expected = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(7));
            String toReceive = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(8));
            Base_Class.receivingActual_page().nonSerializedAKUInput_Field(toReceive);
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Expected SKU is :"+expected+" and Items got scanned are :"+toReceive);

        }//END OF FOR LOOP FOR SKU

        Thread.sleep(700);
        Base_Class.receivingActual_page().addToInventory_Button();



        //This script is failing to make it dynamic;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        try{
            Thread.sleep(2000);
            Base_Class.receivingActual_page().continue_Button();
        }catch (Exception e){
            Base_Class.xinventoryDashboard_page().xinventoryDashboard();
        }

        try{
            Thread.sleep(2000);
            Base_Class.xinventoryDashboard_page().xinventoryDashboard();
        }catch (Exception e){
            Thread.sleep(2000);
            Base_Class.xinventoryDashboard_page().XinventoryOnXinventoryDashboard();
        }










    }//end of @Test









}//end of Main Class
