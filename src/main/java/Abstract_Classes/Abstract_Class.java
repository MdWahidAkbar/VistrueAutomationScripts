package Abstract_Classes;


import Reusable_Classes.Reuseable_Library;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Abstract_Class {


//to be used on your @test classes
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;


    //define before suite to set up a static driver
    @BeforeSuite
    public void defineDriver() {
        //driver = Reuseable_Library.setDriver();
        //define the report path here as a before suite
        reports = new ExtentReports("src//main//java//HTML_Report//TestResultReport6.html", true);

    }//end og before suite


    //before method will be used to capture a unique @test name that I gave on my test class
    @BeforeMethod
    public void getMethodName(Method testName) {
        driver = Reuseable_Library.setDriver();
        //start the logger here to capture the method name
        logger = reports.startTest(testName.getName());

    }//end of before method


    @AfterMethod
    public void endTest() throws InterruptedException {
        reports.endTest(logger);

        Thread.sleep(2000);
        driver.quit();

    }//end of After method


    @AfterSuite
    public void closeInfo() throws InterruptedException {
        reports.flush();

        //Thread.sleep(2000);
        //driver.quit();

    }//end of after suite












}//end of main class
