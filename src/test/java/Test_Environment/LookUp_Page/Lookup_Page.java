package Test_Environment.LookUp_Page;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class Lookup_Page extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void IMEISKULookUpPage() throws InterruptedException, IOException {

        //Reading files from properties
        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(path);

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();

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
        Thread.sleep(1000);
        Base_Class.landing_page().site_Visibility_SearchBox();
        Thread.sleep(1000);
        String SiteVisibility = sheet1.getRow(1).getCell(2).getStringCellValue();
        Base_Class.landing_page().site_Visibility_Input(SiteVisibility);
        Thread.sleep(3000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(2000);

        //For Prod...........................
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

        //Navigating to IMEI Lookup page
        String IMEI = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(3));
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearch_Field(IMEI);
        Thread.sleep(700);
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearchField_Click();
        Thread.sleep(2000);

        //Applying Assertion for Pass or Fail of the Script.
        //SoftAssert sAssert = new SoftAssert();

        String IMEIPageTitle = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(6));
        String pageTitleIMEI = Reuseable_Library.captureText(driver,"//*[@class='page-title']/span","Page Title",logger);
        Assert.assertEquals(pageTitleIMEI,IMEIPageTitle);
        logger.log(LogStatus.PASS,"Page Title Matched as expected. Actual Title is :"+pageTitleIMEI);
        Thread.sleep(2000);

        // travelling from IMEI Lookup to SKU lookup page
        String IMEItoSKU = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(4));
        Base_Class.imeiLookUp_page().IMEISKULookUpSearch_Field(IMEItoSKU);
        Thread.sleep(1000);
        Base_Class.imeiLookUp_page().IMEISKUlookupsearchField_Click();
        Thread.sleep(2000);

        String SKUPageTitle = dataFormatter.formatCellValue(sheet1.getRow(2).getCell(6));
        String pageTitleSKU = Reuseable_Library.captureText(driver,"(//*[@class='page-title']/span)[2]","Page Title",logger);
        Assert.assertEquals(SKUPageTitle,pageTitleSKU);
        logger.log(LogStatus.PASS,"Page Title Matched as expected. Actual Title is :"+pageTitleSKU);
        Thread.sleep(2000);


        Base_Class.xinventoryDashboard_page().xinventoryDashboard();//Locator is changing on every time search
        Thread.sleep(3000);

        //Navigating to SKU to IMEI Lookup page
        String SKU2 = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(4));
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearch_Field(SKU2);
        Thread.sleep(800);
        Base_Class.xinventoryDashboard_page().IMEISKULookUpSearchField_Click();
        Thread.sleep(1000);

        String SKUPageTitle2 = dataFormatter.formatCellValue(sheet1.getRow(2).getCell(6));
        String pageTitleSKU2 = Reuseable_Library.captureText(driver,"//*[@class='page-title']/span","Page Title",logger);
        Assert.assertEquals(pageTitleSKU2,SKUPageTitle2);
        logger.log(LogStatus.PASS,"Page Title Matched as expected. Actual Title is :"+pageTitleSKU2);
        Thread.sleep(1000);

        String SKUtoIMEI = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(3));
        Base_Class.skuLookUp_page().IMEISKULookUpSearch_Field(SKUtoIMEI);
        Thread.sleep(700);
        Base_Class.skuLookUp_page().IMEISKUlookupsearchField_Click();
        Thread.sleep(1000);

        String IMEIPageTitle2 = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(6));
        String pageTitleIMEI2 = Reuseable_Library.captureText(driver,"(//*[@class='page-title']/span)[2]","Page Title",logger);
        Assert.assertEquals(pageTitleIMEI2,IMEIPageTitle2);
        logger.log(LogStatus.PASS,"Page Title Matched as expected. Actual Title is :"+pageTitleIMEI2);
        Thread.sleep(2000);

        //Navigate to Dashboard Page
        Base_Class.xinventoryDashboard_page().xinventoryDashboard();


/*
        //Logging out from XInventory

        Thread.sleep(1000);
        Base_Class.menu_bar().menu_Bar();
        Thread.sleep(500);
        Base_Class.menu_bar().logOut();
        Thread.sleep(1000);


        //Logging out from Pharos

        driver.switchTo().window(tab.get(0));
        Thread.sleep(1000);
        Base_Class.landing_page().pharos_Menu_Bar();
        Thread.sleep(1000);
        Base_Class.landing_page().pharos_LogOut();

 */



        //sAssert.assertAll();


    }//end of @Test









}//end of Main Class
