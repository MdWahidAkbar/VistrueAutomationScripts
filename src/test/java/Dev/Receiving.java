package Dev;

import Abstract_Classes.Abstract_Class;
import Page_Objects.Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Receiving extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;


    @Test
    public void Shipping() throws InterruptedException, IOException {

        //Implicit Wait for the whole page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        DataFormatter dataFormatter = new DataFormatter();

        //For XLSX Data Driven
        fis = new FileInputStream("C:\\Users\\wahid.akbar\\OneDrive - Transcendent Solutions\\Documents\\Receiving&Shipping.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);

        rowcount = sheet1.getLastRowNum();

        driver.navigate().to("https://cceistest.mintek.com/eisweb/");
        logger.log(LogStatus.INFO, "Navigation to TEST LogIn page");
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
        String SiteVisibility = sheet1.getRow(2).getCell(2).getStringCellValue();
        Base_Class.landing_page().site_Visibility_Input(SiteVisibility);
        Thread.sleep(2000);
        Base_Class.landing_page().site_Visibility_findClick(SiteVisibility);
        Thread.sleep(1000);

        Base_Class.landing_page().pharos_Transaction();
        Thread.sleep(1000);
        Base_Class.landing_page().pharon_CurrentTransaction();
        Thread.sleep(1000);
        driver.switchTo().frame("ContentFrame");
        Base_Class.landing_page().pharos_receive();

        Thread.sleep(1000);

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(1000);
        logger.log(LogStatus.INFO,"Navigation to Pharos receiving PopUp");
        Thread.sleep(1000);

        Base_Class.pharos_receivingPopUp().reference("wa");
        Thread.sleep(500);
        Base_Class.pharos_receivingPopUp().order("1234");
        Thread.sleep(500);
        Base_Class.pharos_receivingPopUp().toStatus("Available");
        Thread.sleep(500);
        //====================================driver.findElement(By.xpath("//*[@id='cbISMStatus_I']")).sendKeys("Available");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='txtLocationLookupID']")).sendKeys("Available");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='tdSerialList']/div")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='txtAddBySerialListSerials']")).sendKeys("123456789");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='_ctl41_pcAddBySerialList_btnAdd']")).click();
        Thread.sleep(500);
        driver.switchTo().window(tab.get(0));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='gridTCH_DXDataRow0']/td[2]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id='tdNonSerialized']/div")).click();
        driver.findElement(By.xpath("//input[@id='txtLocationLookupID']")).sendKeys("Available");
        driver.findElement(By.xpath("//*[@id='txtModelLookupDescription']")).sendKeys("000000243");
        driver.findElement(By.xpath("//*[@id='txtQuantity']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@name='_ctl9']")).click();
        driver.findElement(By.xpath("//*[@id='PopupToolbar_lbl_custom_btnUpdate']")).click();
        driver.findElement(By.xpath("//*[@id='gridTCH_DXDataRow0']/td/span")).click();
        driver.findElement(By.xpath("//*[@id='btnRelease']")).click();
        driver.findElement(By.xpath("//*[@id='PopupToolbar_divCancel']")).click();











    }//end of @Test

}//end of main class
