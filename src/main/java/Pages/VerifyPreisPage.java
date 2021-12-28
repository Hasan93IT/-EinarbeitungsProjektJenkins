package Pages;

import HelfMethoden.ExceptionExistence;
import HelfMethoden.ExceptionInput;
import HelfMethoden.LoadData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static HelfMethoden.ElementTest.ElementTestClick;
import static HelfMethoden.ElementTest.StringIsEmpty;

// hier werden die Preise mit den gegebeben Preisen überpruft
public class VerifyPreisPage extends MainPage {
    public VerifyPreisPage(WebDriver driver) {
        super(driver);
    }

    float[][] Price = new float[2][4];
    /*
    * _____|Price| Qty |Total |gegeben preis
    * book1| 00  | 01  |02    |03
    * book2| 10  | 11  |12    |13
    * */
    //book1
    @FindBy(className = "product-unit-price")
    WebElement OneBook1Price;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[5]/input")
    WebElement QtyBook1Price;

    @FindBy(className = "product-subtotal")
    WebElement TotalBook1Price;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[4]/span[2]")
    WebElement OneBook2Price;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[5]/input")
    WebElement QtyBook2Price;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[6]/span[2]")
    WebElement TotalBook2Price;

    @FindBy(linkText = "Shopping cart")
    WebElement ShoppingCard ;

    public void ShoppingCardClickPage() throws ExceptionExistence {
        ElementTestClick(ShoppingCard,"ShoppingCard");
    }

    //überprufung des Preises des ersten Buchs
    public void VerifyTolalPreisBook1() throws ExceptionInput {
        StringIsEmpty(LoadData.userData.getProperty("PriceBook1"),"PriceBook1");
        // hier sind die Werte in array gespeichert
        Price[0][0]=Float.parseFloat(OneBook1Price.getText());
        Price[0][1]=Float.parseFloat(QtyBook1Price.getAttribute("value"));
        Price[0][2]=Float.parseFloat(TotalBook1Price.getText());
        Price[0][3]=Float.parseFloat(LoadData.userData.getProperty("PriceBook1"));

        TotalBook1Price.isDisplayed();
        QtyBook1Price.isDisplayed();
        OneBook1Price.isDisplayed();

        Assert.assertEquals(Float.parseFloat(OneBook1Price.getText()),Price[0][3]
                ,"Preis Book1 ist nicht wie erwartet");

         System.out.println("One Book1 Price from APP: " + Price[0][0] + ", " +
                " Qty Book1 Price: " +  Price[0][1] + ", " +
                "  Total Book1 Price:  " +Price[0][2] );
      //  Thread.sleep(500);
    }
    //überprufung des Preises des zweiten Buchs
    //was ist lieber wie hier oder wie in VerifyTolalPreisBook1
    public void VerifyTolalPreisBook2(float GegebnePriesBook2)  {
        //Thread.sleep(1000);
        TotalBook2Price.isDisplayed();
        QtyBook2Price.isDisplayed();
        OneBook2Price.isDisplayed();

        Assert.assertEquals(Float.parseFloat(OneBook2Price.getText()),GegebnePriesBook2
                ,"Preis Book2 ist nicht wie erwartet");

        System.out.println("One Book2 Price from APP: " + OneBook2Price.getText() + ", " +
                " Qty Book2 Price: " + QtyBook2Price.getAttribute("value") + ", " +
                "  Total Book2 Price:  " + TotalBook2Price.getText());
    }
}
