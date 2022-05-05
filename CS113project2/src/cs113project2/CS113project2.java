
package cs113project2;

import java.util.Random;
import java.util.Scanner;
public class CS113project2 {
/**
 * @param args the command line arguments
 */
    public static void main(String[] args) {
       Scanner scan = new Scanner (System.in);
       System.out.println(findAreaCircle(0.5));
       System.out.println(findAreaSquare(0.5));
       System.out.println(findDistance());
       System.out.println(calculatePi(100000));
    }
    public static double findAreaCircle(double radius){
        double area = Math.PI * Math.pow(radius,2);
        return area;
    }
    public static double findDistance(){
       Random rand = new Random();
       double x1 = rand.nextDouble();
       double y1 = rand.nextDouble();
       double distance = Math.sqrt(Math.pow((0.5-x1),2)+ Math.pow((0.5-y1),2));
       return distance;
    }
    public static double findAreaSquare(double radius){
       double area = 4*radius*radius;
       return area;
    }
    public static double calculatePi(int length){
       int inCircle = 0;
       int inSquare = 0;
       for (int i =0; i<length; i++){
       
       if (findDistance() <=0.5){
           inCircle ++;
           inSquare ++;
       }
       else
           inSquare ++;   
    }
       return (4*((double) inCircle/(double) inSquare));
}
}
