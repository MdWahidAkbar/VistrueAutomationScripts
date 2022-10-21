package Page_Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JScript_Counts {

    public static void main(String[] args) {

        WebDriver driver = null;

        JavascriptExecutor jse = (JavascriptExecutor) driver;




        //Count Summary DONE............
        WebElement finalDone = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > ion-app > ion-router-outlet > app-reconciliation > app-variance-result > div > div.button-section > ion-button\").shadowRoot.querySelector(\"button\")");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", finalDone);

        //Variance Page RETURN DEFECTIVE
        WebElement variancePageReturnDefective = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > ion-app > ion-router-outlet > app-reconciliation > app-conduct-variance > div > div > ion-button\").shadowRoot.querySelector(\"button\")");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", variancePageReturnDefective);

        //Variance Page UPGRADE TRADEIN
        WebElement variancePageUpgradeTradeIn = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > ion-app > ion-router-outlet > app-reconciliation > app-conduct-variance > div > div > ion-button\").shadowRoot.querySelector(\"button\")");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", variancePageUpgradeTradeIn);

        //Variance page DONE
        WebElement variancePageDone = (WebElement) jse.executeScript("return document.querySelector(\"body > app-root > ion-app > ion-router-outlet > app-reconciliation > app-conduct-variance > div > div > ion-button\").shadowRoot.querySelector(\"button\")");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", variancePageDone);




    }

















}
