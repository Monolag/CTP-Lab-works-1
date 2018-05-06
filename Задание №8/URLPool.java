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

        if (checkedURLs.contains(depthPair.getURL())) {
            return false;
        }
        checkingURLs.add(depthPair);
        if (depthPair.getDepth() < 4) {
            checkURLs.add(depthPair);
            notify();
        }
        checkedURLs.add(depthPair.getURL());
        return true;
    }

    public synchronized URL_DP get() {
        while (checkURLs.size() == 0) {
            try {
                queueThreads++;
                wait();
                queueThreads--;
            } catch (InterruptedException e) { }
        }
        URL_DP nextPair = checkURLs.removeFirst();
        return nextPair;
    }
}