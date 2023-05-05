package Auftrag4;

/* Arbeitsauftrag:  Lesen Sie nur die Buchtitel 
 *					aus der Datei "buchhandlung.xml" und geben Sie sie 
 * 					auf dem Bildschirm aus.
 * 
 *                  Ausgabe soll wie folgt formatiert werden:
 *                     1. titel: Everyday Italian
 *                     2. titel: Harry Potter
 *                     3. titel: XQuery Kick Start
 *                     4. titel: Learning XML
 *                     
 * Hinweis: Sie ben�tigen ein NodeList-Objekt und eine Schleife, die diese iteriert!
 */


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadBookstoreData4 {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("src/main/resources/buchhandlung4_5.xml");
			NodeList books = doc.getElementsByTagName("buch");

			for (int i = 0; i < books.getLength(); i++) {
				for (int j = 0; j < books.item(i).getChildNodes().getLength(); j++) {
					if (books.item(i).getChildNodes().item(j).getNodeName().equals("titel")) {
						System.out.println((i + 1) + ". " + books.item(i).getChildNodes().item(j).getNodeName() + ": " + books.item(i).getChildNodes().item(j).getTextContent());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
