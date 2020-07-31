package Manager;

import DB.RoomsDB;
import Model.Room;

import java.util.ArrayList;
import java.util.Date;

public class RoomManager {

    private static RoomManager rm;
    private RoomsDB rdb;

    private RoomManager() {
        rdb = RoomsDB.getInstance();
    }

    public static RoomManager getInstance() {
        if (rm == null) {
            synchronized (RoomManager.class) {
                if (rm == null) rm = new RoomManager();
            }
        }
        return rm;
    }

    public Integer addRoom(Date sDate, Date eDate, Integer pricePerDay, String img, Integer accountId,
                           Integer numberOfBeds, boolean wifi, boolean tv, boolean hotWater) {
        if (!sDate.before(eDate) || pricePerDay < 0 || accountId < 1 || numberOfBeds < 0)
            return -1;
        return rdb.addRoom(sDate, eDate, pricePerDay, img, accountId, numberOfBeds, wifi, tv, hotWater);
    }
    public ArrayList<Room> getRooms(){
//        System.out.println(rdb == null);
        return rdb.getRooms();
    }
    public boolean updateRoom(Integer room_id, Date sDate, Date eDate,  Integer pricePerDay, String img, Integer accountId,
                              Integer numberOfBeds, boolean wifi, boolean tv, boolean hotWater) {
        if (room_id < 1 || !sDate.before(eDate) || pricePerDay < 0 || accountId < 1 || numberOfBeds < 0) return false;
        return rdb.updateRoom(room_id, sDate, eDate, pricePerDay, img, accountId, numberOfBeds, wifi, tv, hotWater);
    }

    public boolean deleteRoom(Integer room_id) {
        if(room_id<0) return false;
        return rdb.deleteRoom(room_id);
    }

    public Room getRoom(Integer room_id) {
        return rdb.getRoom(room_id);
    }
}

