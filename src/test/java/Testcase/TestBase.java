package Testcase;

import HelfMethoden.FormatedDate;
import HelfMethoden.LoadData;
import HelfMethoden.OpenFile;
import HelfMethoden.TestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static HelfMethoden.Input.InputString1;


public class TestBase {
    //OpenFile Report;
    //GUI Warnung;
    OpenFile Screenshot;
    FormatedDate Datum;

    /*
    GUI Warnung;
    public static WebDriver driver;
    public String WebAppPath = LoadData.userData.getProperty("WebAppPath");


    @BeforeSuite
    @Parameters({"browser"})

    public void startDriver() {
        String chromePath=   System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
        System.out.println(chromePath);
        try {
            // System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",chromePath);
            driver = new ChromeDriver();
            driver.navigate().to(WebAppPath);
        } catch (Exception e) {
            Warnung = new GUI();
            Warnung.DialogTest("chromedriver ist nicht in " + chromePath);
            System.out.println("chromedriver ist nicht in " + chromePath);
        }
    }
*/
    public static WebDriver driver;

    public String WebAppPath = LoadData.userData.getProperty("WebAppPath");  //ohne Jenkins

    @BeforeSuite
    @Parameters({"browser"})
    public void StartDriver(@Optional("chrome") String browser) throws IOException {
        Screenshot = new OpenFile();
     if (browser.equalsIgnoreCase("chrome")) {
         //   String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
         //   System.setProperty("webdriver.chrome.driver", chromePath);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("chrome-headless")) {
           // String chromePath2 = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
          //  System.setProperty("webdriver.chrome.driver", chromePath2);
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
           // String Path = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
           // System.setProperty("webdriver.gecko.driver", Path);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            //TODO

        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            //TODO

        } else if (browser.equalsIgnoreCase("headless")) {

            WebDriverManager.iedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver =new  ChromeDriver(options);


          //  String Path = System.getProperty("user.dir") + "\\drivers\\phantomjs.exe";
          //  DesiredCapabilities des = new DesiredCapabilities();
          //  des.setJavascriptEnabled(true);
          //  des.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, Path);
          //  String[] phantomJsArgument = {"--webdriver-loglevel=NONE", "--web-security=no", "--ignore-ssl-errors=yes"};
          //  des.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgument);
          //  driver = new PhantomJSDriver(des);
        }

     //  driver.navigate().to(System.getProperty("name"));//für jenkins sehe auch pom.xml
     /*  Properties prop = new Properties();//für jenkins sehe auch pom.xml
       prop.load(this.getClass().getResourceAsStream("/TestData.properties"));//für jenkins sehe auch pom.xml
      String WebAppPath = prop.getProperty("WebAppPath");//für jenkins sehe auch pom.xml*/

        driver.navigate().to(WebAppPath);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void TearDown(ITestResult result) {
        // Here will compare if test is failing then only it will enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Create refernce of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Copy method  specific location here it will save all screenshot in our project home directory and
                //result.getName() will return name of test case so that screenshot name will be same
                Datum = new FormatedDate();
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + "_" + Datum.getFormatedDate() + ".png"));
                System.out.println("Screenshot taken");
                Screenshot.OpenScreenshot();
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
            result.getStatus();
        }
    }

    @AfterSuite
    public void QuitDriver() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
      /*  Report = new OpenFile();
        Report.OpenTestReport();*/
    }
}
