package Test_Environment.Transaction_History;

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
import java.util.Properties;

public class ShareModal_TransactionHistory extends Abstract_Class {

    //for XLSX spread sheet data driven
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet1;
    int rowcount;
    int row;


    @Test
    public void ShareModal_TransHistory() throws InterruptedException, IOException {

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


        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(4000);
        logger.log(LogStatus.INFO,"Navigation to XInventory Dashboard page is successful");
        Thread.sleep(2000);

        //Clicking on Menu by using mouse hover and mouse click
        Base_Class.menu_bar().menu_Bar();
        Thread.sleep(1000);
        Base_Class.menu_bar().transaction_History();
        Thread.sleep(4000);

        Base_Class.tranHistLanding_page().Status_Tab();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().completed();
        Thread.sleep(1000);

        Base_Class.tranHistLanding_page().type();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().upgradeTradeIn_CountType();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().returnDefective_CountType();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().weekly_CountType();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().physical_CountType();
        Thread.sleep(1000);

        Base_Class.tranHistLanding_page().apply();
        Thread.sleep(4000);

        Base_Class.tranHistLanding_page().checkbox1();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().checkbox2();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().checkbox3();
        Thread.sleep(1000);
        Base_Class.tranHistLanding_page().checkbox4();
        Thread.sleep(2000);

        Base_Class.tranHistLanding_page().shareModal();
        Thread.sleep(2000);

        //Email the Excel report-------------------------------------------------
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
        Thread.sleep(2000);

        //Print the PDF report----------------------------------------------------
        Base_Class.tranHistLanding_page().shareModal();
        Thread.sleep(1000);
        Base_Class.share_Modal().print_Click();
        Thread.sleep(500);
        Base_Class.share_Modal().emailPrintDownload_Button();
        Thread.sleep(3000);







    }//end of @Test









}//end of Main Class
