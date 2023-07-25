import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "street")
@XmlType(propOrder = {"name","buildings"})
class Street {
    private String name;
    @XmlElement(name = "building")
    private List<String> buildings = new ArrayList<>();


    public void add(String building) {
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
