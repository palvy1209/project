package org.example.pom;

import org.example.constant.ConstantData;
import org.example.excelsheets.ReadWriteExcel;
import org.example.utils.ImplicitWait;
import org.example.utils.OperateDrive;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class FlightPom {

    static
    {PageFactory.initElements(OperateDrive.driver,new FlightPom());}
    @FindBy(xpath = "//a[@class='close']")
    public static WebElement closeMAdd;
    @FindBy(xpath = "//iframe[@name='notification-frame-~10cb502bc']")
    public static WebElement popupifram;
    @FindBy(xpath = "//input[@id='fromCity']")
    public static WebElement source;
    @FindBy(xpath = "//div[@id='react-autowhatever-1']")
    public static WebElement sorceDropdown;
    @FindBy(xpath = "//div[@class='makeFlex column flexOne']//span/span")
    public static List<WebElement> sorceDropDownItem;
    @FindBy(xpath = "//input[@id='toCity']")
    public static WebElement destination;
    @FindBy(xpath = "//li[@role='option']//div[contains(@class,'makeFlex column flexOne')]//span/span")
    public static List<WebElement> desDropDownItem;
    @FindBy(xpath = "//label[@for='departure']")
    public static WebElement date;
    @FindBy(xpath = "//span[contains(@class,'--next')]")
    public static WebElement next;
    @FindBy(xpath = "//span[contains(@class,'--prev')]")
    public static WebElement prev;
    @FindBy(xpath = "//div[contains(@class,'DayPicker-Caption')]/div")
    public static WebElement caption;
    @FindBy(xpath = "//div[@class='DayPicker-Day']//div[@class='dateInnerCell']/p[position()=1]")
    public static List<WebElement> dates;
    @FindBy(xpath = "//a[contains(text(),'Search')]")
    public static WebElement searchbutton;
    @FindBy(xpath = "//font[contains(text(),'Offers')]")
    public static WebElement offerHeading;

    public static void closePopup() throws IOException {

        ReadWriteExcel.writeTOExcel(ConstantData.sheenName,0,0,"Mumbai");
        ReadWriteExcel.writeTOExcel(ConstantData.sheenName,0,1,"Dubai");
        String sorce=ReadWriteExcel.readToExcel(ConstantData.sheenName,0,0).getStringCellValue();
        String desc=ReadWriteExcel.readToExcel(ConstantData.sheenName,0,1).getStringCellValue();

//      if(ImplicitWait.visiblityofElement(popupifram)){
//      OperateDrive.driver.switchTo().frame(popupifram);
//      closeMAdd.click();}
        source.sendKeys(sorce);
        selectsource(sorce);
        destination.sendKeys(Keys.ENTER);
        destination.sendKeys(desc);
        selectDestination(desc);
        date.sendKeys(Keys.ENTER);
        ImplicitWait.thread(100);
        setDate(ConstantData.month,ConstantData.date);
        ImplicitWait.mouseHover(destination);
        searchbutton.click();
    }

    private static void selectDestination(String desc)
    {
        for (WebElement des:desDropDownItem)
        {
            if (des.getText().contains(desc))
            {
                des.click();
                break;
            }
        }
    }

    private static void selectsource(String sorce) {
       for (WebElement element:sorceDropDownItem)
       {
           if(element.getText().contains(sorce))
           {
               element.click();
               break;
           }
       }
    }

    private static void setDate(String month,int date)
    {
        while(!caption.getText().contains(month))
        {  next.click();}
       for (WebElement webElement: dates)
       {
            if(webElement.getText().contains(Integer.toString(date)))
           {
               ImplicitWait.scrollBy(300);
               ImplicitWait.thread(100);
               webElement.click();
               break;
           }
       }
    }
}
