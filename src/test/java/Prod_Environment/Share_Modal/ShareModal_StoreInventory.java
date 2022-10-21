package Prod_Environment.Share_Modal;

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
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class ShareModal_StoreInventory extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;
    int row;


    @Test
    public void ShareModal_StoreInventory() throws InterruptedException, IOException {

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

/*
        //For DEV..................................
        Base_Class.landing_page().Dev_XinventoryTab();
        Thread.sleep(500);
        Base_Class.landing_page().Dev_XinventoryToXM_page();
 */

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(2000);

        //Clicking on Menu by using mouse hover and mouse click
        Base_Class.menu_bar().menu_Bar();
        Thread.sleep(700);
        Base_Class.menu_bar().store_Inventory();
        Thread.sleep(700);

        Base_Class.storeInventory_page().shareModal_Click();
        Thread.sleep(1500);
        //Base_Class.storeInventory_page().download_Click();

        String emailID = sheet1.getRow(1).getCell(7).getStringCellValue();
        Base_Class.storeInventory_page().emailInput_Field(emailID);
        Thread.sleep(1500);
        //Hitting enter to accept the email ID in the filed.There is a bug for it,Once it is fixed, the following line won't be necessary
        driver.findElement(By.xpath("//*[@class='self-email']/dx-tag-box[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Base_Class.storeInventory_page().excelFormat_Click();
        Thread.sleep(1500);
        Base_Class.storeInventory_page().emailPrintDownload_Button();
        Thread.sleep(1500);

        String expectedMessage = dataFormatter.formatCellValue(sheet1.getRow(1).getCell(8));
        String successMessage = Reuseable_Library.captureText(driver,"//span[contains(text(),'Success: Email sent to')]","Email Success Message",logger);

        //Applying Assertion for Pass or Fail of the Script.
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(successMessage,expectedMessage);

        if (successMessage.equals(expectedMessage)){
            logger.log(LogStatus.PASS,"Success message is matched as expected. The actual message is : "+successMessage+" And "+"Expected message is : "+expectedMessage);
            sheet1.getRow(1).createCell(10).setCellValue("PASS");
        }else {
            logger.log(LogStatus.FAIL,"Success message does not matched as expected. The actual message is : "+successMessage);
            sheet1.getRow(1).createCell(10).setCellValue("FAIL");
        }
        System.out.println("The message after email sent is :"+successMessage);


        sheet1.getRow(1).createCell(9).setCellValue(successMessage);
        File src = new File("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\TestDataProd\\ProdIEMISKULookup.xlsx");
        FileOutputStream fos = new FileOutputStream(src);
        workbook.write(fos);
        workbook.close();





        sAssert.assertAll();



    }//end of @Test









}//end of Main Class
