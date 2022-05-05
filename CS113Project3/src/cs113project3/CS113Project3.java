package cs113project3;
/**
 *
 * @author mahigada
 */
import java.util.ArrayList;
import java.util.stream.IntStream;

public class CS113Project3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = IntStream.rangeClosed(0, 100).toArray();
        PrimeNumbers.sieve(array);
        PrimeNumbers.goldbach(array);
        // TODO code application logic here  
    }
 public static class PrimeNumbers{
   public static  ArrayList<Integer> primes = new ArrayList<>();
   public static void sieve(int[] array){
    int x;
    for(int i = 2; i < array.length; i++){
         for (int j=i+i; j <= array.length; j = j+i){
             if (array[j]!=0){
                 array[j]=0;          
             }
         }
     }
    for (int y = 2; y < array.length; y++){
        if (array[y]!=0){
            primes.add(y);
        }//adds prime numbers to array
    }
    for (int i: primes) {
        System.out.println(i);
    }
   }
   public static void goldbach(int[] array){
    ArrayList<Integer> myList = new ArrayList<>();
    for(int i = 4; i < array.length; i+=2){
        myList.add(i); //adds even numbers to the array list
    }
    for(Integer i:myList){
        for(int y:primes){
            if(primes.contains(i-y)){
                System.out.println(i + " = " + y + "+" + (i-y));
                break;
        } 
        } 
    }
   }
}
} 