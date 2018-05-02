import java.util.*;

//Храним список URL, которые нужно будет просмотреть в виде URL_DP
public class URLPool {


    LinkedList<URL_DP> checkURLs = new LinkedList<URL_DP>();
    LinkedList<URL_DP> checkingURLs = new LinkedList<URL_DP>();
    private ArrayList<String> checkedURLs = new ArrayList<String>();
    public int queueThreads;

    public int getThreads(){
        return queueThreads;
    }

}