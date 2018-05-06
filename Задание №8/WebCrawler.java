import java.net.*;
import java.util.*;
import java.io.*;

class WebCrawler {
    

    public static void main(String[] args) {
        int depth = 0;
        int neededThreads = 4;

        if (args.length != 2) {
            System.out.println("usage: java Crawler <URL> <depth>");
            System.exit(1);
        }
        else {
            try {
                depth = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException nfe) {

                System.out.println("usage: java Crawler <URL> <depth>");
                System.exit(1);
            }
        }

        URL_DP currentDepthPair = new URL_DP(args[0], 0);
        URLPool pool = new URLPool();
        pool.put(currentDepthPair);
        int ActiveTr = Thread.activeCount();


        while (pool.getThreads() != neededThreads) {
           // Если кол-во потоков меньше запрашиваемого кол-ва, создать еще поток и
            //передать его в CrawlerTask
            if (Thread.activeCount() - ActiveTr < neededThreads) {
                CrawlerTask crawler = new CrawlerTask(pool);
                new Thread(crawler).start();
            } else {
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException ie) {
                }
            }
        }

        Iterator<URL_DP> iter = pool.checkingURLs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.exit(0);
        


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

        catch(IOException ex){
            return URLs;
        }

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
