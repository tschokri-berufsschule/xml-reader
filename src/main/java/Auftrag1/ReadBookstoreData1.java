package Auftrag1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadBookstoreData1 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/buchhandlung1.xml");
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
