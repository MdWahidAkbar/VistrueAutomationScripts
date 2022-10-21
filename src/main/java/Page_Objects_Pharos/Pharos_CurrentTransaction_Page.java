package Page_Objects_Pharos;

import Abstract_Classes.Abstract_Class;
import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pharos_CurrentTransaction_Page extends Abstract_Class {

    ExtentTest logger;

    public Pharos_CurrentTransaction_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;

    }//end of constructor

    public Pharos_CurrentTransaction_Page pharos_TRC(){
        Reuseable_Library.click(driver,"//*[@id='MintekLabel1']","TRC",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page pharon_TRN(){
        Reuseable_Library.click(driver,"//*[@id='MintekLabel8']","TRN",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page pharon_TSU(){
        Reuseable_Library.click(driver,"//*[@id='MintekLabel3']","TSU",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page pharon_TII(){
        Reuseable_Library.click(driver,"//*[@id='MintekLabel6']","TII",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page pharos_TIR(){
        Reuseable_Library.click(driver,"//*[@id='MintekLabel9']","TIR",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page pharos_TUP(){
        Reuseable_Library.click(driver,"//*[@id='MintekLabel4']","TUP",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page select_Transaction(){
        Reuseable_Library.click(driver,"//*[@id='gridTCH_DXSelBtn0_D']","Selecting the transaction",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page release_Button(){
        Reuseable_Library.click(driver,"//*[@id='btnRelease']","Release Button",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page close_PopUp(){
        Reuseable_Library.click(driver,"//*[@id='PopupToolbar_lblCancel']","Closing the countdown Popup",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page recent_History(){
        Reuseable_Library.click(driver,"//input[@id='btnRecentHistory']","Recent History",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page edit(){
        Reuseable_Library.click(driver,"//*[@name='gridTCH:cell0_1:_ctl0']","Edit",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page refresh(){
        Reuseable_Library.click(driver,"//*[@title='Refresh Grid']","Refresh",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method

    public Pharos_CurrentTransaction_Page tranNum_Input(String userValue){
        Reuseable_Library.userKeys(driver,"//*[@id='gridTHH_DXFREditorcol4_I']",userValue,"TranNum Input Field",logger);
        return new Pharos_CurrentTransaction_Page(driver);
    }//end of method














}//end of main class
