package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

    public WebDriver driver;

    //CSS selector
    By email = By.cssSelector("[id='user_email']");
    By sendMeInstructions = By.cssSelector("[type='submit']");

    public ForgotPassword(WebDriver driver) {

        this.driver = driver;

    }//end of LandingPage method


    public WebElement getEmail() {

        return driver.findElement(email);

    }//end of Method

    public WebElement sendMeInstructions() {

        return driver.findElement(sendMeInstructions);

    }//end of Method






}//end of main class............
