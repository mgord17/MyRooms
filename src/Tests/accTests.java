package Tests;

import Model.Account;
import org.junit.Test;

import static org.junit.Assert.*;


public class accTests{
    Account acc = new Account("0", "dito", "adeishvili", "30-09-1999",
            "dadei17@freeuni.edu.ge", "dito","12", "599 12 77 66");
    Account acc1 = new Account("1","gio", "amashukeli", "09-05-1999",
            "amash17@freeuni.edu.ge", "amasha","123", "599 88 34 66");
    Account acc2 = new Account("2", "luka", "makharadze", "01-04-1999",
            "makha17@freeuni.edu.ge", "mahkara","1234", "599 88 77 13");
    Account acc3 = new Account("3","luka", "makharadze", "01-04-1999",
            "makha17@freeuni.edu.ge", "mahkara","1234", "599 88 77 66");

    @Test
    public void getTests(){
        assertEquals("dito", acc.getFirstName());
        assertEquals("luka", acc2.getFirstName());

        assertEquals("amashukeli", acc1.getLastName());
        assertEquals("makharadze", acc2.getLastName());

        assertEquals("30-09-1999", acc.getBirthDate());
        assertEquals("01-04-1999", acc2.getBirthDate());

        assertEquals("amash17@freeuni.edu.ge", acc1.getEmail());
        assertEquals("makha17@freeuni.edu.ge", acc2.getEmail());

        assertEquals("amasha", acc1.getUsername());
        assertEquals("mahkara", acc2.getUsername());

        assertEquals("123", acc1.getPassword());
        assertEquals("1234", acc2.getPassword());

        assertEquals("0", acc.getId());
        assertEquals("2", acc2.getId());

        assertEquals("599 12 77 66", acc.getPhone());
        assertEquals("599 88 77 13", acc2.getPhone());
    }

    @Test
    public void setTests(){
        // acc(dato mshvenieradze, 01-01-1999, shven@gmail.com, datto, pas12, 599 11 13 14)
        acc.setFirstName("dato");
        assertEquals("dato", acc.getFirstName());
        acc.setLastName("mshvenieradze");
        assertEquals("mshvenieradze", acc.getLastName());
        acc.setBirthDate("01-01-1999");
        assertEquals("01-01-1999", acc.getBirthDate());
        acc.setBirthDate("01-01-1999");
        assertEquals("01-01-1999", acc.getBirthDate());
        acc.setEmail("shven@gmail.com");
        assertEquals("shven@gmail.com", acc.getEmail());
        acc.setUsername("datto");
        assertEquals("datto", acc.getUsername());
        acc.setPassword("pas12");
        assertEquals("pas12", acc.getPassword());
        acc.setPassword("599 12 77 66");
        acc.setPhone("599 11 13 14");
        assertEquals("599 11 13 14", acc.getPhone());
        acc.toString();
    }

    @Test
    public void equalTests(){
        assertFalse(acc.equals(acc1));
        assertFalse(acc1.equals(acc2));
        assertFalse(acc3.equals(acc1));
        assertTrue(acc.equals(acc));
        assertTrue(acc3.equals(acc3));
        assertFalse(acc2.equals(acc3));
    }


}
