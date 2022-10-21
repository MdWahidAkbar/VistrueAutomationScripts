package Test_Environment.UpgradeTradeIn_Counts;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class UTCounts_Variance2 extends Abstract_Class {


   //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test()
    public void UT_Counts_Variance2() throws InterruptedException, IOException, BiffException, WriteException {

        //Reading files from properties
        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(path);

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdUT.xlsx");
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
        Thread.sleep(500);
        Base_Class.landing_page().dashboard();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(4000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");

        Thread.sleep(3000);

        Base_Class.xinventoryDashboard_page().count();
        Thread.sleep(2000);
        Base_Class.countLanding_page().create_Count();
        Thread.sleep(1000);

        Base_Class.countLanding_page().upgradeTradeIn_Count();
        Thread.sleep(1000);
        Base_Class.countLanding_page().next_Button();
        Thread.sleep(1000);


        for (int i=1; i<=rowcount; i++) {
            String IMEIV2 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(11));

            //To skip the Null or Empty Cell
            if(IMEIV2 == null || IMEIV2.equalsIgnoreCase("") || IMEIV2.isEmpty()){
                break;
            }
            Thread.sleep(300);
            Base_Class.initialCount_page().SKUIMEIsearch_Field(IMEIV2);
            Thread.sleep(700);
            System.out.println("The IMEI is :"+IMEIV2);
            Base_Class.initialCount_page().SKUIMEIsearchFiled_AddButton();
            Thread.sleep(700);
            logger.log(LogStatus.PASS,"Entered IMEI is :"+IMEIV2);

        }//END OF FOR LOOP FOR IMEI

        for (int i=1; i<=rowcount; i++) {

            String SKUV2 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(12));

            //To skip the Null or Empty Cell
            if(SKUV2 == null || SKUV2.equalsIgnoreCase("") || SKUV2.isEmpty()){
                break;
            }
            Thread.sleep(300);
            Base_Class.initialCount_page().SKUIMEIsearch_Field(SKUV2);
            Thread.sleep(700);
            System.out.println("The SKU is :"+SKUV2);
            Base_Class.initialCount_page().SKUIMEIsearchFiled_AddButton();
            Thread.sleep(700);
            String NOSV1 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(13));
            Base_Class.initialCount_page().NonSerializedSKU_Input(NOSV1);
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Entered SKU is :"+SKUV2+" and Items got scanned are :"+NOSV1);

        }//END OF FOR LOOP FOR SKU

        Thread.sleep(1000);
        Base_Class.initialCount_page().done_Button();

        Thread.sleep(2000);
        Base_Class.countProgress_page().checkVariance_Button();


        //Variance1 Page Data input starts from here

        for (int i=1; i<=rowcount; i++) {
            String IMEIV1 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(7));

            //To skip the Null or Empty Cell
            if(IMEIV1 == null || IMEIV1.equalsIgnoreCase("") || IMEIV1.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.varianceCount_page().SKUIMEIsearch_Field(IMEIV1);
            Thread.sleep(700);
            System.out.println("The IMEI is :"+IMEIV1);
            Base_Class.varianceCount_page().SKUIMEIsearchFiled_AddButton();
            Thread.sleep(700);
            logger.log(LogStatus.PASS,"Entered IMEI is :"+IMEIV1);

        }//END OF FOR LOOP FOR IMEI

        for (int i=1; i<=rowcount; i++) {

            String SKUV1 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(8));

            //To skip the Null or Empty Cell
            if(SKUV1 == null || SKUV1.equalsIgnoreCase("") || SKUV1.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.varianceCount_page().SKUIMEIsearch_Field(SKUV1);
            Thread.sleep(700);
            System.out.println("The SKU is :"+SKUV1);
            Base_Class.varianceCount_page().SKUIMEIsearchFiled_AddButton();
            Thread.sleep(700);
            //String NOS = sheet1.getRow(i).getCell(3).getStringCellValue();

            String NOSV1 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(9));
            Base_Class.varianceCount_page().NonSerializedSKU_Input(NOSV1);
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Entered SKU is :"+SKUV1+" and Items got scanned are :"+NOSV1);

        }//END OF FOR LOOP FOR SKU

        Thread.sleep(1000);
        Base_Class.varianceCount_page().done_Button();


        //Variance2 Page Data input starts from here

        for (int i=1; i<=rowcount; i++) {
            String IMEI = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(3));

            //To skip the Null or Empty Cell
            if(IMEI == null || IMEI.equalsIgnoreCase("") || IMEI.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.varianceCount_page().SKUIMEIsearch_Field(IMEI);
            Thread.sleep(700);
            System.out.println("The IMEI is :"+IMEI);
            Base_Class.varianceCount_page().SKUIMEIsearchFiled_AddButton();
            Thread.sleep(700);
            logger.log(LogStatus.PASS,"Entered IMEI is :"+IMEI);

        }//END OF FOR LOOP FOR IMEI

        for (int i=1; i<=rowcount; i++) {

            String SKU = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(4));
            //String SKU = sheet1.getRow(i).getCell(2).getStringCellValue();

            //To skip the Null or Empty Cell
            if(SKU == null || SKU.equalsIgnoreCase("") || SKU.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.varianceCount_page().SKUIMEIsearch_Field(SKU);
            Thread.sleep(700);
            System.out.println("The SKU is :"+SKU);
            Base_Class.varianceCount_page().SKUIMEIsearchFiled_AddButton();
            Thread.sleep(700);
            String NOS = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(5));
            Base_Class.varianceCount_page().NonSerializedSKU_Input(NOS);
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Entered SKU is :"+SKU+" and Items got scanned are :"+NOS);

        }//END OF FOR LOOP FOR SKU

        Thread.sleep(1000);
        Base_Class.varianceCount_page().done_Button();

        Thread.sleep(5000);

        Base_Class.countSummary_page().done_Button();
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

