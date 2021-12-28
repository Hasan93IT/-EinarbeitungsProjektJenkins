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

//
public class ArtikelKaufenPage extends MainPage {
    public ArtikelKaufenPage(WebDriver driver) {
        super(driver);
    }

    private final String QuantityBook1 = LoadData.userData.getProperty("QuantityBook1");

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")
    WebElement openBooksMenu;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]")
    WebElement AddBook1ToCart;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")
    WebElement AddBook2ToCart;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[5]/input")
    WebElement Book1Doppelt;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]")
    WebElement UpdateCartClick;

    @FindBy(className = "content")
    WebElement AddBookToCartisDisplayed;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[1]/input")
    WebElement Book3Delete;

    //verschieben book1 in den Warenkorb
    public void AddBook1ToCartPage() throws InterruptedException, ExceptionExistence {

        ElementTestClick(openBooksMenu, "openBooksMenu");

        ElementTestClick(AddBook1ToCart, "AddBook1ToCart");

        Thread.sleep(1000);

        AddBookToCartisDisplayed.isDisplayed();
        Assert.assertEquals(AddBookToCartisDisplayed.getText(),
                "The product has been added to your shopping cart");
    }

    //verschieben book2 in den Warenkorb
    public void AddBooks2ToCartPage() throws InterruptedException {
        AddBookToCartisDisplayed.isDisplayed();
        AddBook2ToCart.click();
        Thread.sleep(1000);

        AddBookToCartisDisplayed.isDisplayed();
        Assert.assertEquals(AddBookToCartisDisplayed.getText(),
                "The product has been added to your shopping cart");
    }

    //book1 zweimal bestellen mit update des Warenkorbs
    public void UpdateCartPage() throws InterruptedException, ExceptionExistence, ExceptionInput {
        Thread.sleep(200);
        StringIsEmpty(QuantityBook1, "QuantityBook1");
        //System.out.println("moin");
        Book1Doppelt.clear();
        Book1Doppelt.sendKeys(QuantityBook1);
        Thread.sleep(200);
        /*if (Book3Delete.isEnabled() && Book3Delete.isDisplayed()) {
            Book3Delete.click();
        } else {
            throw new ExceptionExistence("Book Delete button");
        }*/
        ElementTestClick(Book3Delete, "Book Delete button");

        ElementTestClick(UpdateCartClick, "UpdateCart button");
    }
}
