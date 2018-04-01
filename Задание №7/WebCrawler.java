import java.net.*;
import java.util.*;
import java.io.*;


public class WebCrawler {

    public static void main(String[] args) {

        int depth = 0;
		String URL, depth;
        if (args.length != 2) {
            System.out.println("usage: java Crawler <URL> <depth>");
            System.exit(1);
        } else {
            try {
                depth = Integer.parseInt(depth);
            } catch (NumberFormatException nfe) {
                System.out.println("usage: java Crawler <URL> <depth>");
                System.exit(1);
            }
        }
    }

    LinkedList<String> getLinks(URL_DP _URL){
        LinkedList<String> URLs = new LinkedList<String>();

        Socket socket;
        try {
            socket = new Socket(_URL.getHost(), 80);
        }
        catch(IOException ex){return null;}

        try {

            InputStreamReader in = new InputStreamReader(socket.getInputStream());
        }
        catch(IOException ex){ return null;}

        String Path = _URL.getPath();
        String Host = _URL.getHost();
      return URLs ;
    }

}