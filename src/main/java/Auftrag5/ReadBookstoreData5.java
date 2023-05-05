package Auftrag5;

/* Arbeitsauftrag:  Lesen Sie nur die Autoren des Buches "XQuery Kick Start" aus der Datei
 *                  "buchhandlung.xml" und geben Sie sie auf dem Bildschirm aus.
 *
 *                   Ausgabe soll wie folgt aussehen:
 *                     Buchtitel:  XQuery Kick Start
 *                     Autoren:
 *                     	    1. autor: James McGovern
 *                          2. autor: Per Bothner
 *                          3. autor: Kurt Cagle
 *                          4. autor: James Linn
 *                          5. autor: Vaidyanathan Nagarajan
 *
 * Hinweis: Sie ben�tigen ein NodeList-Objekt und eine Schleife, die diese iteriert!
 */


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadBookstoreData5 {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/buchhandlung4_5.xml");
            NodeList buchList = doc.getElementsByTagName("buch");
            for (int i = 0; i < buchList.getLength(); i++) {
                Element buchElement = (Element) buchList.item(i);
                Element titelElement = (Element) buchElement.getElementsByTagName("titel").item(0);
                String titel = titelElement.getTextContent();

                if (titel.equals("XQuery Kick Start")) {
                    NodeList autorList = buchElement.getElementsByTagName("autor");
                    for (int j = 0; j < autorList.getLength(); j++) {
                        Element autorElement = (Element) autorList.item(j);

                        String autor = autorElement.getTextContent();
                        System.out.println((j + 1) + ". autor: " + autor);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
