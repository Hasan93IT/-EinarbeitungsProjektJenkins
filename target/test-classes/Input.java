package HelfMethoden;

import java.util.Scanner;

//Klasse für Eingabe einer integer Zahl mit überprufung der Eingabe
public class Input {
    int ZwVar;
    static String StVar;
    public int InputString(String Text) {
        try {
            System.out.println(Text);
            Scanner scan = new Scanner(System.in);
            ZwVar = scan.nextInt();
            scan.close();
            return ZwVar;
        } catch (Exception e) {
            System.out.println("Fehler bei Eingabe des AnzahlTest!");
            return -1;
        }
    }
    public static String InputString1(String Text) {
        try {
            System.out.println(Text);
            Scanner scan = new Scanner(System.in);
            StVar = scan.nextLine();
            scan.close();
            return StVar;
        } catch (Exception e) {
            System.out.println("Fehler bei Eingabe des AnzahlTest!");
            return null;
        }
    }
}
