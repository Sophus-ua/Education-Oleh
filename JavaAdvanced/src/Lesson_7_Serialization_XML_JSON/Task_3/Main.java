package Lesson_7_Serialization_XML_JSON.Task_3;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends CityStAXparser{

    private Street[] fillingStreets(){
        String[] buildingsOnStreet1 = {"TSUM","Ukrposhta 01001","hotel 'Khreschatyk'"};
        Street street1 = new CityStAXparser.Street("Khreshchatyk", buildingsOnStreet1);

        String[] buildingsOnStreet2 = {"st Andrew's Church","Theater on Podol"};
        Street street2 = new CityStAXparser.Street("Andriivskyi Descent", buildingsOnStreet2);

        return new Street[] {street1,street2};
    }

    public static void main(String[] args) {
        Main mainWork = new Main();
        Path xmlFile = Paths.get("O:/JavaC/IDEA Projects/JavaAdvanced/src/Lesson_7_Serialization_XML_JSON/Task_4/exampleFile.xml");

        Street[] streets = mainWork.fillingStreets();
        mainWork.staxParsing(xmlFile,"Kyiv", streets);

        SAXparser.saxParsing(xmlFile);
    }
}
