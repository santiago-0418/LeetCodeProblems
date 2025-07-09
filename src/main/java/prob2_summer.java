import java.util.ArrayList;
import java.util.HashSet;

public class prob2_summer {
    public static void main(String[] args) {


        System.out.println(lengthOfLongestSubstring("au"));

    }
    public static int lengthOfLongestSubstring(String s) {
        //get longest substring (no repeating characters but continuous)


        //convert stupid string into characters
        ArrayList<Character> chars = new ArrayList<>();
        for(char c : s.toCharArray()) {
            chars.add(c);
        }
        System.out.println(chars.size());

        //idea:
        // create sub_strings for each letter, add a char to substring if not contained in hashset

        ArrayList<Character> best = new ArrayList<>();
        for(int i=0;i<chars.size();i++){
            if(chars.size()==1){
                return 1;
            }
            HashSet<Character> visited = new HashSet<>();
            ArrayList<Character> temp = new ArrayList<>();

            //add the current first letter
            visited.add(chars.get(i));
            temp.add(chars.get(i));

            //loop through the other letters
            for(int j=i+1;j<chars.size();j++){
                if(!visited.contains(chars.get(j))){
                    temp.add(chars.get(j));
                    visited.add(chars.get(j));
                }
                else{
                    break;
                }
            }
            if(temp.size()>best.size()){
                best.clear();
                best.addAll(temp);
            }
        }
        return best.size();
    }

}
