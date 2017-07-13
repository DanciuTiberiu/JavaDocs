package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Tiberiu.Danciu on 7/13/2017.
 */
public class DBManager implements DBProperties {
    private DBManager(){
        throw new UnsupportedOperationException();
    }

    static String  CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private static void  registerDriver(){
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        Connection connect = null;
        try {
            DriverManager.registerDriver(myDriver);
            connect = DriverManager.getConnection(CONNECTION_STRING, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }

    public static boolean checkConnection(Connection connection){
            boolean retur = false;
        try {
            String query = "SELECT 1 FROM DUAL";
            Statement stm = connection.createStatement();
            retur = stm.execute(query);
            System.out.println("Return value is :" + retur);

            int rows = stm.executeUpdate(query);
            System.out.println("Number of rows modified is : " + rows);

            return retur;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retur;
    }
}
