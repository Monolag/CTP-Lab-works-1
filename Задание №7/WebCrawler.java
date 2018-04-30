import java.net.*;
import java.util.*;
import java.io.*;


public class WebCrawler {

    public static void main(String[] args) {

        int depth = 0;

		//Проверка введенных данных
        if (args.length != 2) {
            System.out.println("usage: java Crawler <URL> <depth>");
            System.exit(1);
        } else {
            try {
                depth = Integer.parseInt(args[1]);
            } catch (NumberFormatException nfe) {
                System.out.println("usage: java Crawler <URL> <depth>");
                System.exit(1);
            }
        }
        LinkedList<URL_DP> checkURLs = new LinkedList<URL_DP>();
        LinkedList<URL_DP> checkedURLs = new LinkedList<URL_DP>();
        LinkedList<URL_DP> checkingURLs = new LinkedList<URL_DP>();
        URL_DP usedDP = new URL_DP(args[0], 0);
        LinkedList<String> links = new LinkedList<String>();
        checkURLs.add(usedDP);

        while(checkURLs.size() != 0) {
            URL_DP depthP = checkURLs.pop();
            checkedURLs.add(depthP);
            int myDepth = depthP.getDepth();

            links = WebCrawler.getLinks(depthP);

            // TODO Проверить: если заявленная глубина не достигнута,
            // TODO добавить сайт, который не был проверен

        }
        //Пройти через все собранные URL и вывести каждый
        Iterator<URL_DP> iterator = checkedURLs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static LinkedList<String> getLinks(URL_DP _URL){
        String Path = _URL.getPath();
        String Host = _URL.getHost();

        LinkedList<String> URLs = new LinkedList<String>();
        String endURL = "\"";
        String startURL = "a href=\"";
        //Создание соккета
        Socket socket;
        try {
            socket = new Socket(_URL.getHost(), 80);
            socket.setSoTimeout(3000);
        }
        catch(IOException ex){return null;}


        try {

            InputStreamReader in = new InputStreamReader(socket.getInputStream());
        }
        catch(IOException ex){ return null;}

        OutputStream ostr;
        try{
            ostr = socket.getOutputStream();
        }
        catch(IOException ex){
            return null;
        }

        PrintWriter myWriter = new PrintWriter(ostr, true);
        myWriter.println("GET " + Path + " HTTP/1.1");
        myWriter.println("Host: " + Host);
        myWriter.println("Connection: close");
        myWriter.println();

        InputStream inStr;

        try{
            inStr = socket.getInputStream();
        }
        // TODO Почему в  OutputStream ostr нет ошибки, а в  InputStream inStr заходит в catch, хотя такого быть не должно
        catch(IOException ex){
            return URLs;}

        InputStreamReader readInput = new InputStreamReader(inStr);
        BufferedReader readBuffer = new BufferedReader(readInput);
        boolean tryRead = true;

        while(tryRead){
            String text = "";

            try{
                text = readBuffer.readLine();
            }
            catch(IOException ex){ return URLs;}

            if (text == null) { tryRead = false; };

            int index = 0;
            int startIndex = 0;
            int endIndex = 0;

            while(index != -1){
                //Найти начало нужной строки
                try {
                    index = text.indexOf(startURL, index);
                }
                catch(NullPointerException ex){
                    return URLs;
                }
                if(index ==-1){
                    break;
                }
                index += startURL.length();
                startIndex = index;
                endIndex = text.indexOf(endURL, index);
                index = endIndex;
                URLs.add(text.substring(startIndex,endIndex));
            }
        }


      return URLs ;
    }
}