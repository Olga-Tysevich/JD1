package org.example.lesson19xml_json.points.parsers;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.example.lesson19xml_json.points.Constants.*;

public class StAXPointsParser {
    private XMLInputFactory factory;

    public StAXPointsParser() {
        this.factory = XMLInputFactory.newInstance();
    }

    public void printPoints(String filePath) {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);

            boolean isXCoordinate = false;
            boolean isYCoordinate = false;
            String xValue = null;
            String yValue = null;
            while (reader.hasNext()) {
                int res = reader.next();
                if (res == reader.START_ELEMENT) {
                    if (reader.getLocalName().equals(TAG_X)) {
                        isXCoordinate = true;
                    } else if (reader.getLocalName().equals(TAG_Y)) {
                        isYCoordinate = true;
                    }
                } else if (res == reader.CHARACTERS) {
                    if (isXCoordinate) {
                        xValue = reader.getText();
                        isXCoordinate = false;
                    } else if (isYCoordinate) {
                        yValue = reader.getText();
                        isYCoordinate = false;
                        System.out.println(xValue + UNIT + POINTS_SEPARATOR + yValue + UNIT);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
