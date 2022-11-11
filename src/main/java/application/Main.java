package application;

import application.gui.mainWindow.MainFrame;
import application.xml.XmlService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main( String[] args ) {

        // bla

        Scanner scn = new Scanner( System.in );

        System.out.println( "Enter the multiplier for the items:" );

        int multiplier = scn.nextInt();

        try {
            new XmlService().createModifiedItemXmlFile( multiplier );
        } catch ( IOException | TransformerException e ) {
            throw new RuntimeException( e );
        }

        System.out.println( "The file was created successfully!" );

    }





}
