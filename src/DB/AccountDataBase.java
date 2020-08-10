package DB;

import Model.Account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDataBase{
    private static final String account = MyDBInfo.MYSQL_USERNAME;
    private static final String password = MyDBInfo.MYSQL_PASSWORD;
    private static final String server = MyDBInfo.MYSQL_DATABASE_SERVER;
    private static final String database = MyDBInfo.MYSQL_DATABASE_NAME;
    private static AccountDataBase dataB;
    private Connection con;
    private Statement stat;

    private AccountDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + server, account, password);
            stat = con.createStatement();
            stat.executeQuery("USE " + database + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String formatInfo(String firstName, String lastName, String birthdate, String email, String username, String password, String phone) {
        return "\'" + firstName + "\'" + ", " + "\'" + lastName + "\'" + ", " + "\'" + birthdate + "\'" + ", "
                + "\'" + email + "\'" + ", " + "\'" + username + "\'" + ", " + "\'" + password + "\'" + ", " + "\'" + phone + "\'";
    }

    public boolean addAccount(String firstName, String lastName, String birthdate, String email, String username, String password, String phone) throws NoSuchAlgorithmException{
        try {
            if(containsUser(username) || containsPhone(phone) || containsEmail(email)) return false;
            String newInfo = formatInfo(firstName, lastName, birthdate, email, username, password, phone);
            String InsertStr = "insert into accounts(first_name, last_name, birth_date, email, username, password, phone) values ";
            InsertStr += "(" + newInfo + ");";
            stat.executeUpdate(InsertStr);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean contains(String field, String val) {
        String query = "select count("+ field +") from accounts where " + field + " = \'" + val + "\';";
        ResultSet rs;
        try {
            rs = stat.executeQuery(query);
            if(rs.next()) {
                if(rs.getInt(1) > 0) return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean containsEmail(String email) {
        return contains("email", email);
    }

    public boolean containsPhone(String Phone) {
        return contains("phone", Phone);
    }

    public boolean containsUser(String User) {
        return contains("username", User);
    }

    public boolean updateAccount(String email, String toUpdate, String newValue) {
        try {
            if(containsEmail(email) == false || toUpdate.equals("email") || toUpdate.equals("account_id")) return false;
            if(email == null || toUpdate == null || newValue == null) return false;
            stat.executeUpdate("update accounts set " + toUpdate + " = \'" + newValue + "\' where email = \'" + email + "\';");
            return true;
        }catch (SQLException e) {
            return false;
        }
    }


    public ArrayList<Account> getAccounts(){
        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            ResultSet rs = stat.executeQuery("select * from Accounts;");
            while(rs.next()){
                Account curAcc = new Account(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8));
                accounts.add(curAcc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return accounts;
    }

    public Account getAccount(String email) {

        if(email == null) return null;
        Account res = null;
        try {
            ResultSet rs = stat.executeQuery("select * from accounts where email = \'" + email + "\';");
            if(rs.next()) {
                res = new Account(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8));
            }

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        return res;
    }

    public boolean deleteAccount(String email, String password) throws NoSuchAlgorithmException {
        if(containsEmail(email) == false || password == null) return false;
        String query = "delete from accounts where email = \'" + email +"\' and password = \'" + password +"\';";
        try {
            stat.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static AccountDataBase getInstance() {
        if (dataB == null) {
            synchronized (RoomsDB.class) {
                if (dataB == null) dataB = new AccountDataBase();
            }
        }
        return dataB;
    }
}
