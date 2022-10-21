package Prod_Environment.Share_Modal;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class ShareModal_CountSummary extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void ShareModal_CountSummary() throws InterruptedException, IOException {

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();

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
        Thread.sleep(1000);
        Base_Class.landing_page().site_Visibility_SearchBox();
        Thread.sleep(1000);
        String SiteVisibility = sheet1.getRow(1).getCell(2).getStringCellValue();
        Base_Class.landing_page().site_Visibility_Input(SiteVisibility);
        Thread.sleep(2000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(1000);

        //For Test...........................
        Base_Class.landing_page().xinventory();
        Thread.sleep(1000);
        Base_Class.landing_page().dashboard();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(2000);

        //Clicking on completed count by using mouse hover and mouse click
        Base_Class.xinventoryDashboard_page().count();
        Thread.sleep(1000);
        Base_Class.countLanding_page().count_Link();
        Thread.sleep(1000);

/*
        //The below lines are for single functionality
        Base_Class.storeInventory_page().download_Click();
        String emailID = sheet1.getRow(1).getCell(7).getStringCellValue();
        Base_Class.storeInventory_page().emailInput_Field(emailID);


        Thread.sleep(1500);
        //Base_Class.storeInventory_page().excelFormat_Click();
        Base_Class.share_Modal().csvFormat_Click();
        Thread.sleep(1500);
        Base_Class.storeInventory_page().emailPrintDownload_Button();
 */

        //Download CSV report ----------------------------------------------------
        Thread.sleep(500);
        Base_Class.share_Modal().download_Click();
        Thread.sleep(1500);
        //Base_Class.storeInventory_page().excelFormat_Click();
        Base_Class.share_Modal().csvFormat_Click();
        Thread.sleep(1500);
        Base_Class.storeInventory_page().emailPrintDownload_Button();

        //Email the Excel report-------------------------------------------------
        Thread.sleep(2000);
        Base_Class.countLanding_page().count_Link();
        Thread.sleep(1500);
        String emailID = sheet1.getRow(1).getCell(7).getStringCellValue();
        Base_Class.storeInventory_page().emailInput_Field(emailID);
        Thread.sleep(1000);

        //Hitting enter to accept the email ID in the filed.There is a bug for it,Once fixed the following line won't be necessary
        driver.findElement(By.xpath("//*[@class='self-email']/dx-tag-box[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        Base_Class.share_Modal().excelFormat_Click();
        Thread.sleep(1000);
        Base_Class.share_Modal().emailPrintDownload_Button();
        Thread.sleep(1000);

        //Print the PDF report----------------------------------------------------
        Thread.sleep(1500);
        Base_Class.countLanding_page().count_Link();
        Thread.sleep(1000);
        Base_Class.share_Modal().print_Click();
        Thread.sleep(500);
        Base_Class.share_Modal().emailPrintDownload_Button();
        Thread.sleep(1000);






    }//end of @Test





}//end of Main Class
