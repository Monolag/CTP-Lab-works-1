import java.net.*;


public class URL_DP {

    private int _Depth;
    private String _URL;

    public URL_DP(String URL, int depth) {
        _Depth = depth;
        _URL = URL;
    }

    public String ToString() {
        String stringDepth = Integer.toString(_Depth);
        return stringDepth + '\t' + _URL;
    }

    public String getPath() {
        try {
            URL url = new URL(_URL);
            return url.getPath();
        }
        catch (MalformedURLException e) {
            return null;
        }
    }

    public String getHost() {
        try {
            URL url = new URL(_URL);
            return url.getHost();
        }
        catch (MalformedURLException e) {
            return null;
        }
    }

    public String getURL() {
        return _URL;
    }

    public int getDepth() {
        return _Depth;
    }
}