package org.example.lesson19xml_json.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.example.lesson19xml_json.Constants.*;

public class DOMPointsParser {
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private File file;
    private Document document;

    public DOMPointsParser(String filePath) {
        this.file = new File(filePath);
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void printPoints() {
        NodeList nodeList = document.getElementsByTagName(TAG_NAME);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            NodeList points = node.getChildNodes();

            String xValue = null;
            String yValue = null;
            for (int j = 0; j < points.getLength(); j++) {
                if (points.item(j) instanceof Element) {
                    xValue = points.item(j).getNodeName().equals(TAG_X) ? points.item(j).getFirstChild().getNodeValue() : xValue;
                    yValue = points.item(j).getNodeName().equals(TAG_Y) ? points.item(j).getFirstChild().getNodeValue() : yValue;
                }
            }
            System.out.println(xValue + UNIT + POINTS_SEPARATOR + yValue + UNIT);
        }
    }
}
