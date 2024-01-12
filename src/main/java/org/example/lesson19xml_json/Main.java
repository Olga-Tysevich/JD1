package org.example.lesson19xml_json;

import org.example.lesson19xml_json.dom.DOMPointsParser;

import static org.example.lesson19xml_json.Constants.FIE_PATH;

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
        DOMPointsParser DOMPointsParser =new DOMPointsParser(FIE_PATH);
        DOMPointsParser.printPoint();
    }
}
