package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.*;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

@Listeners(TestListiner.class)

public class OperateDrive{

  public static WebDriver driver;
    public static void main(String[] args) {
        readData();
        System.out.println(getPropertyValue("URL"));
    }
    public static Properties readData()
    {
        FileInputStream datafile;
        Properties dataperties;
        try {
             datafile=new FileInputStream(new File("C:\\Users\\Vyom\\OneDrive\\Software Testing\\MakeMyTrip\\src\\propertyfile\\globaldata\\globaltestdata.properties.properties"));
             dataperties=new Properties();
            dataperties.load(datafile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataperties;
    }

    public static String getPropertyValue(String data)
    {
        String readedData=null;
        switch (data)
        {
            case "URL" :
            {
               readedData= OperateDrive.readData().getProperty(data);
               break;
            }
            case "browser" :
            {
               readedData= OperateDrive.readData().getProperty(data);
               break;
            }
            default:
            {
                System.out.println("Select Valid Data ");
            }
        }
       return readedData;
    }


     @BeforeSuite
     public static void runDriver()
     {
            String data= OperateDrive.getPropertyValue("browser");

          switch (data)
          {
              case "chrome" :
              {
                  ChromeOptions chromeOptions=new ChromeOptions();
                  chromeOptions.addArguments("--disable-notifications");
                 driver=new ChromeDriver(chromeOptions);
                 getURL(driver);
              }
          }
     }
     public static void getURL(WebDriver driver)
     {
         String url=OperateDrive.getPropertyValue("URL").replace("'","");
         driver.get(url);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
     }

     @AfterSuite
     public static void closeDriver()
     {
//         driver.quit();
     }



}
