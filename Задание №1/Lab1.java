import java.util.Scanner;

public class Lab1 {


     static double computeArea(Point3d[] point){

        double Area = 0;

       double	a = point[0].distanceTo(point[1]);
	   double	b = point[1].distanceTo(point[2]);
	   double	c = point[2].distanceTo(point[0]);
	   double   s = (a+b+c)/2; 
	   Area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
	   

        return Area;
    }


    public static void main (String[] args){

        Scanner in = new Scanner(System.in);
        double input = 0;
        Point3d point[] = new Point3d[3];

        for(int i = 0; i < 3; i++){
            point[i] = new Point3d();
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