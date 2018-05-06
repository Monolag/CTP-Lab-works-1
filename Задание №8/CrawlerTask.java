import java.util.*;


public class CrawlerTask implements Runnable {

    public URL_DP myDP;
    public URLPool myPool;
    public CrawlerTask(URLPool pool) {
        myPool = pool;
    }

    public void run() {
        for (int i=0;i<WebCrawler.getLinks(myDP).size();i++) {
            URL_DP newDepthPair = new URL_DP(WebCrawler.getLinks(myDP).get(i), myPool.get().getDepth() + 1);
            myPool.put(newDepthPair);
        }
    }
}