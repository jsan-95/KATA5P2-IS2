package kata4.main;

import java.io.IOException;
import java.util.ArrayList;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

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

    private void input() throws IOException {
        String fileName = "/Users/Yisus95/NetBeansProjects/Kata4/src/emails.txt";
        mailList = MailListReader.read(fileName);
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
    }
}
