package Pages;

import HelfMethoden.ExceptionExistence;
import HelfMethoden.ExceptionInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import java.util.Properties;
import static HelfMethoden.ElementTest.ElementTestClick;
import static HelfMethoden.ElementTest.StringIsEmpty;


///für Login schreibt mann alle mögliche bottun oder felder oder .....
//mithilfe von xpath oder id oder class......
public class LoginPage extends MainPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //ohne jenkins
   //  String Email = LoadData.userData.getProperty("Email");
    //String Password = LoadData.userData.getProperty("Password");

    //Login button in menulist
    @FindBy(className = "ico-login")
    WebElement login;

    //Email feld
    @FindBy(id = "Email")
    WebElement EmailLogin;
// Password feld
    @FindBy(id = "Password")
    WebElement PassWordLogin;

    @FindBy(className = "login-button")
    WebElement loginButton;
// für bestätigung von Login
    @FindBy(className = "ico-logout")
    WebElement loginisDisplayed;

    //@FindBy(xpath = " /html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[2]/span/span")
    //WebElement loginEmailError;

    public void login() throws ExceptionInput, InterruptedException, ExceptionExistence, IOException {

        //für jenkins
       Properties prop = new Properties();//für jenkins sehe auch pom.xml
       prop.load(this.getClass().getResourceAsStream("/TestData.properties"));//für jenkins sehe auch pom.xml
       // LoadData
       String Email = prop.getProperty("Email");//für jenkins sehe auch pom.xml
       String Password = prop.getProperty("Password");//für jenkins sehe auch pom.xml*/


        ElementTestClick(login,"login");

        EmailLogin.isDisplayed();
        StringIsEmpty(Email,"Email");
        EmailLogin.sendKeys(Email);
        System.out.println(Email +"     "+ Password);
        PassWordLogin.isDisplayed();
        StringIsEmpty(Password,"Password");
        PassWordLogin.sendKeys(Password);

        ElementTestClick(loginButton,"loginButton");
      //if(loginEmailError.isDisplayed()) {
        //  throw new ExceptionExistence();
        //}

        loginisDisplayed.isDisplayed();
        loginisDisplayed.isEnabled();
        Thread.sleep(1000);
    }
}
