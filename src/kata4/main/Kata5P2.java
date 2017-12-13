package kata4.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReaderDDBB;

public class Kata5P2 {

    public static void main(String[] args) throws IOException, Exception {
        Kata5P2 kata5P2 = new Kata5P2();
        kata5P2.execute();
    }
    
    private ArrayList <Mail> mailList;
    private Histogram histogram;
    
    private void execute () throws Exception{
        input();
        process();    
        output();
    }

    private void input() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {
        
        mailList = MailListReaderDDBB.read();
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
    }
}
