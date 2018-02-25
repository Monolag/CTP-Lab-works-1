public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d (double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d() {
        this (0,0,0);
    }

    public double getX(){
        return xCoord;
    }
    public double getY(){
        return yCoord;
    }
    public double getZ(){
        return zCoord;
    }
    public void setX(double val){
        xCoord = val;
    }
    public void setY(double val){
        yCoord = val;
    }
    public void setZ(double val){
        zCoord = val;
    }

    public boolean compare(Point3d point){
        return  (point.getX() == this.getX()) && (point.getY() == this.getY()) && (point.getZ() == this.getZ());
    }

    public double distanceTo(Point3d point){

        return Math.sqrt(Math.pow((point.getX()-this.getX()),2)
		+ Math.pow((point.getY()-this.getY()),2)
		+ Math.pow((point.getZ()-this.getZ()),2));
    }
}