import java.util.Arrays;

public class prob27 {
    public static void main(String[] args) {
        int[] test = new int[]{3,2,2,3};
        System.out.println(removeElement(test ,3));
        System.out.println(Arrays.toString(test));
    }

//    static class Solution {
        public static int removeElement(int[] nums, int val) {
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != val){
                    nums[count] = nums[i];
                    count++;
                }
            }
            return count;
    }
}
