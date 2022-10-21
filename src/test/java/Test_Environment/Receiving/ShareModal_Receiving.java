package Test_Environment.Receiving;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import Reusable_Classes.Reuseable_Library;
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
import java.util.Properties;

public class ShareModal_Receiving extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void ShareModal_ReceivingTransaction() throws InterruptedException, IOException {

        //Reading files from properties
        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(path);

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        Thread.sleep(2000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(1000);

        //For Test...........................
        Base_Class.landing_page().xinventory();
        Thread.sleep(1000);
        Base_Class.landing_page().dashboard();
        Thread.sleep(1000);

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(4000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(2000);

        //Clicking on completed count by using mouse hover and mouse click
        Base_Class.xinventoryDashboard_page().receiving();
        Thread.sleep(3000);
        Base_Class.receivingLanding_page().activitySince_Tab();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().past30_Days();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().status_Tab();
        Thread.sleep(1000);
        Base_Class.receivingLanding_page().closed();
        Thread.sleep(1500);
        Base_Class.receivingLanding_page().apply();
        Thread.sleep(2000);

        String cartonID = dataFormatter.formatCellValue(sheet1.getRow(2).getCell(1));
        Reuseable_Library.mouseClick(driver,"//span[contains(text(),'"+cartonID+"')]","Carton ID is :"+cartonID,logger);


      //Download CSV report ----------------------------------------------------
        Base_Class.share_Modal().shareModal_Click();
        Thread.sleep(1000);
        Base_Class.share_Modal().download_Click();
        Thread.sleep(1500);
        //Base_Class.storeInventory_page().excelFormat_Click();
        Base_Class.share_Modal().csvFormat_Click();
        Thread.sleep(1500);
        Base_Class.storeInventory_page().emailPrintDownload_Button();

        //Email the Excel report-------------------------------------------------
        Thread.sleep(1500);
        Base_Class.share_Modal().shareModal_Click();
        Thread.sleep(1000);
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
        Base_Class.share_Modal().shareModal_Click();
        Thread.sleep(1000);
        Base_Class.share_Modal().print_Click();
        Thread.sleep(1000);
        Base_Class.share_Modal().emailPrintDownload_Button();
        Thread.sleep(1000);




    }//end of @Test







}//end of Main Class
