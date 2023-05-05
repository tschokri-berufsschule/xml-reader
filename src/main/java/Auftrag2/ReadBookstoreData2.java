package Auftrag2;

/* Arbeitsauftrag:  Lesen Sie den Titel und den Autor des Buches "Java ist auch eine Insel"
 *					 aus der Datei "buchhandlung.xml" und geben Sie sie auf dem Bildschirm aus.
 *
 *                   Ausgabe soll wie folgt aussehen:
 *                        titel:  Java ist auch eine Insel
 *                        autor:  Max Mustermann
 */


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadBookstoreData2 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/buchhandlung2.xml");
            Node parentNode = doc.getElementsByTagName("buch").item(0);
            NodeList childNodes = parentNode.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);

                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(child.getNodeName() + ": " + child.getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
