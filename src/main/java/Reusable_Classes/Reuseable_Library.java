package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Reuseable_Library {

    static int timeout = 15;


    //method to re use chrome driver and chrome options
    public static WebDriver setDriver() {

        //set the chrome path
        System.setProperty("webdriver.chrome.driver","C:\\Users\\wahid.akbar\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //set some pre conditions using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");//
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of setDriver method



    //method to enter user input on send keys
    public static void userKeys(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            System.out.println("Entering a value on element :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            element.click();
            Thread.sleep(700);
            element.clear();
            Thread.sleep(1000);
            element.sendKeys(userInput);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Unable to enter element :" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element :" + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of the try-catch condition
    }//end of sendkeys method


    //method to click on an element
    public static void click(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            System.out.println("Clicking a value on element :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            Thread.sleep(300);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click element :" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element :" + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    public static void userKeys_JS(WebDriver driver, String locator, String userInput, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            System.out.println("Entering a value on element :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
            Thread.sleep(500);
            element.clear();
            Thread.sleep(700);
            element.sendKeys(userInput);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Unable to enter element :" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element :" + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }//end of the try-catch condition
    }//end of sendkeys method

    //method to click on an element
    public static void click_JS(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            System.out.println("Clicking a value on element :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("Unable to click element :" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element :" + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method


    //method to click on an element
    public static void submit(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            System.out.println("Clicking a value on element :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to click element :" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element :" + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method

    //method to click by index on an element
    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName,ExtentTest logger){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try{
            System.out.println("Clicking a value by index " + index + " on element :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element :" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method
    //method to return text from an element
    public static String captureText(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        String result = null;
        try {

            System.out.println("Capturing a text from element :" + elementName);
            //Reporter.log("Capturing a text from element " + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            result = element.getText();
            System.out.println("My Text result is " + result);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element :" + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element :" + elementName + " " + e);
            getScreenShot(driver,logger,elementName);

        }

        return result;
    }//end of click method


    //method to submit on an element
    public static void mouseHover(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Actions mouse = new Actions(driver);
        try {
            System.out.println("Hoverfing the mouse :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            mouse.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }

    }//end of click method

    //method to submit on an element
    public static void mouseClick(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Actions mouse = new Actions(driver);
        try {
            System.out.println("Hovering the mouse :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            //mouse.moveToElement(element).perform();
            mouse.moveToElement(element).click().build().perform();
            //element.click();
            //element.submit();
        } catch (Exception e) {
            System.out.println("Unable to " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }

    }//end of click method


    //method to select a drop down value by visible text
    public static void dropdownBy(WebDriver driver, String locator, String userInput, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            System.out.println("Selecting a value on element " + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            WebElement element = driver.findElement(By.xpath(locator));
            Select dDown = new Select(element);
            dDown.selectByVisibleText(userInput);
        } catch (Exception e) {
            System.out.println("Unable to select element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }
    }//end of drop down by text method

    public static void KeyDownAndEnter(WebDriver driver, String locator, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        try {

            System.out.println("Keyboard operation:down and enter :" + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.sendKeys(Keys.ARROW_DOWN);
            element.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Unable to " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }

    }//end of keyboard method


    public static void scrollDown(WebDriver driver, String locator,int xOffset, int yOffset, String elementName,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Actions mouse = new Actions(driver);
        try {

            System.out.println("Keyboard operation:down and enter " + elementName);
            logger.log(LogStatus.INFO," Clicking a value on element :" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            mouse.dragAndDropBy(element,xOffset,yOffset).perform();
        } catch (Exception e) {
            System.out.println("Unable to " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
            getScreenShot(driver,logger,elementName);
        }

    }//end of keyboard method



    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver, ExtentTest logger, String imageName){
        try {
            String fileName = imageName + ".png";
            String directory = "src//main//java//HTML_Report//Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots//" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//end of try catch

    }//end of get screenshot method


















}//end of main class
