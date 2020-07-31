import DB.RoomsDB;
import Manager.AccountManager;
import Manager.RoomManager;
import Model.Room;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        AccountManager mng = AccountManager.getInstance();
//        mng.createAccount("admin", "admin", "admin@gmail.com", "admin", "admin", "2020-07-26");
//        System.out.println(mng.getAllAccs().toString());
        RoomsDB db = RoomsDB.getInstance();
        Date date1 = new Date(1223344);
        Date date2 = Date.valueOf(LocalDate.now());
        //db.updateRoom(1, date, date, 20, "", 1, 4, false, false, false);
        RoomManager mng = RoomManager.getInstance();
        mng.addRoom(date1, date2, 20, "", 1, 4, false, true, false);
        //Room curRom = db.getRoom(1);
        //System.out.println(curRom.toString());

    }
}
