package HelfMethoden;

import org.openqa.selenium.WebElement;


public class ElementTest {
    // überprüfung eines WebElement "button", falls Enabled oder Displayed dann wird geklickt
    //sonst werft ExceptionExistence.
    public static void ElementTestClick(WebElement Element, String ElementName) throws ExceptionExistence {

        if (Element.isEnabled() && Element.isDisplayed()) {
            Element.click();
        } else {
            System.out.println("Fehler! '" + ElementName + "' ist  nicht Displayed oder nicht Enabled!");
            throw new ExceptionExistence();
        }
    }
    //werft Exception, falls ein String leer ist.
    public static void StringIsEmpty(String Input, String StringName) throws ExceptionInput {
        if (Input.isEmpty()) {
            System.out.println("Fehler! Bitte '" + StringName + "' in TestData Eingeben");
            throw new ExceptionInput();
        }
    }
}
