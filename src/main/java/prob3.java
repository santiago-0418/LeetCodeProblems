import java.awt.*;
import java.util.*;

public class prob3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    //we want to find the longest substring

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        int curr = 0;
        int best_q = 0;
        int best_s = 0;

        for(char c : s.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        //we will iterate from the front and from the back
        //take the biggest of the two as the answer
        //DUMB IDEA THIS SHIT DOESNT WORK EITHER AHSFJASHFGASFHADFAFD

        //front
        while(!queue.isEmpty()) {
            char current_char = queue.poll();
            if(!visited.contains(current_char)) {
                visited.add(current_char);
                curr++;
            }
            else{
                //updating the longest so far
                if(curr>best_q){best_q=curr;}
                curr=0;
            }
        }
        if(curr>best_q){best_q=curr;}

        //resetting curr and the hashset
        curr=0;
        visited.clear();
        //
        //back
        while(!stack.isEmpty()) {
            char current_car = stack.pop();
            if(!visited.contains(current_car)) {
                visited.add(current_car);
                curr++;
            }
            else{
                if(curr>best_s){best_s=curr;}
                curr=0;
            }
        }
        System.out.println("queue: " + best_q);
        System.out.println("stack: " + best_s);
        if(curr>best_s){best_s=curr;}

        System.out.println(queue);

        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Integer> diffs = new ArrayList<>();
        int count = 0;
        //keys are letters
        int diff = 0;
        for(int i=0; i<s.length(); i++) {
            //map setup : [character,idx]
            Integer check = map.put(s.charAt(i),i);
            //idea is to check if the put function returns null.
            //We want to check the distance between occurrences of the same letter
            if(check!=null){
                //this means that the new key overrode the hashmap
                int new_diff = Math.abs(check-map.get(s.charAt(i)));
                diffs.add(new_diff);
                if(new_diff>diff) {
                    diff = new_diff;
                }
                System.out.println("space between " + s.charAt(i) + "'s: " + diff);
            }
        }


        //return the bigger
        int method1_max =  Math.max(best_s, best_q);
        return Math.max(method1_max, diff);
    }
    //        Queue<Character> queue = new LinkedList<>();
//        ArrayList<Character> untouched = new ArrayList<>();
//        HashSet<Character> visited = new HashSet<>();
//
//        int curr = 0;
//        int best = 0;
//        char currentChar;
//        char previousChar = ' ';
//        for(char c : s.toCharArray()){
//            queue.add(c);
//            untouched.add(c);
//            System.out.println(c);
//        }
//        while(!queue.isEmpty()){
//            currentChar = queue.poll();
//            if(!(visited.contains(currentChar))){
//                visited.add(currentChar);
//                curr++;
//            }
//            else{
//                System.out.println("current char when shit goes bad: " + currentChar);
//                System.out.println("current previous char: " + previousChar);
//                if(curr>best){best=curr;}
//                visited.clear();
//                //visited.add(currentChar);
//                //curr++;
//                Queue<Character> queue2 = new LinkedList<>();
//                System.out.println(curr);
//                for(int i=s.length()-1; i>(s.length()-curr-2); i--){
//                    queue2.add(s.charAt(i));
//                }
//                curr=0;
//                //queue2.addAll(queue);
//                queue=queue2;
//                System.out.println(queue.toString());
//            }
//            previousChar = currentChar;
//        }
//        if(curr>best)
//            best = curr;
//        return best;
//        HashMap<Integer, Character> chars = new HashMap<>();
//        HashSet<Character> set = new HashSet<>();
//        for(int i=0; i<s.length(); i++) {
//            char c = s.charAt(i);
//            chars.put(i,c);
//        }
//
//        int count = 0;
//        int best = 0;
//        char previous = ' ';
//
//        for(int i : chars.keySet()){
//            if(!set.contains(chars.get(i))){
//                set.add(chars.get(i));
//                count++;
//            }
//            else{
//
//            }
//        }
//        System.out.println(chars);
//        return best;
}
