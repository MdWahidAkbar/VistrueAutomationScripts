package Pharos;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class B_TRC extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void TRC_Serialized() throws InterruptedException, IOException {

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\PharosDev.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);

        rowcount = sheet1.getLastRowNum();

        driver.navigate().to("https://trdev.transcendent.ai/trweb/");
        logger.log(LogStatus.INFO, "Navigation to DEV LogIn page");
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

        Base_Class.landing_page().pharos_TransactionDEV();
        Thread.sleep(1000);
        Base_Class.landing_page().pharon_CurrentTransaction();
        Thread.sleep(1000);
        driver.switchTo().frame("ContentFrame");
        Base_Class.pharos_currentTransaction_page().pharos_TRC();

        Thread.sleep(1000);

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to Pharos receiving PopUp");
        Thread.sleep(1000);

        String reference = sheet1.getRow(4).getCell(1).getStringCellValue();
        Base_Class.pharos_transaction_popUp().reference(reference);
        Thread.sleep(500);
        //String order = sheet1.getRow(5).getCell(1).getStringCellValue();
        String order = dataFormatter.formatCellValue(sheet1.getRow(5).getCell(1));
        Base_Class.pharos_transaction_popUp().order(order);
        Thread.sleep(500);
        String toStatus = sheet1.getRow(8).getCell(1).getStringCellValue();
        Base_Class.pharos_transaction_popUp().toStatus(toStatus);
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id='cbISMStatus_I']")).sendKeys(Keys.ENTER);
        Thread.sleep(500);

        String tranNumTSU = dataFormatter.formatCellValue(sheet1.getRow(14).getCell(1));
        Base_Class.pharos_transaction_popUp().trannum(tranNumTSU);
        Thread.sleep(500);
        String toLocation = sheet1.getRow(9).getCell(1).getStringCellValue();
        Base_Class.pharos_transaction_popUp().toLocation(toLocation);
        Thread.sleep(1000);
        Base_Class.pharos_transaction_popUp().save();
        Thread.sleep(1000);

/*
        //This is for single or specific serial to receive
        driver.findElement(By.xpath("//*[@id='txtAddBySerialListSerials']")).sendKeys("123456789");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='_ctl41_pcAddBySerialList_btnAdd']")).click();
        Thread.sleep(1000);
*/



        driver.switchTo().window(tab.get(0));
        Thread.sleep(1000);
        driver.switchTo().frame("ContentFrame");

        //Count Information Table--------------------
        String trannum = Reuseable_Library.captureText(driver,"/html[1]/body[1]/form[1]/table[2]/tbody[1]/tr[1]/td[2]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[7]/span[1]/a[1]","Transaction Number",logger);
        sheet1.getRow(19).createCell(1).setCellValue(trannum);
        Thread.sleep(1000);

        //Writing data to Excel
        File src = new File("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\PharosDev.xlsx");
        FileOutputStream fos = new FileOutputStream(src);
        workbook.write(fos);
        workbook.close();

        Base_Class.pharos_currentTransaction_page().select_Transaction();
        Thread.sleep(1000);
        Base_Class.pharos_currentTransaction_page().release_Button();
        Thread.sleep(3000);

        ArrayList<String> tab3 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab3.get(1));
        Thread.sleep(1000);
        Base_Class.pharos_currentTransaction_page().close_PopUp();
        Thread.sleep(10000);


        driver.switchTo().window(tab.get(0));
        driver.switchTo().frame("ContentFrame");

        Base_Class.pharos_currentTransaction_page().refresh();
        Thread.sleep(1000);
        Base_Class.pharos_currentTransaction_page().refresh();
        Thread.sleep(2000);

        Base_Class.pharos_currentTransaction_page().recent_History();
        Thread.sleep(1000);

        String tranNum_Input = sheet1.getRow(19).getCell(1).getStringCellValue();
        Base_Class.pharos_currentTransaction_page().tranNum_Input(tranNum_Input);
        Thread.sleep(4000);

        //driver.switchTo().frame("ContentFrame");
        String statusName = driver.findElement(By.xpath("//tbody/tr[@id='gridTHH_DXDataRow0']/td[11]")).getText();
        if (statusName.equalsIgnoreCase("P")){
            System.out.println("The Status is 'P' and TestCase is passed");
            logger.log(LogStatus.PASS, "The Status is "+statusName+" and TestCase is PASSED");

        }else {
            System.out.println("Test case is failed and the Status name is "+statusName);
            logger.log(LogStatus.FAIL, "The Status is "+statusName+" and TestCase is FAILED");

        }//end of If Else condition.





    }//end of @Test

}//end of main class
