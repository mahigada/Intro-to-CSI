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
        Rational fraction1= new Rational(12,6);
        System.out.println(fraction1);
    } 
}
class Rational extends Number implements Comparable<Rational>{
   private static int num;
   private static int den;
  
   
   
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
   public String mul (Rational n){
       n.num *= this.num ;
       n.den *= this.den;
       return n.num + "/" + n.den;
     
   }
   public String div (Rational n){
       this.num *= n.den;
       this.den *= n.num;
       return n.num + "/" + this.num;
     
   }
  public int gcd (){
       int a = num;
       int b = den;
       int remainder = -1;
       
       while (remainder != 0){
           
           remainder = a%b;
           a = b;
           
           b = remainder;     
       }
     return  a;
       }  
  public String simple (){
       int a = this.gcd();
       int c = this.num/a;
       int d = this.den/a;       
return  c + "/" + d;
  }
  public String toString (){
        return "The number is: " + num + "/"  + den + " The GCD is: " + gcd() + " The Simplified Rational is " + simple(); 
        }
    @Override
    public int intValue() {
        return  num/den; 
    }
    @Override
    public long longValue() {
       return (long) num/ (long) den; 
    }
    @Override
    public float floatValue() {
        return (float) num/ (float) den; 
    }
    public double doubleValue(){
       return (double) num/ (double) den;
   }
    @Override
    public int compareTo(Rational o) {
       if (this.doubleValue() < o.doubleValue()){
        return -1;
    }
       else if (this.doubleValue() == o.doubleValue()){
        return 0;
    }
        return 1;
    }
    }