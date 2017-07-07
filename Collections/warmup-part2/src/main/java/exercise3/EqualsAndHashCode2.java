package exercise3;

/**
 * Created by Tiberiu.Danciu on 7/7/2017.
 */
public class EqualsAndHashCode2 extends StudentProperties{

        public EqualsAndHashCode2(String a, String b){
            super(a,b);
        }


        @Override
    public int hashCode() {
        int result = this.getFirstName().hashCode();
        result = 31 * result;
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
