package exercise3;

/**
 * Created by Tiberiu.Danciu on 7/7/2017.
 */
public class StudentProperties {

    private String firstName, lastName;

    public StudentProperties(){

    }

    public StudentProperties(String a, String b) {
        firstName = a;
        lastName = b;
    }

    public  String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
