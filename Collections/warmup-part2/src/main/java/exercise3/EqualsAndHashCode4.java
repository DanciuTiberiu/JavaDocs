package exercise3;

/**
 * Created by Tiberiu.Danciu on 7/7/2017.
 */
public class EqualsAndHashCode4 extends StudentProperties {

    public EqualsAndHashCode4(String a, String b){
        super(a,b);
    }

    @Override
    public int hashCode() {
        int result = 31 * this.getFirstName().hashCode();
        result = 31 * result + this.getLastName().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (o == null)
            return false;

        StudentProperties student = (StudentProperties) o;

        if (student.getFirstName() != this.getFirstName() && student.getLastName() != this.getLastName())
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Student First name: " + this.getFirstName() + " Last name: " + this.getLastName();
    }
}
