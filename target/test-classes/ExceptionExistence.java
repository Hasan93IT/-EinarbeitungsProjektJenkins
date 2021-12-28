package HelfMethoden;


//werfen Exception für überprüfung eines WebElement "Displayed" oder "Enabled"
public class ExceptionExistence extends Throwable{


    public ExceptionExistence(String ElementName){
        System.out.println("Fehler! "+ElementName+" entweder nicht Displayed oder nicht Enabled");
    }

    public ExceptionExistence(){
        System.out.println("Existence Fehler!");
    }


}
