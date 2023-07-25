package Lesson_7_Serialization_XML_JSON.Task_4;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement (name = "city")
class City {

    @XmlAttribute
    private String size;

    private String name;

    @XmlElementWrapper(name = "streets")
    @XmlElement(name = "street")
    private List<Street> streets = new ArrayList<>();

    @XmlElement
    public void add (Street street) {
        streets.add(street);
    }
    public String getSize() {
        return size;
    }
    @XmlElement
    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return size + "city " + name + "list of streets: " + Arrays.deepToString(streets.toArray());
    }
}
