package Tests;

import Manager.AccountManager;
import Model.Account;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import javax.persistence.OrderColumn;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class accMngAndDBTests {
    private AccountManager man;
    private ArrayList<Account> prev;

    @Before
    public void startUp(){
        man = AccountManager.getInstance();
        prev = man.getAccounts();
    }

    @Test
    public void test1() throws NoSuchAlgorithmException {
        assertTrue(man.createAccount("dito", "adeishvili", "1999-09-30",
                    "dadei17@freeuni.edu.ge", "dito","123", "599 12 77 60"));
        assertFalse(man.createAccount("dito", "adeishvili", "1999-09-30",
                "dadei17@freeuni.edu.ge", "dito","123", "599 12 77 60"));
        assertTrue(man.createAccount("gio", "amashukeli", "1999-05-04",
                "amash17@freeuni.edu.ge", "amasha","123", "599 88 34 66"));
        man.deleteAccount("amash17@freeuni.edu.ge","123");
        assertTrue(man.createAccount( "luka", "makharadze", "1999-01-04",
                "makha17@freeuni.edu.ge", "makhara","1234", "599 88 77 13"));
        assertFalse(man.createAccount("luka", "makharadze", "1999-01-04",
                "makha17@freeuni.edu.ge", "makh","12334", "599 88 77 61"));
        assertFalse(man.createAccount("luka", "makharadze", "1999-01-04",
                "makha18@freeuni.edu.ge", "makhara","123424", "599 88 77 65"));
        assertFalse(man.createAccount("luka", "makharadze", "1999-01-04",
                "makha19@freeuni.edu.ge", "mah","125334", "599 88 77 13"));
        assertTrue(man.createAccount("ana", "gamtenadze", "1999-09-30",
                "anuki@freeuni.edu.ge", "anika","anuka", "599 12 77 56"));
        man.deleteAccount("anuki@freeuni.edu.ge","anuka");
    }

    @Test
    public void test2() throws NoSuchAlgorithmException {
        assertFalse(man.loginIntoAccount("dadei17@freeuni.edu.ge", "124235"));
        assertTrue(man.loginIntoAccount("dadei17@freeuni.edu.ge", "123"));
        man.deleteAccount("dadei17@freeuni.edu.ge","123");
        assertFalse(man.loginIntoAccount("makha17@freeuni.edu.ge", "12"));
        assertTrue(man.loginIntoAccount("makha17@freeuni.edu.ge", "1234"));
        assertFalse(man.loginIntoAccount("makha17@freeuni.edu.ge", "1233"));
        assertFalse(man.loginIntoAccount("makha17@freeuni.edu.ge", ""));
        assertFalse(man.loginIntoAccount("makha17@freeuni.edu.ge", "0123"));
        man.deleteAccount("makha17@freeuni.edu.ge","1234");
        assertFalse(man.loginIntoAccount("anuki@freeuni.edu.ge", "anuka"));
    }

    @Test
    public void test3() throws NoSuchAlgorithmException {
        man.deleteAccount("dadei17@freeuni.edu.ge","12");
        assertTrue(man.createAccount("dito", "adeishvili", "1999-09-30",
                "dadei15@freeuni.edu.ge", "dad","12", "599 12 77 66"));
        Account dito = man.getAcc("dadei15@freeuni.edu.ge","12");
        man.updateAccount(dito,"password", "dadei17");
        assertFalse(man.loginIntoAccount("dadei15@freeuni.edu.ge", "12"));
        assertTrue(man.loginIntoAccount("dadei15@freeuni.edu.ge", "dadei17"));
        man.deleteAccount("dadei15@freeuni.edu.ge","dadei17");

        man.deleteAccount("annao17@freeuni.edu.ge","anika");
        assertTrue(man.createAccount("anna", "abashidze", "1999-01-30",
                "annao17@freeuni.edu.ge", "abasha","anita", "599 72 71 73"));
        Account anna = man.getAcc("annao17@freeuni.edu.ge","anita");
        man.updateAccount(anna,"password", "anita3");
        man.deleteAccount("annao17@freeuni.edu.ge","anika");
        assertFalse(man.loginIntoAccount("annao17@freeuni.edu.ge", "anita"));
        assertTrue(man.loginIntoAccount("annao17@freeuni.edu.ge", "anita3"));
        man.deleteAccount("annao17@freeuni.edu.ge","anita3");
        assertFalse(man.loginIntoAccount("annao17@freeuni.edu.ge", "anita3"));
        assertEquals(null,man.getAcc("qewqwr@fa.com", "123"));

        ArrayList<Account> accs =  man.getAccounts();
        for(int i =0; i<accs.size(); i++){
            assertEquals(accs.get(i).getPassword(),prev.get(i).getPassword());
        }

    }

}
