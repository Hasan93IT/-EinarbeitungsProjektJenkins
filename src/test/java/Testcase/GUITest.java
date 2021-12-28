package Testcase;


import HelfMethoden.OpenFile;
import org.testng.TestNG;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GUITest extends JFrame implements ActionListener {

     OpenFile File;
     JLabel Titel;
     JButton EXIT;
     JButton Eingabe;
     JButton DatenOpen;
     JButton ReportOpen;
     JButton ScreenshotOpen;
     String[] TestCases = {"RegisterTest", "LoginTest", "ArtikelKaufenTest","CheckoutTest", "GesamteTest" };
     JComboBox<String> CompoBoxOfTestCases;
    JTextArea tfName = new JTextArea();
//https://www.youtube.com/watch?v=cXtm9aMmyhU&ab_channel=HarshGGupta
    public void MainGUI1() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Titel = new JLabel("Bitte wählen Sie TestCase aus:");

        Eingabe = new JButton("OK");
        Eingabe.addActionListener(this);
        EXIT = new JButton("EXIT");
        EXIT.addActionListener(this);
        Eingabe.setToolTipText("Eingabe bestätigen");
        DatenOpen = new JButton("Daten Open");
        DatenOpen.addActionListener(this);
        ReportOpen = new JButton("Report Open");
        ReportOpen.addActionListener(this);
        ScreenshotOpen = new JButton("Screenshot Open");
        ScreenshotOpen.addActionListener(this);

        CompoBoxOfTestCases = new JComboBox<String>(TestCases);
        CompoBoxOfTestCases.addActionListener(this);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        // Layout-Style defined: 2 columns, 10p distance
        setLayout(new GridLayout(4, 2, 5, 5));
       // setMinimumSize(new Dimension(400, 150));


        add(Titel);
         add(CompoBoxOfTestCases);
       //
         add(DatenOpen);
        add(ReportOpen);
        add(ScreenshotOpen);
        add(new JLabel(""));
        add(Eingabe);
        add(EXIT);
      //  add(tfName);
      //  add(tfName);
        setTitle("Register Test");
       // setResizable(false);
        pack(); // organise all the elements
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        TestNG Obj = new TestNG();
        File = new OpenFile();
        String TestLoction = System.getProperty("user.dir");
        List<String> suites = new ArrayList<String>();
        String IndexTest = (String) CompoBoxOfTestCases.getSelectedItem();
      //  tfName.setText("jjjjjjjjjjj");
        if (e.getSource() == Eingabe) {

            switch (IndexTest) {
                case "ArtikelKaufenTest":
                    suites.add(TestLoction + "\\XMLFile\\ArtikelKaufenTest.xml");
                    break;
                case "LoginTest":
                    suites.add(TestLoction + "\\XMLFile\\LoginTest.xml");
                    System.out.println(IndexTest);
                    break;
                case "RegisterTest":
                    suites.add(TestLoction + "\\XMLFile\\RegisterTest.xml");
                    System.out.println(IndexTest);
                    break;
                case "GesamteTest":
                    suites.add(TestLoction + "\\XMLFile\\GesamteTest.xml");
                    System.out.println(IndexTest);
                    break;
                case "CheckoutTest":
                    suites.add(TestLoction + "\\XMLFile\\CheckoutTest.xml");
                    System.out.println(IndexTest);
                    break;
                default:
                    System.out.println("Fehler in Tast Casees Menu");
            }
            Obj.setTestSuites(suites);
            Obj.run();
         //   System.out.println(IndexTest);
        }
        if (e.getSource() == ReportOpen) {
            File.OpenTestReport();
        }
        if (e.getSource() == ScreenshotOpen) {
            File.OpenScreenshot();
        }
        if (e.getSource() == DatenOpen) {
            File.OpenTestDate();
        }
        if (e.getSource() == EXIT) {
            System.exit(0);
        }

    }

    //https://www.youtube.com/watch?v=hS-O2tWm_jM&ab_channel=RajTech-Trainer

    public static void main(String[] args) {

        GUITest UI = new GUITest();
        UI.MainGUI1();

    }

}
