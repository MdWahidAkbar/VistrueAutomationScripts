package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StoreInventory_Page extends Abstract_Class {


    ExtentTest logger;

    // selector
    By sharemodal = By.xpath("//ion-button[contains(text(),'Share')]");
    By email = By.xpath("(//mat-radio-button[contains(@id,'mat-radio')])[1]");
    By emailinput = By.xpath("//*[@class='self-email']/dx-tag-box[1]/div[1]/div[1]/div[1]/input[1]");
    By print = By.xpath("(//mat-radio-button[contains(@id,'mat-radio')])[2]");
    By download = By.xpath("(//mat-radio-button[contains(@id,'mat-radio')])[3]");
    By pdfformat = By.xpath("(//mat-radio-button[contains(@id,'mat-radio')])[4]");
    By csvformat = By.xpath("(//mat-radio-button[contains(@id,'mat-radio')])[5]");
    By excelformat = By.xpath("(//mat-radio-button[contains(@id,'mat-radio')])[6]");
    By continuebutton = By.xpath("//*[contains(@class,'continue-button')]");
    By emailsuccess = By.xpath("//span[contains(text(),'Success: Email sent to')]");


    public StoreInventory_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    }//end of constructor


    public StoreInventory_Page SendKeys(String userValue){
        Reuseable_Library.userKeys(driver,"",userValue,"",logger);
        return new StoreInventory_Page(driver);
    }//end of method

    public StoreInventory_Page Click(){
        Reuseable_Library.click(driver,"//*[@class='self-email']/dx-tag-box[1]/div[1]/div[1]/div[1]/input[1]","Email Input Field",logger);
        return new StoreInventory_Page(driver);
    }//end of method

    public StoreInventory_Page shareModal_Click(){
        Reuseable_Library.click(driver,"//ion-button[contains(text(),'Share')]","Share Modal Tab",logger);
        return new StoreInventory_Page(driver);
    }//end of method

    public StoreInventory_Page email_Click(){
        Reuseable_Library.click(driver,"(//mat-radio-button[contains(@id,'mat-radio')])[1]","Email Radio Button",logger);
        return new StoreInventory_Page(driver);
    }//end of method

    public StoreInventory_Page emailInput_Field(String userValue){
        Reuseable_Library.userKeys(driver,"//*[@class='self-email']/dx-tag-box[1]/div[1]/div[1]/div[1]/input[1]",userValue,"Enter Email Field",logger);
        return new StoreInventory_Page(driver);
    }//end of method


    public StoreInventory_Page print_Click(){
        Reuseable_Library.click(driver,"(//mat-radio-button[contains(@id,'mat-radio')])[2]","Print Radio Button",logger);
        return new StoreInventory_Page(driver);
    }//end of method

    public StoreInventory_Page download_Click(){
        Reuseable_Library.click(driver,"(//mat-radio-button[contains(@id,'mat-radio')])[3]","Download Radio Button",logger);
        return new StoreInventory_Page(driver);
    }//end of method
    public StoreInventory_Page pdfFormat_Click(){
        Reuseable_Library.click(driver,"(//mat-radio-button[contains(@id,'mat-radio')])[4]","PDF format Radio Button",logger);
        return new StoreInventory_Page(driver);
    }//end of method
    public StoreInventory_Page csvFormat_Click(){
        Reuseable_Library.click(driver,"(//mat-radio-button[contains(@id,'mat-radio')])[5]","CSV format Radio Button",logger);
        return new StoreInventory_Page(driver);
    }//end of method

    public StoreInventory_Page excelFormat_Click(){
        Reuseable_Library.click(driver,"(//mat-radio-button[contains(@id,'mat-radio')])[6]","Excel format Radio Button",logger);
        return new StoreInventory_Page(driver);
    }//end of method


    public StoreInventory_Page emailPrintDownload_Button(){
        Reuseable_Library.click(driver,"//*[contains(@class,'continue-button')]","Email or Print or Download Button",logger);
        return new StoreInventory_Page(driver);
    }//end of method













}//end of main class
