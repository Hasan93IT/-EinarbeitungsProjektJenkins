package HelfMethoden;

import java.awt.*;
import java.io.File;

//klasse für öffnen eines Ordner bzw. Datei
public class OpenFile {
    String FileLoction = System.getProperty("user.dir");

    // öffnen html Test Report
    public void OpenTestReport() {
        try {
            //constructor of file class having file as argument
            File file = new File(FileLoction + "\\test-output\\html\\index.html");
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())         //checks file exists or not
                desktop.open(file);    //opens the specified file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // öffnen der Test StartWerte, die in "TestData.properties" geschrieben sind.
    public void OpenTestDate() {
        try {
            //constructor of file class having file as argument
            File file = new File(FileLoction + "\\src\\main\\java\\HelfMethoden\\TestData.properties");
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())         //checks file exists or not
                desktop.open(file);    //opens the specified file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // öffnung des Orders Screenshot
    public void OpenScreenshot() {
        try {
            //constructor of file class having file as argument
            File file = new File(FileLoction + "\\Screenshots");
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())         //checks file exists or not
                desktop.open(file);    //opens the specified file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

