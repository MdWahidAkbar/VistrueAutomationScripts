package Test_Environment.Shipping;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class Shipping_Transactions extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void Shipping() throws InterruptedException, IOException {

        //Reading files from properties
        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(path);

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdShipping.xlsx");
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
        Thread.sleep(500);
        Base_Class.landing_page().site_Visibility_SearchBox();
        Thread.sleep(500);
        String SiteVisibility = sheet1.getRow(3).getCell(1).getStringCellValue();
        Base_Class.landing_page().site_Visibility_Input(SiteVisibility);
        Thread.sleep(2000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(1000);
        Base_Class.landing_page().xinventory();
        Thread.sleep(500);
        Base_Class.landing_page().dashboard();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(4000);
        driver.manage().window().maximize();
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(3000);

        //Navigate to Shipping page
        Base_Class.xinventoryDashboard_page().shipping();
        Thread.sleep(2500);
        Base_Class.shippingLanding_page().newShipping_Button();
        Thread.sleep(1500);
        Base_Class.shippingLanding_page().pullBack();
        Thread.sleep(1000);
        Base_Class.shippingLanding_page().next_Button();
        Thread.sleep(2000);


        for (int i=1; i<=rowcount; i++) {
            String IMEI = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(2));

            //To skip the Null or Empty Cell
            if(IMEI == null || IMEI.equalsIgnoreCase("") || IMEI.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.shippingAdding_page().enterSKUIMEI(IMEI);
            Thread.sleep(500);
            Base_Class.shippingAdding_page().add_Button();
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Entered IMEI is :"+IMEI);

        }//END OF FOR LOOP FOR IMEI


        for (int i=1; i<=rowcount; i++) {

            String SKU = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(3));

            //To skip the Null or Empty Cell
            if(SKU == null || SKU.equalsIgnoreCase("") || SKU.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.shippingAdding_page().enterSKUIMEI(SKU);
            Thread.sleep(500);
            Base_Class.shippingAdding_page().add_Button();
            Thread.sleep(1000);
            String NOS = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(4));
            Base_Class.shippingAdding_page().nonSerializededit_Field(NOS);
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Entered SKU is :"+SKU+" and Items got scanned are :"+NOS);

        }//END OF FOR LOOP FOR SKU

        Thread.sleep(500);
        Base_Class.shippingAdding_page().shippingDetaild_Button();
        Thread.sleep(2000);
        Base_Class.shippingAdding_page().submit_Button();
        Thread.sleep(5000);

        //Count Information Table--------------------
        String trackingNumber = Reuseable_Library.captureText(driver,"//*[contains(@class,'shipping-information')]/div[3]/div[2]/span","Tracking Number",logger);
        sheet1.getRow(4).createCell(1).setCellValue(trackingNumber);



        Base_Class.packingSlipandLabel_page().done_Button();


        File src = new File("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdShipping.xlsx");
        FileOutputStream fos = new FileOutputStream(src);
        workbook.write(fos);
        workbook.close();




    }//end of @Test









}//end of Main Class
