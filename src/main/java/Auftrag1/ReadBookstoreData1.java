package Auftrag1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadBookstoreData1 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/buchhandlung1.xml");
            Node root = doc.getDocumentElement();
            printNode(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printNode(Node node) {
        String nodeName = node.getNodeName();
        String nodeValue = node.getNodeValue();

        System.out.println(nodeName);
        if (nodeValue != null && !nodeValue.trim().isEmpty()) {
            System.out.println("Value: " + nodeValue);
        }
    }

}
