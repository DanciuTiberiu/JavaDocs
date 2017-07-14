package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tiberiu.Danciu on 7/14/2017.
 */
public class LocationDaoTest {
    @Test
    public void locFinByIdTest(){
        LocationDao loc = new LocationDao();
        Location lc = new Location();
        lc = loc.locFindById(1000L);

        assertEquals((Object) lc.getId(), 1000L);
        assertEquals((Object) lc.getCity(), "Roma");
        assertEquals((Object) lc.getPostalCode(), "00989");
        assertEquals((Object) lc.getStateProvince(), null);
    }

    @Test
    public void locFindAllTest(){
        LocationDao dao = new LocationDao();
        List<Location> list = dao.locFindAll();

        assertEquals((int) list.size(), 23);
    }

    @Test
    public void locUpdateTest(){
        LocationDao dao = new LocationDao();
        Location loc = new Location();
        loc.setId(3200L);
        loc.setCity("Bratislava");
        loc.setPostalCode("102392");
        loc.setStateProvince("Bratislava");
        loc.setStreetAddress("Str. Enescu E, Nr. 22");
        Location lc = dao.locUpdate(loc);

        assertEquals(lc.getId(), 3200L);
        assertEquals(lc.getCity(), "Bratislava");
        assertEquals(lc.getPostalCode(), "102392");
        assertEquals(lc.getStateProvince(), "Bratislava");
        assertEquals(lc.getStreetAddress(), "Str. Enescu E, Nr. 22");

    }

    @Test
    public void locDeleteTest(){
        LocationDao dao = new LocationDao();
        Location loc = new Location();
        loc.setId(2900L);
        dao.locDelete(loc);
    }

    @Test
    public void locFindByParams(){
        LocationDao dao = new LocationDao();
        Map<String , Object> map = new HashMap<>();
        map.put("Location_id", "1000");
        map.put("City", "Roma");
        List<Location> list = dao.locFindByParams(map);

        assertEquals(list.size(), 1);

    }
}
