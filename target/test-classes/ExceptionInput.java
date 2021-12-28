package HelfMethoden;

//werfen Exception für überprüfung eines String, falls leer ist.
public class ExceptionInput extends Throwable {

  public  ExceptionInput(String Eingabe) {
      System.out.println("Fehler! Bitte "+Eingabe+" in TestData Eingeben");
    }
    public  ExceptionInput() {
    }

}
