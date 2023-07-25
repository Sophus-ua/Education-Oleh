package Lesson_7_Serialization_XML_JSON.Task_4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "building")
public class Building {
    private String name;

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "building name: " + name;
    }
}
