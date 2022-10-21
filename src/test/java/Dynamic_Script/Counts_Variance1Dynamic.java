package Dynamic_Script;

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

public class Counts_Variance1Dynamic extends Abstract_Class {


   //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test()
    public void Counts_Variance1() throws InterruptedException, IOException, BiffException, WriteException {

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataTEST1.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);

        rowcount = sheet1.getLastRowNum();

        driver.navigate().to("https://cceistest.mintek.com/eisweb/");
        logger.log(LogStatus.INFO,"Navigation to TEST LogIn page");
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

        Thread.sleep(3000);

        Base_Class.xinventoryDashboard_page().count();
        Thread.sleep(500);
        Base_Class.countLanding_page().create_Count();
        Thread.sleep(1000);

        Base_Class.countLanding_page().weekly_Count();
        Thread.sleep(1000);
        Base_Class.countLanding_page().next_Button();
        Thread.sleep(1000);



        for (int i=1; i<=rowcount; i++) {
            String IMEIV1 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(7));

            //To skip the Null or Empty Cell
            if(IMEIV1 == null || IMEIV1.equalsIgnoreCase("") || IMEIV1.isEmpty()){
                break;
            }
            Thread.sleep(500);
            Base_Class.initialCount_page().SKUIMEIsearch_Field(IMEIV1);
            Thread.sleep(700);
            System.out.println("The IMEI is :"+IMEIV1);
            Base_Class.initialCount_page().SKUIMEIsearchFiled_AddButton();
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
            Base_Class.initialCount_page().SKUIMEIsearch_Field(SKUV1);
            Thread.sleep(700);
            System.out.println("The SKU is :"+SKUV1);
            Base_Class.initialCount_page().SKUIMEIsearchFiled_AddButton();
            Thread.sleep(700);
            String NOSV1 = dataFormatter.formatCellValue(sheet1.getRow(i).getCell(9));
            Base_Class.initialCount_page().NonSerializedSKU_Input(NOSV1);
            Thread.sleep(1000);
            logger.log(LogStatus.PASS,"Entered SKU is :"+SKUV1+" and Items got scanned are :"+NOSV1);

        }//END OF FOR LOOP FOR SKU

        Thread.sleep(1000);
        Base_Class.initialCount_page().done_Button();

        Thread.sleep(2000);
        Base_Class.countProgress_page().checkVariance_Button();
        Thread.sleep(3000);

        try {

            //Variance1 Page Data input starts from here
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

        }catch (Exception e ){

            Thread.sleep(5000);
            Base_Class.countSummary_page().done_Button();

        }//end of try Catch......






    }//end of @Test
















}//end of Main Class

