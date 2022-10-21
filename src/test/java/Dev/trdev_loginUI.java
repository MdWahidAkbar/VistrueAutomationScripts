package Dev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class trdev_loginUI {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver104.exe");
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\wahid.akbar\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://trdev.transcendent.ai/TRWeb/login.aspx");

        System.out.println("Page title of trdev UI Page is : "+driver.getTitle());

        driver.findElement(By.id("txtUsername")).sendKeys("wakbar");
        driver.findElement(By.id("txtPassword")).sendKeys("Comcast1");
        driver.findElement(By.xpath("//*[@class='css-label']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(text(),'Log In')]")).click();
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@id='Inventory']")).click();
        driver.findElement(By.xpath("//*[text()='Inventory Location']")).click();
        System.out.println("Page title of Inventory Location Page is : "+driver.getTitle());

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='Inventory']")).click();
        driver.findElement(By.xpath("//*[text()='Transaction History']")).click();
        System.out.println("Page title of Transaction History Page is : "+ driver.getTitle());


        Thread.sleep(3000);

        driver.quit();


    }//end of main method


}//end of main class
