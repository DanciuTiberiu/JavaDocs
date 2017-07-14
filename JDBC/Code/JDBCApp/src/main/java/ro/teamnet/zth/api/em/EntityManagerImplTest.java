package ro.teamnet.zth.api.em;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void getNextIdVal(){
        EntityManager manager = new EntityManagerImpl();
        Long l = manager.getNextIdVal("departments", "department_id");
        assertEquals((Long) l, 261);
    }

    @Test
    public void insertTest(){
        EntityManager manager = new EntityManagerImpl();
        Department dept = new Department();
        dept.setDepartmentName("Hacker");
        dept.setLocation(2400L);
        Department dp = (Department) manager.insert(dept);

        assertEquals((Object) dp.getId(), 268L );
        assertEquals((Object) dp.getLocation(), 2400L);
        assertEquals((Object) dp.getDepartmentName(), "Hacker");
    }

    @Test
    public void findAllTest(){
        EntityManagerImpl manager = new EntityManagerImpl();
        List<Department> list = manager.findAll(Department.class);

        assertEquals((int) list.size(), 35L);
    }

    @Test
    public void updateTest(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department dept = new Department();
        dept.setId(20L);
        dept.setLocation(1800L);
        dept.setDepartmentName("Marketing25");
        Department dp = entityManager.update(dept);

        assertEquals((Object) dp.getId(), 20L);
        assertEquals((Object) dp.getDepartmentName() , "Marketing25");
        assertEquals((Object) dp.getLocation(), 1800L);
    }

    @Test
    public void deleteTest(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department dept = new Department();
        dept.setId(270L);
        dept.setLocation(1700L);
        dept.setDepartmentName("Payroll");
        entityManager.delete(dept);

    }

    @Test
    public void findByParamsTest(){
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Map<String, Object> map = new HashMap<String , Object>();
        map.put("department_id", 120L);
        map.put("department_name", "Treasury");
        List<Department> list = entityManager.findByParams(Department.class, map);
        assertEquals((int) list.size(), 1);
    }



}
