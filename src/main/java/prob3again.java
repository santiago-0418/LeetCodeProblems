import java.util.*;

public class prob3again {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        Queue<Character> untouched = new LinkedList<>();
        for(char c : s.toCharArray()){
            queue.add(c);
            untouched.add(c);
        }
        while(!queue.isEmpty()){
            char current = queue.remove();
            if(!set.contains(current)){
                set.add(current);
                untouched.remove();
            }
            else{
                System.out.println("HERE");
                Queue<Character> temp = new LinkedList<>();
            }
            System.out.println("set: " + set);
            System.out.println("untouched: " + untouched.toString());
            System.out.println("queue: " + queue.toString());
        }
        return 1;
    }
//    public static int lengthOfLongestSubstring(String s) {
//
//        HashMap<Character,Integer> map = new HashMap<>();
//        ArrayList<Integer> diffs = new ArrayList<>();
//        int count = 0;
//        //keys are letters
//        int diff = 0;
//        for(int i=0; i<s.length(); i++) {
//            //map setup : [character,idx]
//            Integer check = map.put(s.charAt(i),i);
//            //idea is to check if the put function returns null.
//            //We want to check the distance between occurrences of the same letter
//            if(check!=null){
//                //this means that the new key overrode the hashmap
//                int new_diff = Math.abs(check-map.get(s.charAt(i)));
//                diffs.add(new_diff);
//                if(new_diff>diff) {
//                    diff = new_diff;
//                }
//                System.out.println("space between " + s.charAt(i) + "'s: " + diff);
//            }
//        }
//        //now, my stupid theory is that the longest substring is simply the
//        //biggest space between same occurrences or if no repeats the length of the string
//
//        //if diffs is smaller than the length of the string then one character doesn't repeat
//
//        System.out.println("size of array: " + diffs.size());
//        return diff;
//    }
}
