package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import javax.crypto.spec.DESedeKeySpec;
import java.util.List;
import java.util.Map;

/**
 * Created by Tiberiu.Danciu on 7/14/2017.
 */
public class DepartmentDao {
    EntityManagerImpl entityManager = new EntityManagerImpl();
    Department dept = new Department();

    public Department depFindById(Long id){
            dept = entityManager.findById(Department.class, id);
            return dept;
    }

    public List<Department> depFindAll(){
        return entityManager.findAll(Department.class);
    }

    public Department depUpdate(Department entity){
        return entityManager.update(entity);
    }

    public void depDelete(Department entity){
        entityManager.delete(entity);
    }

    public List<Department> depFindByParams(Map<String, Object> params){
        return entityManager.findByParams(Department.class, params);
    }
}
