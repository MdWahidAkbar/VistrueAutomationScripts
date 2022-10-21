package Test_Environment.Receiving;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class Receiving_Transactions extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void ReceivingInventory() throws InterruptedException, IOException {

        //Reading files from properties
        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(path);

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdReceiving.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);

        rowcount = sheet1.getLastRowNum();


        //URL from Properties file......................................................
        driver.get(prop.getProperty("url"));
        //driver.navigate().to("https://cceistest.mintek.com/eisweb/");
        logger.log(LogStatus.INFO,"Navigation to Log In page of : " +prop.getProperty("url"));
        Thread.sleep(1000);

        //Getting Logged In
        String UserName = sheet1.getRow(1).getCell(1).getStringCellValue();
        Base_Class.login_Page().userID(UserName);
        Thread.sleep(500);
        String PassWord = sheet1.getRow(2).getCell(1).getStringCellValue();
        Base_Class.login_Page().userPass(PassWord);
        Thread.sleep(500);
        Base_Class.login_Page().rememberMe();
        Thread.sleep(500);
        Base_Class.login_Page().logInButton();
        Thread.sleep(2000);

        Base_Class.landing_page().site_Visibility();
        Thread.sleep(1000);
        Base_Class.landing_page().site_Visibility_SearchBox();
        Thread.sleep(1000);
        String SiteVisibility = sheet1.getRow(3).getCell(1).getStringCellValue();
        Base_Class.landing_page().site_Visibility_Input(SiteVisibility);
        Thread.sleep(2000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(1000);
        Base_Class.landing_page().xinventory();
        Thread.sleep(1000);
        Base_Class.landing_page().dashboard();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(4000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(3000);

        //Navigate to Shipping page
        Base_Class.xinventoryDashboard_page().receiving();
        Thread.sleep(3000);
        Base_Class.receivingLanding_page().activitySince_Tab();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().past30_Days();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().status_Tab();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().open();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().incomplete();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().apply();
        Thread.sleep(3000);

/*
        //either take the First one to receive
        //This is to receive the first open transaction
        Base_Class.receivingLanding_page().carton_ID();

 */


        //or take specific Carton ID to receive
        //If we have SPECIFIC Carton ID to receive, apply this
        String cartonID = dataFormatter.formatCellValue(sheet1.getRow(4).getCell(1));
        Reuseable_Library.click_JS(driver,"//span[contains(text(),'"+cartonID+"')]","Carton ID is :"+cartonID,logger);


        for (int i=1; i<=rowcount; i++) {
            String IMEItoReceive = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(2));

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

            String SKU = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(3));

            //To skip the Null or Empty Cell
            if(SKU == null || SKU.equalsIgnoreCase("") || SKU.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.receivingActual_page().enterItem_Field(SKU);
            Thread.sleep(500);
            Base_Class.receivingActual_page().itemAdd_Button();
            Thread.sleep(1000);
            //String expected = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(7));
            String toReceive = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(4));
            Base_Class.receivingActual_page().nonSerializedAKUInput_Field(toReceive);
            Thread.sleep(2000);
            //logger.log(LogStatus.PASS,"Expected SKU is :"+expected+" and Items got scanned are :"+toReceive);

        }//END OF FOR LOOP FOR SKU

        Thread.sleep(1000);

/*
        //Click on Add to Inventory
        Base_Class.receivingActual_page().addToInventory_Button();

 */

        //or Cancel
        Base_Class.receivingActual_page().cancel_Button();
        Thread.sleep(1500);

        //and OK on PopUP
        Base_Class.receivingActual_page().popUpOK_Button();



/*
        //For Different received item from expected
        Thread.sleep(1000);
        Base_Class.receivingActual_page().continue_Button();

 */

        Thread.sleep(2000);


        //Logging out from XInventory

        Thread.sleep(1000);
        Base_Class.menu_bar().menu_Bar_ForMenuOn2ndPageMenu();
        Thread.sleep(500);
        Base_Class.menu_bar().logOut();
        Thread.sleep(1000);


        //Logging out from Pharos

        driver.switchTo().window(tab.get(0));
        Thread.sleep(1000);
        Base_Class.landing_page().pharos_Menu_Bar();
        Thread.sleep(1000);
        Base_Class.landing_page().pharos_LogOut();



    }//end of @Test









}//end of Main Class
