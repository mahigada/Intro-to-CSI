package cs113project1;
/**
 *
 * @author mahigada
 */
public class CS113project1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Rational fraction1= new Rational(12,6);
        System.out.println(fraction1);
    }
}

class Rational {

   int num;
   int den;
   
   public Rational (int numerator, int denominator) {
       this.num = numerator;
       this.den = denominator;
   }
   public String add (Rational n){
       n.num *= this.den ;
       this.num *= n.den;
       n.num+=this.num;
       n.den*=this.den;
       return n.num + "/" + n.den;
     
   }   
   public String sub (Rational n){
       n.num *= this.den ;
       this.num *= n.den;
       n.num-=this.num;
       n.den*=this.den;
       return n.num + "/" + n.den;
     
   }
   public String mult (Rational n){
       n.num *= this.num ;
       n.den *= this.den;
       return n.num + "/" + n.den;
     
   }
   public String div (Rational n){
       this.num *= n.den;
       this.den *= n.num;
       return n.num + "/" + this.num;
     
   }
  public String gcd (){
       int a = num;
       int b = den;
       int remainder = -1;
       
       while (remainder != 0){
           
           remainder = a%b;
           a = b;
           
           b = remainder;
           
           
        
       }
       return "GCD: " + a;
       
   }
  public String toString (){
        return "The number is: " + num + "/"  + den + " The GCD is: " + gcd(); 
        }

}

