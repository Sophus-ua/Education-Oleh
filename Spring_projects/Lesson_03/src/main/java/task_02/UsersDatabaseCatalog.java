package task_02;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;



@XmlRootElement(name = "catalog_of_users")
public class UsersDatabaseCatalog {
    @XmlElement(name = "user")
    private List<UserInformation> users;

    public UsersDatabaseCatalog(){
        users = new ArrayList<>();
    }
    public void add(UserInformation userInformation){
        users.add(userInformation);
    }
    public List<UserInformation> getUsers(){
        return users;
    }
}
