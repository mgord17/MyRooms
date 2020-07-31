package Tests;

import Manager.AccountManager;
import Manager.RoomManager;
import Model.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class roomMngAndDBTests {
    private RoomManager man;
    private int prev, next;


    @Before
    public void startUp(){
        man = RoomManager.getInstance();
        prev = man.getRooms().size();
    }

    @Test
    public void test1(){
        int id1 = man.addRoom(new Date(2020,07,21),new Date(2020,11,21),
                15,"img1", 1, 3, true, false, false);
        assertEquals(1,man.getRooms().size() - prev);
        man.deleteRoom(id1);
        int id2 = man.addRoom(new Date(2021,07,21),new Date(2020,11,21),
                15,"img1", 1, 3, true, false, false);
        assertEquals(-1,id2);
        int id3 =  man.addRoom(new Date(2019,11,21),new Date(2020,11,21),
                25,"img1", 1, 3, true, true, true);
        assertEquals(1,man.getRooms().size() - prev);
        man.deleteRoom(id3);
    }

    @Test
    public void test2(){
        int id1 = man.addRoom(new Date(2020,07,21),new Date(2020,11,21),
                15,"img12", 1, 3, true, false, false);
        Room r1 = man.getRoom(id1);
        assertEquals(r1.getImg(),"img12");
        assertEquals(r1.getAccountId(),1);
        assertEquals(r1.getNumberOfBeds(),3);
        r1.setImg("img100");
        r1.setTv(true);
        assertNotEquals(r1.getImg(),"img12");
        assertNotEquals(r1.isTv(),false);
        assertEquals(r1.getImg(),"img100");
        assertEquals(r1.getPricePerDay(),15);
        man.deleteRoom(id1);
    }

    @Test
    public void test3(){
        int id2 = man.addRoom(new Date(2020,7,21),new Date(2020,11,21),
                20,"img20", 1, 3, true, false, true);
        Room r2 = man.getRoom(id2);
        boolean up1 = man.updateRoom(id2,new Date(2021,9, 3),new Date(2020,11,21),
                20,"img20", 1, 3, true, false, true);
        assertFalse(up1);
        boolean up2 = man.updateRoom(id2,new Date(2020,3, 4),new Date(2021,11,21),
                21,"img21", 1, 4, true, false, true);
        assertTrue(up2);
        man.deleteRoom(id2);
        Room r = man.getRoom(-1);
        assertEquals(null,r);
        next = man.getRooms().size();
        assertEquals(next,prev);
    }
}
