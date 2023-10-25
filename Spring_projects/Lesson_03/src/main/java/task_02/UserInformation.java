package task_02;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserInformation {
    private String userName;
    private String userPassword;

    public UserInformation(){}
    public UserInformation(String name, String password){
        this.userName = name;
        this.userPassword = password;
    }


    @XmlElement(name = "name")
    public void setUserName(String name){
        this.userName = name;
    }

    public String getUserName(){
        return userName;
    }

    @XmlElement (name = "password")
    public void setUserPassword(String password){
        this.userPassword = password;
    }

    public String getUserPassword(){
        return userPassword;
    }

    @Override
    public String toString(){
        return userName + " " + userPassword;
    }
}
