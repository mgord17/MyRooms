package DB;

import Model.Account;
import Model.Room;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RoomsDB {

    private static final String account = MyDBInfo.MYSQL_USERNAME;
    private static final String password = MyDBInfo.MYSQL_PASSWORD;
    private static final String server = MyDBInfo.MYSQL_DATABASE_SERVER;
    private static final String database = MyDBInfo.MYSQL_DATABASE_NAME;
    private static RoomsDB dataB;

    private Connection ConnDB;
    private Statement stat;

    private RoomsDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnDB = DriverManager.getConnection("jdbc:mysql://" + server, account, password);
            stat = ConnDB.createStatement();
            stat.executeQuery("USE " + database);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static RoomsDB getInstance() {
        if (dataB == null) {
            synchronized (RoomsDB.class) {
                if (dataB == null) dataB = new RoomsDB();
            }
        }
        return dataB;
    }
    private int boolToInt(boolean b){
        if(b) return 1;
        return 0;
    }

    String sqlDate(java.util.Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int startYear = c.get(Calendar.YEAR) - 1900;
        int startMonth = c.get(Calendar.MONTH);
        int startDay = c.get(Calendar.DAY_OF_MONTH);
        String dt = startYear + "-" + startMonth + "-" + startDay;
        return dt;
    }

    public Integer addRoom(java.util.Date startDate, java.util.Date endDate, Integer pricePerDay,  String img, Integer accountId, Integer numberOfBeds,
                           boolean wifi, boolean tv, boolean hotWater) {
        try {
            String query = "insert into rooms(reserved_start, reserved_end, price_per_day, number_of_beds, account_id, img, wifi, tv, hot_water) " +
                    "values (";
            query += "\'" + sqlDate(startDate) + "\'";
            query += ", \'" + sqlDate(endDate) + "\'";
            query += ", \'" + pricePerDay + "\'";
            query += ", \'" + numberOfBeds + "\'";
            query += ", \'" + accountId + "\'";
            query += ", \'" + img + "\'";
            query += ", \'" + boolToInt(wifi) + "\'";
            query += ", \'" + boolToInt(tv) + "\'";
            query += ", \'" + boolToInt(hotWater) + "\');";

            stat.executeUpdate(query);
            PreparedStatement quer2 = ConnDB.prepareStatement("SELECT  max(room_id)  from rooms;");
            ResultSet res = quer2.executeQuery();
            res.next();
            int roomId = res.getInt("max(room_id)");
            return roomId;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean updateRoom (Integer room_id, java.util.Date startDate, java.util.Date endDate, Integer pricePerDay, String img, Integer accountId, Integer numberOfBeds, boolean wifi, boolean tv,
                               boolean hotWater) {
        try {
            Statement stmt = ConnDB.createStatement();
            String start_date_update = "reserved_start = " +  "\'" + sqlDate(startDate) +  "\'";
            String end_date_update = "reserved_end = " + "\'" + sqlDate(endDate) +  "\'";
            String price_per_day_update = "price_per_day = " + pricePerDay;
            String number_of_beds_update = "number_of_beds = " + numberOfBeds;
            String account_id_update = "account_id = " + accountId;
            String img_update = "img = " + "\'" + img + "\'";
            String wifi_update = "wifi = " + wifi;
            String tv_update = "tv = " + tv;
            String hot_water_update = "hot_water = " + hotWater;
            String where_clause = " where room_id = " + room_id + ";";
            String query = "update rooms set ";
            query += (start_date_update + ",");
            query += (end_date_update + ",");
            query += (price_per_day_update + ",");
            query += (number_of_beds_update + ",");
            query += (account_id_update + ",");
            query += (img_update  + ",");
            query += (wifi_update + ",");
            query += (tv_update + ",");
            query += hot_water_update;
            query += where_clause;
            stat.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteRoom(int roomId) {
        try {
            String query = "delete from rooms where room_id = ";
            query += roomId;
            query += ";";
            stat.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//    int id, Date sDate, java.util.Date eData, int pricePerDay, String img, int accountId,
//    int numberOfBeds, boolean wifi, boolean tv, boolean hotWater
    public ArrayList<Room> getRooms(){
        ArrayList<Room> allRooms = new ArrayList<Room>();
        try {

            if(stat == null) return allRooms;
            ResultSet rs = stat.executeQuery("select * from rooms;");

            while(rs != null && rs.next()){
                System.out.println();
                Room curRoom = new Room(rs.getInt("room_id"), rs.getDate("reserved_start"), rs.getDate("reserved_end"),
                        rs.getInt("price_per_day"), rs.getString("img"), rs.getInt("account_id"),
                        rs.getInt("number_of_beds"), rs.getBoolean("wifi"), rs.getBoolean("tv"), rs.getBoolean("hot_water"));
//                Room curRoom = new Room(1);
                allRooms.add(curRoom);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return allRooms;
        }
        return allRooms;
    }

    public Room getRoom(int id) {
        try {
            String query = "select * from rooms where room_id = ";
            query += id;
            query += ";";
            ResultSet rs = stat.executeQuery(query);

            if(!rs.next()) {
                return null;
            }
            return new Room(id, rs.getDate("reserved_start"), rs.getDate("reserved_end"),
                    rs.getInt("price_per_day"), rs.getString("img"),
                    rs.getInt("account_id"),rs.getInt("number_of_beds"),
                    rs.getBoolean("wifi"), rs.getBoolean("tv"), rs.getBoolean("hot_water"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
