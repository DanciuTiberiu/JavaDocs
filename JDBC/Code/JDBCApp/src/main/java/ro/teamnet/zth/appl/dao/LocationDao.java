package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by Tiberiu.Danciu on 7/14/2017.
 */
public class LocationDao {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        Location loc = new Location();

        public Location locFindById(Long id){
            loc = entityManager.findById(Location.class, id);
            return loc;
        }

        public List<Location> locFindAll(){
            return entityManager.findAll(Location.class);
        }

        public Location locUpdate(Location entity){
            return entityManager.update(entity);
        }

        public void locDelete(Location entity){
            entityManager.delete(entity);
        }

        public List<Location> locFindByParams(Map<String, Object> params){
            return entityManager.findByParams(Location.class, params);
        }
}
