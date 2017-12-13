
package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import kata4.model.Mail;


public class MailListReaderDDBB {
    
    public static ArrayList<Mail> read() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException{
        ArrayList<Mail> mailList = new ArrayList<>();
        String email = "";
        Class.forName("org.sqlite.JDBC");
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/Yisus95/Downloads/Ficheros para la práctica en laboratorio 5 -20171129/KATA.sdb")) {
            PreparedStatement ps= con.prepareStatement("select * from mail");
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                System.out.println(rs.getInt("id")+" "+rs.getString("mail"));
                email = rs.getString("mail");
                if(email.contains("@")){
                    mailList.add(new Mail(email));
                }
            }
        }
        
        return mailList;
    }
}
