import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] arr) {
        ArrayList<Integer> list = (ArrayList<Integer>) 
            Arrays.stream(arr).boxed().collect(Collectors.toList());

        while(list.size() > 1) {
            for(int i = 0; i < list.size()-1; i+=2) {
                int result = list.get(i) / GCD(list.get(i), list.get(i + 1)) * list.get(i + 1);
                list.set(i, result);
                list.set(i + 1, 0);
            }
            list.removeAll(Arrays.asList(Integer.valueOf(0)));
        }
        
        return list.get(0);
    }
    
    public int GCD(int a, int b) {
        if(b == 0)
            return a;
        
        return GCD(b, a % b);
    }
}