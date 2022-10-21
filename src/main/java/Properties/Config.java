package Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    //Global Variables
    public WebDriver driver;
    public Properties prop;


    public WebDriver initializedDriver() throws IOException {

        prop = new Properties();
        FileInputStream fisc = new FileInputStream("src\\main\\java\\Properties\\data.properties");
        prop.load(fisc);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            //browser path
            System.setProperty("webdriver.chrome.driver","C:\\Users\\wahid.akbar\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            //browser path
            driver = new FirefoxDriver();
        }

        return driver;



    }//End of Initialized driver method for cross browser testing


    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        FileInputStream path = new FileInputStream("C:\\Users\\Wahid.Akbar\\OneDrive - Transcendent Solutions\\Selenium\\Vistrue_Automation\\src\\main\\java\\Properties\\data.properties");
        prop.load(path);
        System.out.println(prop.getProperty("url"));


    }//end of this main method








}//end of main class

