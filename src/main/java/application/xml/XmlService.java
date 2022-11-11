package application.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlService {

    Document xmlDoc;

    public XmlService() {

        try {
            xmlDoc = getXmlDoc();
            xmlDoc.setXmlStandalone( true );
        } catch ( ParserConfigurationException | SAXException | IOException e ) {
            throw new RuntimeException( e );
        }

    }

    public void createModifiedItemXmlFile( int modifier ) throws IOException, TransformerException {

        modifyXmlFile( modifier );

        try ( FileOutputStream output =
                      new FileOutputStream( "C:\\Users\\janwa\\OneDrive\\Laptop Sicherung\\DayZServer\\types_modified.xml" ) ) {

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty( OutputKeys.STANDALONE, "yes");

            DOMSource domSource = new DOMSource( xmlDoc );

            StreamResult streamResult = new StreamResult( output );

            transformer.transform( domSource, streamResult );


        }
    }

    private void modifyXmlFile( int modifier ) {

        NodeList nominalValues = xmlDoc.getElementsByTagName( "nominal" );

        NodeList minValues = xmlDoc.getElementsByTagName( "min" );

        setNodeValues(nominalValues, modifier);

        setNodeValues( minValues, modifier );
    }

    private Document getXmlDoc() throws ParserConfigurationException, SAXException, IOException {
        String filePath = "C:\\Users\\janwa\\OneDrive\\Laptop Sicherung\\DayZServer\\types_original.xml";

        File xmlFile = new File( filePath );

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();

        return documentBuilder.parse( xmlFile );
    }

    private void setNodeValues( NodeList nodes, int multiplier ) {

        int changedItemsCounter = 0;

        for ( int i = 0; i < nodes.getLength(); i++ ) {

            changedItemsCounter++;

            Node nodeValue = nodes.item( i );


            if ( !nodeValue.getTextContent().equals( "0" ) ) {

                int newValue = Integer.parseInt( nodeValue.getTextContent() ) * multiplier;

                nodeValue.setTextContent( String.valueOf( newValue ) );


            }

        }

    }

}
