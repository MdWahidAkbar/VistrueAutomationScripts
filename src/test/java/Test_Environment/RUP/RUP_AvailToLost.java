package Test_Environment.RUP;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class RUP_AvailToLost extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void RUP_AvailToLost() throws InterruptedException, IOException {

        //Reading files from properties
        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(path);

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdIEMISKULookup.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);

        rowcount = sheet1.getLastRowNum();

        //URL from Properties file......................................................
        driver.get(prop.getProperty("url"));
        //driver.navigate().to("https://cceistest.mintek.com/eisweb/");
        logger.log(LogStatus.INFO,"Navigation to Log In page of : " +prop.getProperty("url"));
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
        Thread.sleep(1000);
        Base_Class.landing_page().dashboard();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(4000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(2000);

        //RUP for Serialized Item
        String IMEItoLookup = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(3));
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearch_Field(IMEItoLookup);
        Thread.sleep(1000);
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearchField_Click();
        Thread.sleep(1000);
        Base_Class.skuLookUp_page().adjust_Button();
        Thread.sleep(2000);
        Base_Class.adjustInventory_page().lost_to_Bucket();
        Thread.sleep(1000);
        Base_Class.adjustInventory_page().reasonForSerialized();
        Thread.sleep(1000);
        Base_Class.adjustInventory_page().selecting_reason();
        Thread.sleep(1000);
        Base_Class.adjustInventory_page().adjustInventory_Button();
        Thread.sleep(1000);
        Base_Class.adjustInventory_page().submitAdjustment_Button();
        Thread.sleep(4000);
        Base_Class.menu_bar().menu_Bar_ForMenuOn2ndPageMenu();
        Thread.sleep(1000);
        Base_Class.menu_bar().dashboard();


        //Navigating to SKU Lookup page
        for (int i = 1; i<=rowcount; i++) {
            String SKU = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(4));

            //To skip the Null or Empty Cell
            if(SKU == null || SKU.equalsIgnoreCase("") || SKU.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.xinventoryDashboard_page().IMEISKULookUpSearch_Field(SKU);
            Thread.sleep(700);
            Base_Class.xinventoryDashboard_page().IMEISKULookUpSearchField_Click();
            Thread.sleep(1000);
            Base_Class.skuLookUp_page().adjust_Button();
            Thread.sleep(1000);

            Base_Class.adjustInventory_page().available_from_Bucket();
            Thread.sleep(1000);
            Base_Class.adjustInventory_page().lost_to_Bucket();
            Thread.sleep(1000);


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
                Thread.sleep(4000);


        }//end for SKU loop


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
