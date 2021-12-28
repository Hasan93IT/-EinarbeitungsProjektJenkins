package Pages;

import HelfMethoden.ExceptionExistence;
import HelfMethoden.ExceptionInput;
import HelfMethoden.LoadData;
import HelfMethoden.RandomGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static HelfMethoden.ElementTest.ElementTestClick;

//klasse für Register Testen
//falls keine Werte in TestData existieren, dann werden zufällige Werten eingegeben
public class RegisterPage extends MainPage {

    public static String PasswordRegister = RandomGenerator.RandomNumber(6);
    String Firstname1 = LoadData.userData.getProperty("Firstname");
    String Lastname1 = LoadData.userData.getProperty("Lastname");
    String Email1 = LoadData.userData.getProperty("Email");
    String Password1 = LoadData.userData.getProperty("Password");
    String Gender = LoadData.userData.getProperty("Gender");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ico-register")///
    WebElement RegisterMenu;

    @FindBy(id = "gender-male")
    WebElement MaleButton;

    @FindBy(id = "gender-female")
    WebElement FemaleButton;

    @FindBy(id = "FirstName")
    WebElement FirstName;

    @FindBy(id = "LastName")
    WebElement LastName;

    @FindBy(id = "Email")
    WebElement Email;

    @FindBy(id = "Password")
    WebElement Password;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPassword;

    @FindBy(id = "register-button")
    WebElement Registerbutton;

    @FindBy(className = "result")
    WebElement RegisterisDisplayed;

    @FindBy(className = "ico-logout")
    WebElement logout;

    public void Register() throws ExceptionInput, ExceptionExistence {

        ElementTestClick(RegisterMenu, "RegisterMenu");

        //Random Generator für Auswahl radio button male oder radio button FemaleButton
        if (Gender.isEmpty()) {
            if (RandomGenerator.RandomBoolean()) {
                ElementTestClick(MaleButton, "MaleButton");
            } else {
                ElementTestClick(FemaleButton, "FemaleButton");
            }
        } else {//falls werte für Gender vorhanden sind
            if (Gender.equals("M") || Gender.equals("m")) {
                ElementTestClick(MaleButton, "MaleButton");

            } else if (Gender.equals("F") || Gender.equals("f")) {
                ElementTestClick(FemaleButton, "FemaleButton");

            } else {
                throw new ExceptionInput("nur F Oder M");
            }
        }//überprüfung, ob die Werte in TestData existieren
        if (Firstname1.isEmpty() || Lastname1.isEmpty() || Email1.isEmpty() || Password1.isEmpty()) {

            FirstName.sendKeys(RandomGenerator.RandomString(5));
            LastName.sendKeys(RandomGenerator.RandomString(5));
            Email.sendKeys(RandomGenerator.RandomString(5) +
                    "@" + RandomGenerator.RandomString(4) + ".de");
            Password.sendKeys(PasswordRegister);
            ConfirmPassword.sendKeys(PasswordRegister);
            System.out.println("Hinweis: es werden zufälligen Werte für Email und Password eingegebn," +
                    "\n" + " denn Firstname odre Lastname ist nicht TestDate eingegeben");
        } else {
            //sonst werden die Werte von TestData angewendet
            FirstName.sendKeys(Firstname1);
            LastName.sendKeys(Lastname1);
            Email.sendKeys(Email1);
            Password.sendKeys(Password1);
            ConfirmPassword.sendKeys(Password1);

        }
        ElementTestClick(Registerbutton, "Registerbutton");
        //überprufung, ob register erfolgreich ist
        RegisterisDisplayed.isDisplayed();
        RegisterisDisplayed.isEnabled();

        ElementTestClick(logout, "logout");
    }
}
