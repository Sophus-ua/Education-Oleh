package Lesson_7_Serialization_XML_JSON.Task_4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@XmlRootElement(name = "street")
@XmlType(propOrder = {"name","buildings"})
class Street {
    private String name;
    @XmlElement(name = "building")
    private List<Building> buildings = new ArrayList<>();


    public void add(Building building) {
        buildings.add(building);
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "street name: " + name + "list of buildings: " + Arrays.deepToString(buildings.toArray());
    }
}
