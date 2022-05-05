package cs113project6a;

/**
 *
 * @author mahigada
 */
public class CS113Project6a {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {

        int n = args.length == 1 ? Integer.parseInt(args[0]) : 1;

        for (int i = 1; i <= 10; ++i) {
            int[] arr = Pascal.triangle(i);
            System.out.print((i < 10 ? " " : "") + i + ": ");
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}


class Pascal
{
public static int[] triangle(int n)
   {
       int[]ans = new int[n];
       if(n==1){
           ans[0]=1;
       return ans;
       }
       
       if(n==2){
           ans[0] =1;
           ans[1] = 1;
           return ans;
       }
       int[] prevArr = triangle(n-1);
       int[] newArr = new int[n];  
       newArr[0] = 1;
       newArr[n-1] = 1;
       for(int i=1; i<n-1; i++)
       {
           newArr[i] = prevArr[i-1] + prevArr[i];
       }
      
       return newArr;
}
}

