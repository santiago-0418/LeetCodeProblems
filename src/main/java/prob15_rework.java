import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class prob15_rework {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        //horrible idea that might work:
        //create a hashmap of sublists and the sum of the elements inside
        //if two sublists have the same sum remove one
        //no gud


        HashMap<Integer, List> map = new HashMap<>();

        ArrayList<List<Integer>> res = new ArrayList<>();

        //we are storing values and their indices  <idx;val>
        HashMap<Integer, Integer> nbs = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            nbs.put(i, nums[i]);
        }
        System.out.println(nbs);

        //now we have all of our possible numbers to use
        //at most once per sublist
        System.out.println(nbs.size());
        HashMap<Integer,Integer> tmp = new HashMap<>();
        int unique;

        for(int i=0;i<nbs.size()-1;i++){
            unique = 0;
            int curr = nbs.get(i);
            int prev = nbs.get(i+1);
            int diff = calculte_diff(curr,prev);
            tmp.put(i+i+1,diff);
            System.out.println(tmp);


            //System.out.println(tmp);
            unique = i+(i+1)+diff;
            System.out.println(unique);

            System.out.println("current: " + curr + ", prev: " + prev
            + " diff: " + diff + " contained: " + tmp.containsValue(diff));
            if(tmp.containsValue(diff)){
                List<Integer> list = new ArrayList<>();
                //it still can use the same element twice
                //THIS IS WRONG!!!
                //if(!(nbs.get(i)==diff || nbs.get(i+1)==diff)){
                    list.add(curr);list.add(prev);list.add(diff);
                    map.put(Math.abs(unique), list);
            }
        }
        for(List a : map.values()){
            res.add(a);
        }

        return res;
    }

    public static int calculte_diff(int a, int b){
        return (-(a+b));
    }
}
