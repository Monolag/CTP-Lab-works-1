import java.util.Scanner;

public class Lab1 {


     static double computeArea(Point3d[] points){

        double Area = 0,
                s = 0,
                x = 0;

        for (int i = 0; i < 3; i++) {
             s = (points[i].getX() + points[i].getY() + points[i].getZ()) / 2.0d;
             x = (s * (s - points[i].getX()) * (s - points[i].getY()) * (s - points[i].getZ()));
             Area += Math.sqrt(x);
        }

        return 2 * Area;
    }

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        Point3d[] point = new Point3d[3];
        double input = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter X coordinate: ");
            input = in.nextDouble();
            point[i].setX(input);

            System.out.println("Enter Y coordinate: ");
            input = in.nextDouble();
            point[i].setY(input);

            System.out.println("Enter Z coordinate: ");
            input = in.nextDouble();
            point[i].setZ(input);
        }
        System.out.println("Area: " + computeArea(point));
    }
}

