/*
*
 *
 * @author mahigada
 */
public class CS113Project5 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BigInt a = new BigInt(args.length == 2 ? args[0] : "2000");
        BigInt b = new BigInt(args.length == 2 ? args[1] : "2000");
        System.out.println(a + (a.equals(b) ? " equals " : " does not equal ") + b);

        System.out.println(a + (a.compareTo(b) < 0 ? " < " : (a.compareTo(b) > 0 ? " > " : " = ")) + b);

        System.out.println(a + " + " + b + " = " + a.add(b));
        if (a.compareTo(b) >= 0) {
            System.out.println(a + " - " + b + " = " + a.sub(b));
        }
        System.out.println(a + " * " + b + " = " + a.mul(b));
        if (a.compareTo(b) >= 0) {
            System.out.println(a + " / " + b + " = " + a.div(b));
        }
    }
}
final class BigInt implements Comparable<BigInt> {
    public BigInt() {
        n = new int[1];
    }
    public BigInt(String s) {
        n = new int[s.length()];
        for (int i = 0; i < n.length; ++i) {
            n[n.length - i - 1] = s.charAt(i) - '0';
        }
        n = trim(n);
    }
    private BigInt(int[] n) {

        this.n = new int[n.length];

        for (int i = 0; i < n.length; ++i) {
            this.n[i] = n[i];
        }
    }
    public BigInt add(BigInt o) {
        int car = 0;
        int max = n.length > o.n.length ? n.length : o.n.length;
        int[] result = new int[max+1];
        for (int i = 0; i <= max; ++i) {
            int t = i < n.length ? n[i] : 0;
            int b = i < o.n.length ? o.n[i] : 0;
            result[i] = (t + b + car) % 10;
            car = (t + b + car) / 10;
        }
        return new BigInt(trim(result));
    }

    public int compareTo(BigInt o) {
        int l1 = n.length;
        int l2 = o.n.length;
        if (l1>l2){
            return 1;
        }
        else if (l1<l2){
            return -1;
         }
        else{
        for(int i=l1-1; i>=0; i--){
       if(n[i] > o.n[i]){
        return 1;
       }else if(n[i] < o.n[i]){
        return -1;
       }
      }
      return 0;
    }
    }
    public BigInt div(BigInt o) {
        return null;
    }
    public boolean equals(BigInt o) {
    if (this.compareTo(o) == 0){
        return true;
    } 
    else{
        return false;
    }
    }
   public BigInt mul(BigInt o) {
    int l1 = n.length;
    int l2 = o.n.length;
    if(l1 == 0 || l2 ==0){
     return new BigInt("0");
    }
    int result[] = new int[l1+l2];
    for(int i=0; i<result.length; i++){
      result[i] = 0;
    }
    int car = 0;
    int mult =0;
    int add = 0;
    int currentPos = 0;
    for(int i=0; i<l1; i++){
      currentPos = i;
      car = 0;
      for(int j=0; j<l2;j++){
       mult = n[i] * o.n[j];
       add = car + mult + result[currentPos];
       result[currentPos] = add %10;
       car = add /10;
       currentPos++;
      }
      if(car >0){
       result[currentPos] = car;
      }
    }
        return new BigInt(result);
    }
    public BigInt sub(BigInt o) {
    int l1 = n.length;
    int l2 = o.n.length;
    int[] result = new int[l1];
    int k=0;
    int car = 0;
    for(int i=0; i<l2;i++){
      int sub = (n[i] - o.n[i] - car);
      if(sub < 0){
       sub = sub +10;
       car = 1;
      }else{
       car = 0;
      }
      result[k++] = sub;
    }
    for(int i=l2; i<l1; i++){
      int sub = n[i] - car;
      if(sub <0){
       sub = sub +10;
       car = 1;
      }else{
       car = 0;
      }
      result[k++] = sub;
    }
        return new BigInt(result);
    }
    public String toString() {
        String s = "";
        for (int i : n) {
            s = i + s;
        }
        return s;
    }
    private int[] trim(int[] nums) {
        int size = nums.length;

        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] != 0) {
                break;
            }
            --size;
        }
        int[] res = new int[size];
        for (int i = 0; i < size; ++i) {
            res[i] = nums[i];
        }
        return res;
    }
    private int[] n;
}