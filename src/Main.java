import DB.MyDBInfo;
import DB.RoomsDB;
import Manager.AccountManager;
import Manager.RoomManager;
import Model.Room;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        File myObj = new File(MyDBInfo.PROJECT_IMAGES_PATH + "123.jpg");
        File ff = new File(MyDBInfo.PROJECT_IMAGES_PATH + "94.jpg");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
            System.out.println(myObj.getAbsolutePath());
        } else {
            System.out.println("File already exists.");
            System.out.println(myObj.getAbsolutePath());
        }
        Files.copy(ff.toPath(), myObj.toPath(), REPLACE_EXISTING);

    }
}
