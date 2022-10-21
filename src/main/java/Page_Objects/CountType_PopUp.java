package Page_Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountType_PopUp {

    public static void main(String[] args) {

       WebDriver driver = null;

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        WebElement PhysicalCounts = (WebElement) jse.executeScript("return document.querySelector(\"app-new-count > div > div.radio-group > ion-radio-group > ion-item:nth-child(3) > tr-ion-radio > ion-radio\").shadowRoot.querySelector(\"div > div.radio-inner\")");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", PhysicalCounts);

        WebElement Next = (WebElement) jse.executeScript("return document.querySelector(\"app-new-count > div > div.buttons > ion-button.continue-button.ion-color.ios.button.button-round.ion-activatable.ion-focusable.hydrated.ion-color-primary.button-solid\").shadowRoot.querySelector(\"button\")");





    }

























}
