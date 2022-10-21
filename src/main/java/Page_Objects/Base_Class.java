package Page_Objects;

import Abstract_Classes.Abstract_Class;
import Page_Objects_Pharos.Pharos_CurrentTransaction_Page;
import Page_Objects_Pharos.Pharos_NonSerialized_PopUp;
import Page_Objects_Pharos.Pharos_Serialized_PopUp;
import Page_Objects_Pharos.Pharos_Transaction_PopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Class extends Abstract_Class {

    public Base_Class(WebDriver driver){
    super();
        PageFactory.initElements(driver, this);
    }//end of Yahoo Base Class


    //Objects for all the pages_______________________________________________
    public static Login_Page login_Page(){
        Login_Page login_Page = new Login_Page(driver);
        return login_Page;

    }//end of object reference for yahoo homepage

    public static Landing_Page landing_page(){
        Landing_Page landing_page = new Landing_Page(driver);
        return landing_page;

    }//end of Method

    public static XinventoryDashboard_Page xinventoryDashboard_page() {
        XinventoryDashboard_Page xinventoryDashboard_page = new XinventoryDashboard_Page(driver);
        return xinventoryDashboard_page;
    }//end of method

    public static CountLanding_Page countLanding_page() {
        CountLanding_Page countLanding_page = new CountLanding_Page(driver);
        return countLanding_page;
    }//end of method

    public static InitialCount_Page initialCount_page() {
        InitialCount_Page initialCount_page = new InitialCount_Page(driver);
        return initialCount_page;
    }//end of method

    public static VarianceCount_Page varianceCount_page() {
        VarianceCount_Page varianceCount_page = new VarianceCount_Page(driver);
        return varianceCount_page;
    }//end of method

    public static CountSummary_Page countSummary_page() {
        CountSummary_Page countSummary_page = new CountSummary_Page(driver);
        return countSummary_page;
    }//end of method

    public static CountProgress_Page countProgress_page() {
        CountProgress_Page countProgress_page = new CountProgress_Page(driver);
        return countProgress_page;
    }//end of method

    public static IMEILookUp_Page imeiLookUp_page() {
        IMEILookUp_Page imeiLookUp_page = new IMEILookUp_Page(driver);
        return imeiLookUp_page;
    }//end of method

    public static SKULookUp_Page skuLookUp_page() {
        SKULookUp_Page skuLookUp_page = new SKULookUp_Page(driver);
        return skuLookUp_page;
    }//end of method

    public static AdjustInventory_Page adjustInventory_page() {
        AdjustInventory_Page adjustInventory_page = new AdjustInventory_Page(driver);
        return adjustInventory_page;
    }//end of method

    public static ShippingLanding_Page shippingLanding_page() {
        ShippingLanding_Page shippingLanding_page = new ShippingLanding_Page(driver);
        return shippingLanding_page;
    }//end of method

    public static ShippingAdding_Page shippingAdding_page() {
        ShippingAdding_Page shippingAdding_page = new ShippingAdding_Page(driver);
        return shippingAdding_page;
    }//end of method

    public static PackingSlipandLabel_Page packingSlipandLabel_page() {
        PackingSlipandLabel_Page packingSlipandLabel_page = new PackingSlipandLabel_Page(driver);
        return packingSlipandLabel_page;
    }//end of method

    public static ReceivingLanding_Page receivingLanding_page() {
        ReceivingLanding_Page receivingLanding_page = new ReceivingLanding_Page(driver);
        return receivingLanding_page;
    }//end of method

    public static ReceivingActual_Page receivingActual_page() {
        ReceivingActual_Page receivingActual_page = new ReceivingActual_Page(driver);
        return receivingActual_page;
    }//end of method

    public static Menu_Bar menu_bar() {
        Menu_Bar menu_bar = new Menu_Bar(driver);
        return menu_bar;
    }//end of method

    public static StoreInventory_Page storeInventory_page() {
        StoreInventory_Page storeInventory_page = new StoreInventory_Page(driver);
        return storeInventory_page;
    }//end of method

    public static Share_Modal share_Modal() {
        Share_Modal share_Modal = new Share_Modal(driver);
        return share_Modal;
    }//end of method

    public static Pharos_CurrentTransaction_Page pharos_currentTransaction_page() {
        Pharos_CurrentTransaction_Page pharos_currentTransaction_page = new Pharos_CurrentTransaction_Page(driver);
        return pharos_currentTransaction_page;
    }//end of method

    public static Pharos_Transaction_PopUp pharos_transaction_popUp() {
        Pharos_Transaction_PopUp pharos_transaction_popUp = new Pharos_Transaction_PopUp(driver);
        return pharos_transaction_popUp;
    }//end of method

    public static Pharos_Transaction_PopUp pharos_receivingPopUp() {
        Pharos_Transaction_PopUp pharos_transactionPopUp = new Pharos_Transaction_PopUp(driver);
        return pharos_transactionPopUp;
    }//end of method

    public static Pharos_NonSerialized_PopUp pharos_nonSerialized_popUp() {
        Pharos_NonSerialized_PopUp pharos_nonSerialized_popUp = new Pharos_NonSerialized_PopUp(driver);
        return pharos_nonSerialized_popUp;
    }//end of method

    public static Pharos_Serialized_PopUp pharos_serialized_popUp() {
        Pharos_Serialized_PopUp pharos_serialized_popUp = new Pharos_Serialized_PopUp(driver);
        return pharos_serialized_popUp;
    }//end of method

    public static TranHistLanding_Page tranHistLanding_page(){
        TranHistLanding_Page tranHistLanding_page = new TranHistLanding_Page(driver);
        return tranHistLanding_page;

    }//end of Method






}//end of java class
