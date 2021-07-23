import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        ArrayList<Integer> list = 
            (ArrayList<Integer>) Arrays.stream(lost)
            .boxed()
            .collect(Collectors.toList());

        for(int i = 0; i < reserve.length; i++) {
            if(list.contains(reserve[i])) {
                list.remove(Integer.valueOf(reserve[i]));
                reserve[i] = -1;
            }
        }
        
        for(int i = 0; i < reserve.length; i++) {
            for(int j : list) {
                if(j == reserve[i]+1 || j == reserve[i]-1) {
                    list.remove(Integer.valueOf(j));
                    break;
                }
            }
        }
        return n - list.size();
    }
}