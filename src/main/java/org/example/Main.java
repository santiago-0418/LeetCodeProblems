package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        twoSum(arr,6);
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] sum = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++) {
            int searching = target - nums[i];
            if(map.containsKey(searching) && map.get(searching)!=i) {
                return new int[]{map.get(searching),i};
            }
        }
        return sum;
    }
}
