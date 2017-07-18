package ro.teamnet.zth.web;

/**
 * Created by Tiberiu.Danciu on 7/18/2017.
 */
public class Person {

    public String getFirstName() {
        return firstName;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    String firstName = "";
    String lastName = "";
    Long age = 0l;
    Boolean married =false;

    public Person(String firstName, String lastName, Long age, Boolean married) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
        this.married = married;
    }

    @Override
    public String toString(){
        return this.firstName + " , " + this.lastName + " , " + this.getAge() + " , " + this.married;
    }


}
