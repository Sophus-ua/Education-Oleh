package Lesson_7_Serialization_XML_JSON.Task_3;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class UserHandler extends DefaultHandler {
    boolean city = false;
    boolean street = false;
    boolean building = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("city")) city = true;
        if (qName.equalsIgnoreCase("street")) street = true;
        if (qName.equalsIgnoreCase("building")) building = true;
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        if (city) {
            System.out.println("Місто \033[1;33m" + new String(ch, start, length) + "\033[0m в якому є такі вулиці:");
            city = false;
        }
        if (street) {
            System.out.println("\tвулиця \033[1;36m" + new String(ch, start, length) + "\033[0m на якій є такі будівлі:");
            street = false;
        }
        if (building) {
            System.out.println("\t\t\033[0;34m" + new String(ch, start, length) + "\033[0m");
            building = false;
        }
    }
}
