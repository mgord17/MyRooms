package Manager;

import DB.AccountDataBase;
import Model.Account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static AccountManager manager;
    private AccountDataBase db;

    private AccountManager() {
        db = AccountDataBase.getInstance();
    }

    public static AccountManager getInstance() {
        if (manager == null) {
            synchronized (AccountManager.class) {
                if (manager == null) manager = new AccountManager();
            }
        }
        return manager;
    }

    public boolean createAccount(String firstName, String lastName, String birthdate, String email, String username, String password,  String phone) throws NoSuchAlgorithmException {
        return db.addAccount(firstName, lastName, birthdate, email, username, hashString(password), phone);
    }

    public boolean loginIntoAccount(String email, String password) throws NoSuchAlgorithmException {
        Account cur = db.getAccount(email);
        if(cur == null || password == null) return false;
        if(cur.getPassword().equals(hashString(password))) return true;
        return false;
    }


    public boolean updateAccount(Account account, String needUpdate, String newVal) throws NoSuchAlgorithmException {
        String new_value = newVal;
        if(needUpdate.equals("password")) {
            new_value = hashString(newVal);
        }
        return db.updateAccount(account.getEmail(), needUpdate, new_value);
    }

    public boolean deleteAccount(String email, String password) throws NoSuchAlgorithmException {
        return db.deleteAccount(email, hashString(password));
    }

    public Account getAcc(String email, String password) throws NoSuchAlgorithmException {
        if(loginIntoAccount(email, password)){
            Account acc = db.getAccount(email);
            return acc;
        }
        return null;
    }

    public ArrayList<Account> getAccounts(){
        return db.getAccounts();
    }


    private static String hexToString(byte[] bytes) {
        StringBuffer buff = new StringBuffer();
        for (int i=0; i<bytes.length; i++) {
            int val = bytes[i];
            val = val & 0xff;  // remove higher bits, sign
            if (val<16) buff.append('0'); // leading 0
            buff.append(Integer.toString(val, 16));
        }
        return buff.toString();
    }

    private static String hashString(String st) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(st.getBytes());
        return hexToString(md.digest());
    }
}

