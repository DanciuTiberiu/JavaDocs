package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;


import static org.junit.Assert.assertFalse;

/**
 * Created by Tiberiu.Danciu on 7/13/2017.
 */
public class DBManagerTest {
    @Test
    public void getConnectionTest(){
        Connection con = null;
        con = DBManager.getConnection();
        assertFalse(con == null);
    }

    @Test
    public void checkConnectionTest(){
        boolean a = DBManager.checkConnection(DBManager.getConnection());
        assertFalse(a == false);
    }
}
