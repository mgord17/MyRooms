package Tests;

import Model.Room;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class roomTests {
    Date date1 = new Date(1223344);
    Date date2 = Date.valueOf(LocalDate.now());
    Date date3 = new Date(1243344);
    Date date4 = new Date(1283344);
    Room room =  new Room(0, date1, date3,20,"image1",0,3,true,false,true);
    Room room1 = new Room(1, date2, date3,12,"image2",0,1,true,false,true);
    Room room2 = new Room(2, date3, date4,15,"image3",2,2,true,true,false);
    Room room3 = new Room(3, date1, date4,25,"image4",1,4,false,true,true);

    @Test
    public void getTests(){
        assertEquals(0, room.getRoomId());
        assertEquals(3, room3.getRoomId());

        assertEquals(date1, room.getStartDate());
        assertEquals(date3, room.getEndDate());

        assertEquals(12, room1.getPricePerDay());
        assertEquals(25, room3.getPricePerDay());

        assertEquals("image3", room2.getImg());
        assertEquals("image4", room3.getImg());

        assertEquals(1,room3.getAccountId());
        assertEquals(2, room2.getAccountId());

        assertEquals(1, room1.getNumberOfBeds());
        assertEquals(4, room3.getNumberOfBeds());

        assertEquals(true, room.isWifi());
        assertEquals(false, room.isTv());
        assertEquals(true, room.isHotWater());
    }

    @Test
    public void setTests(){
        // Room(5, date2 , date4, 25, image5, 4, 4, true, true, true)
        room.setRoomId(5);
        assertEquals(5, room.getRoomId());
        room.setStartDate(date2);
        assertEquals(date2, room.getStartDate());
        room.setEndDate(date4);
        assertEquals(date4, room.getEndDate());
        room.setPricePerDay(25);
        assertEquals(25, room.getPricePerDay());
        room.setImg("image5");
        assertEquals("image5", room.getImg());
        room.setAccountId(4);
        assertEquals(4, room.getAccountId());
        room.setNumberOfBeds(4);
        assertEquals(4, room.getNumberOfBeds());
        room.setTv(true);
        assertEquals(true, room.isTv());
        room.setWifi(true);
        assertEquals(true, room.isWifi());
        room.setHotWater(true);
        assertEquals(true, room.isHotWater());
    }

    @Test
    public void equalTests(){
        assertFalse(room.equals(room1));
        assertFalse(room1.equals(room2));
        assertFalse(room3.equals(room1));
        assertTrue(room.equals(room));
        assertTrue(room3.equals(room3));
        assertFalse(room2.equals(room3));
    }

}
