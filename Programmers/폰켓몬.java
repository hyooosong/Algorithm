import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet();
        
        for(int i : nums) {
            set.add(i);
        }
        
        return set.size() <= nums.length / 2 ? 
            set.size() : nums.length / 2;
    }
}