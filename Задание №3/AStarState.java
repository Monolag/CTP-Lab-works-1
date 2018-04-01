import java.util.HashMap;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;


    private HashMap<Location, Waypoint> openWaypoints;
    private HashMap<Location, Waypoint> closedWaypoints; 

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        
        openWaypoints = new HashMap<Location, Waypoint>();
        closedWaypoints = new HashMap<Location, Waypoint>();
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        Waypoint minWaypoint = null;
        
        float min = 999999999;
        float cost = 0;
        
        for(Waypoint i : openWaypoints.values())
        {
            cost = i.getTotalCost();
            
            if(min > cost)
            {
                min = cost;
                minWaypoint = i;
            }
        }
        
        return minWaypoint;
    }


    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Waypoint point = openWaypoints.get(newWP.getLocation());
        
        if(point == null || newWP.getPreviousCost() < point.getPreviousCost())
        {
            openWaypoints.put(newWP.getLocation(), newWP);
            return true;
        }

        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        return openWaypoints.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        Waypoint point = openWaypoints.remove(loc);
        
        if(point != null)
        {
            closedWaypoints.put(loc, point);
        }
    }


    public boolean isLocationClosed(Location loc)
    {
        return closedWaypoints.containsKey(loc);
    }
}

