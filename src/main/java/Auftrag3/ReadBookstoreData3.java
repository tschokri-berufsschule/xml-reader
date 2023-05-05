package Auftrag3;

 /* Arbeitsauftrag:  Lesen Sie alle Angaben des Buches "Java ist auch eine Insel" 
 *					 aus der Datei "buchhandlung.xml" und geben Sie sie auf dem Bildschirm aus.
 *
 *                   Ausgabe soll wie folgt aussehen:
 *                    titel:  Java ist auch eine Insel   
 *					  vorname:  Christian 
 *                    nachname:  Ullenboom 
 */

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadBookstoreData3 {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("src/main/resources/buchhandlung3.xml");
			Node root = doc.getDocumentElement();
			printChildNodeValues(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printChildNodeValues(Node node) {
		NodeList childNodes = node.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);

			if (childNode.getNodeType() == Node.ELEMENT_NODE) {
				String nodeName = childNode.getNodeName();
				String nodeValue = childNode.getTextContent().trim();

				if (!nodeValue.isEmpty() && childNode.getChildNodes().getLength() == 1 && childNode.getFirstChild().getNodeType() == Node.TEXT_NODE) {
					System.out.println(nodeName + ": " + nodeValue);
				}

				printChildNodeValues(childNode);
			}
		}
	}

}
