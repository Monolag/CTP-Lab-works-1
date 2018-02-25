import java.util.Scanner;

public class Lab1 {

    static double computeX(Point3d point){
        double s = 0;
        s = (point.getX() + point.getY() + point.getZ()) / 2.0d;
        return (s * (s - point.getX()) * (s - point.getY()) * (s - point.getZ()));
    }

     static double computeArea(Point3d point_1, Point3d point_2, Point3d point_3){

        double Area = 0,
                s = 0,
                x = 0;

        Area += Math.sqrt(computeX(point_1));
         Area += Math.sqrt(computeX(point_2));
         Area += Math.sqrt(computeX(point_3));

        return 2 * Area;
    }
    public static Point3d setData(){
        Scanner in = new Scanner(System.in);
        double input = 0;
        Point3d point = new Point3d();
        System.out.println("Enter X coordinate: ");
        input = in.nextDouble();
        point.setX(input);

        System.out.println("Enter Y coordinate: ");
        input = in.nextDouble();
        point.setY(input);

        System.out.println("Enter Z coordinate: ");
        input = in.nextDouble();
        point.setZ(input);

        return point;
    }

    public static void main (String[] args){

         Point3d point_1 = new Point3d(1,1,1), point_2 = new Point3d(2,2,2), point_3 = new Point3d(3,3,3);
      // point_1 = setData();
      // point_2 = setData();
      // point_3 = setData();

       System.out.println("Area: " + computeArea(point_1, point_2, point_3));
    }
}
