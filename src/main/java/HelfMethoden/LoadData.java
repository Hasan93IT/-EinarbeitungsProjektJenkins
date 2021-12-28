package HelfMethoden;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



//für laden der Daten bzw. Werte von "TestData.properties"
public class LoadData {
    //speicherort von "TestData.properties"
    public static Properties userData = loadProperties(System.getProperty("user.dir")+
            "\\src\\main\\java\\HelfMethoden\\TestData.properties");

    private static Properties loadProperties(String path) {
        Properties pro = new Properties();
        FileInputStream stream;

        try {
            stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pro ;
    }


/*
    private static void WriteProperties(String path,String Value)  {
        //TODO
        Properties pro = new Properties();
        FileOutputStream stream;
        //String s="Hasan";
         try {
            stream = new FileOutputStream(path);
            pro.setProperty(path,Value);
           //  pro.
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }*/
}
