package exercise3;

/**
 * Created by Tiberiu.Danciu on 7/7/2017.
 */
public class EqualsAndHashCode3 extends StudentProperties {

    public EqualsAndHashCode3(String a, String b){
        super(a,b);
    }

    @Override
    public boolean equals(Object o) {

        StudentProperties student = (StudentProperties) o;

        if (student.getFirstName() != this.getFirstName())
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * this.getFirstName().hashCode();
        result = 31 * result + this.getLastName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student First name: " + this.getFirstName() + " Last name: " + this.getLastName();
    }
}
