import java.net.*;


public class URL_DP {


    private int myDepth;
    private String myURL;


    public URL_DP(String URL, int depth) {
        myDepth = depth;
        myURL = URL;
    }

    public String getURL() {
        return myURL;
    }

    public int getDepth() {
        return myDepth;
    }


    public String getPath() {
        try {
            URL url = new URL(myURL);
            return url.getPath();
        }
        catch (MalformedURLException e) {
            return null;
        }
    }

    public String getHost() {
        try {
            URL url = new URL(myURL);
            return url.getHost();
        }
        catch (MalformedURLException e) {
            return null;
        }
    }

    public String toString() {
        String stringDepth = Integer.toString(myDepth);
        return "Depth: " + stringDepth + '\t' + "URL: " + myURL;
    }
}