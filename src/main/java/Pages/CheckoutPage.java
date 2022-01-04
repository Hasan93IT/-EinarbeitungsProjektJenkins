package Pages;

import HelfMethoden.ExceptionExistence;
import HelfMethoden.ExceptionInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

import static HelfMethoden.ElementTest.ElementTestClick;
import static HelfMethoden.ElementTest.StringIsEmpty;


public class CheckoutPage extends MainPage {

  //  private final String Country = LoadData.userData.getProperty("Country");
  //  private final String StateProvince = LoadData.userData.getProperty("StateProvince");
  //  private final String ZipPostalCode = LoadData.userData.getProperty("ZipPostalCode");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ZipPostalCode")
    WebElement ZipPostalCode1;

    @FindBy(id = "termsofservice")
    WebElement Agree;

    @FindBy(id = "checkout")
    WebElement CheckoutButton;





    @FindBy(id = "BillingNewAddress_City")
    WebElement BillingAddresscity;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement BillingAddressAddress;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement BillingAddressZip;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement BillingAddressphon;

   /* @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
    WebElement BillingAddressButton;*/






    @FindBy(xpath = "//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/input[1]")
    WebElement BillingAddressButton;

    @FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
    WebElement ShippingAddressButton;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
    WebElement ShippingMethodButton;

    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
    WebElement PaymentMethodButton;

    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
    WebElement PaymentInformationButton;

    @FindBy(xpath = "//*[@id=\"checkout-payment-info-load\"]/div/div/div[1]/table/tbody/tr/td/p")
    WebElement PaymentInformation;

    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
    WebElement ConfirmOrderButton;

    @FindBy(xpath = " /html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")
    WebElement successOrderText;

    @FindBy(xpath = " /html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")
    WebElement OrderEnd;

    public void EstimateShippingPage(WebDriver driver) throws InterruptedException, ExceptionInput, ExceptionExistence, IOException {

        //für jenkins
        Properties prop = new Properties();//für jenkins sehe auch pom.xml
        prop.load(this.getClass().getResourceAsStream("/TestData.properties"));//für jenkins sehe auch pom.xml
        // LoadData

        String Country = prop.getProperty("Country");//für jenkins sehe auch pom.xml
        String StateProvince = prop.getProperty("StateProvince");//für jenkins sehe auch pom.xml*/
        String ZipPostalCode = prop.getProperty("ZipPostalCode");//für jenkins sehe auch pom.xml*/
        Thread.sleep(2000);


        Select CountryMenu = new Select(driver.findElement(By.xpath(
                "/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/select[1]")));
        StringIsEmpty(Country,"Country");
        Thread.sleep(1000);
        CountryMenu.selectByVisibleText(Country);

        Select StateProvince1 = new Select(driver.findElement(By.id("StateProvinceId")));

        StringIsEmpty(StateProvince,"StateProvince");
        Thread.sleep(2000);
        StateProvince1.selectByVisibleText(StateProvince);


        ZipPostalCode1.clear();
        StringIsEmpty(ZipPostalCode,"ZipPostalCode");
        Thread.sleep(1000);
        ZipPostalCode1.sendKeys(ZipPostalCode);

        ElementTestClick(Agree,"Agree");

        Thread.sleep(2000);
        ElementTestClick(CheckoutButton,"CheckoutButton");
       // System.out.println("hier fehler1");

        Thread.sleep(2000);
    }

    // mit neu register test
    public void BillingAddressPage1(WebDriver driver) throws InterruptedException, ExceptionExistence {
        Thread.sleep(1000);
        Select BillingAddress = new Select(driver.findElement(By.id(
                "BillingNewAddress_CountryId")));
        Thread.sleep(1000);
        BillingAddress.selectByVisibleText("Canada");
        //   BillingAddress.selectByIndex(2);
        BillingAddresscity.sendKeys("DemoCity");

        BillingAddressAddress.sendKeys("demoadr");

        BillingAddressZip.sendKeys("123456");
        BillingAddressphon.sendKeys("123456789");
        Thread.sleep(1000);
        ElementTestClick(BillingAddressButton, "BillingAddressButton");
    }

    // ohne neu register test
    public void BillingAddressPage() throws InterruptedException, ExceptionExistence {
        Thread.sleep(2000);

        ElementTestClick(BillingAddressButton,"BillingAddressButton");
    }

    public void ShippingAddressPage() throws InterruptedException, ExceptionExistence {
        Thread.sleep(2000);
        ElementTestClick(ShippingAddressButton,"ShippingAddressButton");
    }

    public void ShippingMethodPage() throws InterruptedException, ExceptionExistence {
        Thread.sleep(1000);
        ElementTestClick(ShippingMethodButton,"ShippingMethodButton");
    }

    public void PaymentMethodPage() throws InterruptedException, ExceptionExistence {
        Thread.sleep(1000);
        ElementTestClick(PaymentMethodButton,"PaymentMethodButton");
    }

    public void PaymentInformationPage() throws InterruptedException, ExceptionExistence {
        Thread.sleep(1000);
        PaymentInformation.isDisplayed();
        System.out.println(PaymentInformation.getText());

        ElementTestClick(PaymentInformationButton,"PaymentInformationButton");
    }

    public void ConfirmOrderPage() throws InterruptedException, ExceptionExistence {
        Thread.sleep(1000);
        ElementTestClick(ConfirmOrderButton,"ConfirmOrderButton");
    }

    public void successOrderPage() throws InterruptedException {

        Thread.sleep(2500);
        //successOrderText.isDisplayed();
        Assert.assertEquals(successOrderText.getText(),
                "Your order has been successfully processed!");
        Thread.sleep(2500);
    }

    public void OrderEndPage() throws InterruptedException, ExceptionExistence {

        ElementTestClick(OrderEnd,"OrderEnd");
        Thread.sleep(2000);
    }
}
