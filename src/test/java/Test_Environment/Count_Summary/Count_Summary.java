package Test_Environment.Count_Summary;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.LogStatus;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
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

public class Count_Summary extends Abstract_Class {


   //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    //@Test(invocationCount = 3) //to run same test case for multiple times
    @Test
    public void Counts_SummaryPageDataValidation() throws InterruptedException, IOException, BiffException, WriteException {

        //Reading files from properties
        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(path);

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdCountSummary.xlsx");
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
        Thread.sleep(800);
        String PassWord = sheet1.getRow(2).getCell(1).getStringCellValue();
        Base_Class.login_Page().userPass(PassWord);
        Thread.sleep(800);
        Base_Class.login_Page().rememberMe();
        Thread.sleep(800);
        Base_Class.login_Page().logInButton();
        Thread.sleep(3000);

        Base_Class.landing_page().site_Visibility();
        Thread.sleep(1000);
        Base_Class.landing_page().site_Visibility_SearchBox();
        Thread.sleep(2000);
        String SiteVisibility = sheet1.getRow(3).getCell(1).getStringCellValue();
        Base_Class.landing_page().site_Visibility_Input(SiteVisibility);
        Thread.sleep(3000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(3000);

        //For Test.....................................
        Base_Class.landing_page().xinventory();
        Thread.sleep(1000);
        Base_Class.landing_page().dashboard();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(500);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");

        Thread.sleep(3000);

        Base_Class.xinventoryDashboard_page().count();
        Thread.sleep(3000);



/*
        //Either...............
        //Clicking a specific tranNum for specific count summary. Need to put the TranNum in the data Sheet
        String tranName = dataFormatter.formatCellValue(sheet1.getRow(4).getCell(1));
        Base_Class.countLanding_page().specificTranNum(tranName);

 */


        //or...................Finding a Physical count and read and write the data of first in the list
        Base_Class.countLanding_page().activitySince_Tab();
        Thread.sleep(2000);
        Base_Class.countLanding_page().past30_Days();
        Thread.sleep(1000);
        Base_Class.countLanding_page().countType_Tab();
        Thread.sleep(1000);
        Base_Class.countLanding_page().pysicalCount();
        Thread.sleep(1000);
        Base_Class.countLanding_page().apply();
        Thread.sleep(2000);
        //Clicking first count of the count landing page
        Base_Class.countLanding_page().firstTranNum();
        Thread.sleep(2000);



        //Reusable Library to capture text/value
        //Count Information Table------------------------
        String count = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[1]/div[2]","Count Information: Count # ",logger);
        sheet1.getRow(1).createCell(3).setCellValue(count);

        String countType = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[2]/div[2]","Count Information: Count Type ",logger);
        sheet1.getRow(2).createCell(3).setCellValue(countType);

        String dateStarted = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[3]/div[2]","Count Information: Date Started ",logger);
        sheet1.getRow(3).createCell(3).setCellValue(dateStarted);

        String dateCompleted = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[4]/div[2]","Count Information: Date Completed ",logger);
        sheet1.getRow(4).createCell(3).setCellValue(dateCompleted);

        String duration = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[5]/div[2]","Count Information: Date Completed ",logger);
        sheet1.getRow(5).createCell(3).setCellValue(duration);

        String store = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[1]/div[4]","Count Information: Store ",logger);
        sheet1.getRow(6).createCell(3).setCellValue(store);

        String submittedBy = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[2]/div[4]","Count Information: Submitted By ",logger);
        sheet1.getRow(7).createCell(3).setCellValue(submittedBy);

        String additionalUser = Reuseable_Library.captureText(driver,"//div[contains(@class,'variance-information')]/div[3]/div[4]","Count Information: Additional user ",logger);
        sheet1.getRow(8).createCell(3).setCellValue(additionalUser);


        Thread.sleep(1000);
        //Total from Summary Table-----------------------
        String totalExpected = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[2]/td[2]","Count Summary: Total Expected",logger);
        sheet1.getRow(1).createCell(5).setCellValue(totalExpected);

        String totalCounted = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[2]/td[3]","Count Summary: Total Counted",logger);
        sheet1.getRow(1).createCell(6).setCellValue(totalCounted);

        String totalVariance = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[2]/td[4]","Count Summary: Total Variance",logger);
        sheet1.getRow(1).createCell(7).setCellValue(totalVariance);

        //Available from Summary Table--------------------
        String availableExpected = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[3]/td[2]","Count Summary: available Expected",logger);
        sheet1.getRow(2).createCell(5).setCellValue(availableExpected);

        String availableCounted = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[3]/td[3]","Count Summary: available Counted",logger);
        sheet1.getRow(2).createCell(6).setCellValue(availableCounted);

        String availableVariance = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[3]/td[4]","Count Summary: available Variance",logger);
        sheet1.getRow(2).createCell(7).setCellValue(availableVariance);


        //Reserved from Summary Table--------------------
        String ReservedExpected = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[4]/td[2]","Count Summary: Reserved Expected",logger);
        sheet1.getRow(3).createCell(5).setCellValue(ReservedExpected);

        String ReservedCounted = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[4]/td[3]","Count Summary: Reserved Counted",logger);
        sheet1.getRow(3).createCell(6).setCellValue(ReservedCounted);

        String ReservedVariance = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[4]/td[4]","Count Summary: Reserved Variance",logger);
        sheet1.getRow(3).createCell(7).setCellValue(ReservedVariance);

        //Return Defective from Summary Table--------------------
        String ReturnDefectiveExpected = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[5]/td[2]","Count Summary: Return Defective Expected",logger);
        sheet1.getRow(4).createCell(5).setCellValue(ReturnDefectiveExpected);

        String ReturnDefectiveCounted = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[5]/td[3]","Count Summary: Return Defective Counted",logger);
        sheet1.getRow(4).createCell(6).setCellValue(ReturnDefectiveCounted);

        String ReturnDefectiveVariance = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[5]/td[4]","Count Summary: Return Defective Variance",logger);
        sheet1.getRow(4).createCell(7).setCellValue(ReturnDefectiveVariance);

        //Upgrade TradeIn from Summary Table--------------------
        String UpgradeTradeInExpected = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[6]/td[2]","Count Summary: Upgrade TradeIn Expected",logger);
        sheet1.getRow(5).createCell(5).setCellValue(UpgradeTradeInExpected);

        String UpgradeTradeInCounted = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[6]/td[3]","Count Summary: Upgrade TradeIn Counted",logger);
        sheet1.getRow(5).createCell(6).setCellValue(UpgradeTradeInCounted);

        String UpgradeTradeInVariance = Reuseable_Library.captureText(driver,"//table[contains(@class,'summary-table')]/tr[6]/td[4]","Count Summary: Upgrade TradeIn Variance",logger);
        sheet1.getRow(5).createCell(7).setCellValue(UpgradeTradeInVariance);


        File src = new File("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdCountSummary.xlsx");
        FileOutputStream fos = new FileOutputStream(src);
        workbook.write(fos);
        workbook.close();



        Thread.sleep(1000);
        Base_Class.countSummary_page().exit_Button();

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

