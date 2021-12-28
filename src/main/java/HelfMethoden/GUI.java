package HelfMethoden;


import org.testng.*;
import org.testng.xml.XmlTest;

import javax.swing.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

//TODO
public class GUI {
    //anzeigen von warnung Fenster
    private static String Test;

    public static String getTest() {
        return Test;
    }

    public static void setTest(String test) {
        Test = test;
    }



        public void DialogTest(String Text) {
            String backupDir = "Test";
            //create a jframe
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            //show a joptionpane dialog using showMessageDialog
            JOptionPane.showMessageDialog(frame, Text);
        }



}
