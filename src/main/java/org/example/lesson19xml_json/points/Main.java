package org.example.lesson19xml_json.points;

import org.example.lesson19xml_json.points.parsers.DOMPointsParser;
import org.example.lesson19xml_json.points.parsers.StAXPointsParser;

import static org.example.lesson19xml_json.points.Constants.FIE_PATH;

public class Main {
    public static void main(String[] args) {
        /*Напишите программу, которая будет разбирать xml файл:
        * <pointLis>
            <point>
               <x>2</x>
               <y>3</y>
            </point>
            <point>
               <x>9</x>
               <y>3</y>
            </point>
          <pointLis>
          и выводить на экран в текстовом виде. Каждая точка должна выводится на отдельной строке в виде двух чисел,
          разделенных запятой, при этом должна выводится единица измерения. Например: 10px, 30px*/
        DOMPointsParser parser1 = new DOMPointsParser(FIE_PATH);
        parser1.printPoints();
        System.out.println("\n");

        /*Напишите программу, которая будет разбирать xml файл, сделаный в предыдущем задании с помощью StAX*/
        StAXPointsParser parser2 = new StAXPointsParser();
        parser2.printPoints(FIE_PATH);
    }
}
