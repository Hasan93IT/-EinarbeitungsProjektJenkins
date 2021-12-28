package Testcase;


import HelfMethoden.ExceptionExistence;
import HelfMethoden.ExceptionInput;
import HelfMethoden.TestNGListener;
import Pages.ArtikelKaufenPage;
import Pages.VerifyPreisPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//testen des Kaufs von 2 Büchern
@Listeners(TestNGListener.class)
public class ArtikelKaufenTest extends TestBase {

    ArtikelKaufenPage Books;
  //LoginPage Login;
    VerifyPreisPage Preise;


    /*@BeforeTest
    public void Logintest() {
        Login = new LoginPage(driver);
        Login.login();
    }*/

    @Test(priority = 1)
    public void AddBook1ToCartTest() throws InterruptedException, ExceptionExistence {
        Books = new ArtikelKaufenPage(driver);
        Books.AddBook1ToCartPage();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void AddBook2ToCartTest() throws InterruptedException {
        Books.AddBooks2ToCartPage();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void ShoppingCardClickTest() throws InterruptedException, ExceptionExistence {
        Preise = new VerifyPreisPage(driver);
        Preise.ShoppingCardClickPage();
        Thread.sleep(2000);
      //  Preise.VerifyTolalPreisBook2(10);
    }

    @Test(priority = 4)
    public void PreisBook1() throws InterruptedException, ExceptionInput {
        Thread.sleep(200);
        Preise.VerifyTolalPreisBook1();
    }


    @Test(priority = 5)
    public void PreisBook2() throws InterruptedException {
        Thread.sleep(200);
        Preise.VerifyTolalPreisBook2(24);
    }

    @Test(priority = 6)
    public void UpdateCartTest() throws InterruptedException, ExceptionExistence, ExceptionInput {
        Thread.sleep(2000);
        Books.UpdateCartPage();
    }
}
