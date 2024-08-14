package org.example.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ImplicitWait {
    public static boolean visiblityofElement(WebElement element)
    {
        boolean flag=true;
        try {
            WebDriverWait wait=new WebDriverWait(OperateDrive.driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e)
        {
            flag =false;
            e.getMessage();
        }
       return flag;
    }
    public static void scrollBy(int seconds)
    {
        JavascriptExecutor js=(JavascriptExecutor)OperateDrive.driver;
        js.executeScript("window.scrollBy(0,"+seconds+")");
    }
    public static void scrollByElement(WebElement element,int seconds)
    {
        WebDriver driver= (WebDriver) element;
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+seconds+")");
    }

    public static void thread(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mouseHover(WebElement targetelement)
    {
        Actions actions=new Actions(OperateDrive.driver);
        actions.moveToElement(targetelement).perform();
    }

}
