import java.util.*;

//Храним список URL, которые нужно будет просмотреть в виде URL_DP
public class URLPool {


    private LinkedList<URL_DP> checkURLs = new LinkedList<URL_DP>();
    public LinkedList<URL_DP> checkingURLs = new LinkedList<URL_DP>();
    private ArrayList<String> checkedURLs = new ArrayList<String>();
    public int queueThreads;

    public int getThreads(){
        return queueThreads;
    }

    public synchronized boolean put(URL_DP depthPair) {

        boolean success = false;
        return success;

    }

    public synchronized URL_DP get() {

        URL_DP myDP = null;
        return myDP;
    }


}