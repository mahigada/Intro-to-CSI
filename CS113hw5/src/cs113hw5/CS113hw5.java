package cs113hw5;
/*
Mahi Gada
Professor Kappleau
CS 113 H02
25 March 2019
 */
public class CS113hw5 {
	public static void main(String[] args)
	{
        // PP 8.5
        int[] nums = new int[]{2,4,6,7,8,9,10,12,11,11,16}; 
        System.out.println("Mean: " + mean(nums));
        System.out.println("Standard Deviation: " + standardDev(nums));
        }
      public static float mean (int[] nums) {
         double ans = 0;
         for (int i = 0; i < nums.length; i++){
             ans +=nums[i];
         }
         ans = ans/nums.length;
         return (float) ans;
        }
      public static float standardDev (int[] nums) {
         double ans = 0;
         for (int i = 0; i < nums.length; i++){
        ans += Math.pow(nums[i]-mean(nums),2); 
         }
         ans = Math.sqrt(ans/nums.length);
         return (float) ans;
        }
}
