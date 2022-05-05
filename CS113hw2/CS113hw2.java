/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs113hw2;

import java.util.Scanner;

/**
 *
 * @author mahigada
 */
public class CS113hw2 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        //PP 2.5       
 double inches, feet;
 Scanner scan = new Scanner(System.in);
 System.out.println("Enter the number of inches: ");
 inches = scan.nextDouble();
 feet = inches/12.0; 
 System.out.println(inches + " inches is " + feet + " feet"); 
        
 //PP 2.6
 
 float gram, pounds;
 System.out.println("Enter the number of grams: ");
 gram = scan.nextFloat();
 pounds = gram/453.592f; 
 System.out.println(gram + " grams is " + pounds + " pounds"); 
  
 //PP 2.8
 double kilograms2, grams2, milligrams2, totalMilligrams2;
 System.out.println("Enter the number of kilograms: ");
 kilograms2 = scan.nextDouble();
 System.out.println("Enter the number of grams: ");
 grams2 = scan.nextDouble();
 System.out.println("Enter the number of milligrams: ");
 milligrams2 = scan.nextDouble();
 totalMilligrams2 = ((kilograms2*1000000) + (grams2*1000) + (milligrams2));
 System.out.println("The total number of milligrams is " + totalMilligrams2); 
 
 
 //PP 2.9
 int kilograms3, grams3, totalMilligrams3;
 System.out.println("Enter the number of milligrams: ");
 totalMilligrams3 = scan.nextInt();
 kilograms3 = (totalMilligrams3/1000000);
 totalMilligrams3 = totalMilligrams3-(kilograms3*1000000);
 grams3 = (totalMilligrams3/1000);
 totalMilligrams3 = totalMilligrams3-(grams3*1000);
 System.out.println("The number of kilograms is " + kilograms3 + ". The number of grams is "
         + grams3 + ". The number of milligrams is "+ totalMilligrams3 + "."); 
    }
    
}

