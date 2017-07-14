package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tiberiu.Danciu on 7/14/2017.
 */
public class DepartmentDaoTest {
    @Test
    public void depFinByIdTest(){
        DepartmentDao dept = new DepartmentDao();
        Department dp = new Department();
        dp = dept.depFindById(40L);

        assertEquals((Object) dp.getId(), 40L);
        assertEquals((Object) dp.getDepartmentName(), "Human Resources");
        assertEquals((Object) dp.getLocation(), 2400L);
    }

    @Test
    public void depFindAllTest(){
        DepartmentDao dao = new DepartmentDao();
        List<Department> list = dao.depFindAll();

        assertEquals((int) list.size(), 35);
    }

    @Test
    public void depUpdateTest(){
        DepartmentDao dao = new DepartmentDao();
        Department dept = new Department();
        dept.setId(268L);
        dept.setDepartmentName("Actor");
        dept.setLocation(1700L);
        Department dp = dao.depUpdate(dept);

        assertEquals(dp.getId(), 268);
        assertEquals(dp.getDepartmentName(), "Actor");
        assertEquals(dp.getLocation(), 1700L);

    }

    @Test
    public void depDeleteTest(){
        DepartmentDao dao = new DepartmentDao();
        Department dept = new Department();
        dept.setId(266L);
        dept.setDepartmentName("Hacker");
        dept.setLocation(2400L);
        dao.depDelete(dept);
    }

    @Test
    public void depFindByParams(){
        DepartmentDao dao = new DepartmentDao();
        Map<String , Object> map = new HashMap<>();
        map.put("department_id", "261");
        map.put("department_name", "Hacker");
        List<Department> list = dao.depFindByParams(map);

        assertEquals(list.size(), 1);

    }
}
