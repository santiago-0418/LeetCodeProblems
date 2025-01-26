import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class prob15_again {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, Integer> nbs = new HashMap<>();

        HashSet<List<Integer>> unique_triples = new HashSet<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        int curr;
        int next;
        int diff;


        for(int i=0;i<nums.length;i++) {
            nbs.put(i, nums[i]);
        }
        System.out.println(nbs);
        for(int i=0; i<nbs.size()-1;i++){
            curr = nbs.get(i);
            next = nbs.get(i+1);
            diff = diff(curr,next);
            if(nbs.containsValue(diff)){
                List<Integer> triple = new ArrayList<>();
                triple.add(i);triple.add(i+1);triple.add(diff);
                triple = sort(triple);
                unique_triples.add(triple);
            }
        }
        //now change idx to value

        System.out.println("huh: "+unique_triples);

        result.addAll(unique_triples);
        return result;
    }

    public static int diff(int a, int b){
        return (-(a+b));
    }
    public static List<Integer> sort(List<Integer> nums) {
        if(nums.get(0)>nums.get(1)){
            int temp = nums.get(0);
            nums.set(0, nums.get(1));
            nums.set(1, temp);
        }
        if(nums.get(1)>nums.get(2)){
            int temp = nums.get(1);
            nums.set(1, nums.get(2));
            nums.set(2, temp);
        }
        return nums;
    }

}
