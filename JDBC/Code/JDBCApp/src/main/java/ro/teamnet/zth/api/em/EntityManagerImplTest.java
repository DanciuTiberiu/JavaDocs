package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tiberiu.Danciu on 7/13/2017.
 */
public class EntityManagerImplTest {
    @Test
    public void findByIdTest(){
        EntityManagerImpl obj = new EntityManagerImpl();
        Department dept = obj.findById(Department.class, 60L );
        assertEquals((Object) dept.getId(), 60L);
        assertEquals((Object) dept.getDepartmentName(), "IT");
        assertEquals((Object) dept.getLocation(), 1400L);
    }


}
