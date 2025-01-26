import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class prob15 {
    public static void main(String[] args) {
        //System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{1,1,1}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //we want to return a list of a list of the possible combinations of
        // 3 numbers that when added give 0

        //lets try to get the unique nbs in the array, put in a hashset

        //if its only three, then you have the current i'th element,
        //then pick next in line, add them and check if the hashset contains
        //the opposite; if yes the a triplet is found

        //To avoid having duplicate triplets, we could store
        //into a hashmap so that duplicate etnries are overriden

        HashMap<Integer, Integer> unique = new HashMap<>();
        int prev = 0;
        int curr = 0;


        HashSet<Integer> nbs = new HashSet<>();
        for(int i : nums){
            nbs.add(i);
        }
        ArrayList<List<Integer>> res = new ArrayList<>();

        if(nbs.size() == 1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);list.add(0);list.add(0);
            if(nums[0]==0) {
                res.add(list);
            }
            return res;
        }

        for(int i=0; i<nbs.size(); i++){
            //System.out.println(nums.length - i);
            //System.out.println(nums[i]+nums[nums.length-i-1]);
            if(i<nbs.size()-1) {
                System.out.println("number: " + nums[i] + " number idx: " +i);
                //System.out.println(nums[i] + nums[i + 1]);
                //System.out.println(nbs.contains(-(nums[i] + nums[i + 1])));
                if(nbs.contains(-(nums[i] + nums[i + 1]))){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);list.add(nums[i+1]);list.add(-(nums[i]+nums[i+1]));
//                    unique.put(nums[i], i);unique.put(nums[i+1], i+1);
                    curr = Math.abs(nums[i]+nums[i+1])+Math.abs(nums[i])+Math.abs(nums[i+1]);
                    System.out.println("previous: " + prev);
                    if(curr!=prev){
                        res.add(list);
                        prev = curr;
                    }
                }
            }
        }
        System.out.println("RESULTS:\n");
        System.out.println(res);
        System.out.println("unique numbers: " +nbs);
        return res;
    }
}
