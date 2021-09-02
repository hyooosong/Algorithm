import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        int[] arr = {0, 0};
        HashSet<String> set = new HashSet();
        
        for(int i = 0; i < dirs.length(); i++) {
            int prev_x = arr[0];
            int prev_y = arr[1];
            
            switch(dirs.charAt(i)) {
                case 'U' : 
                    if(arr[1] + 1 <= 5) arr[1]++;
                    break;
                case 'D' :
                    if(arr[1] - 1 >= -5) arr[1]--;
                    break;
                case 'L' :
                    if(arr[0] - 1 >= -5) arr[0]--;
                    break;
                case 'R' :
                    if(arr[0] + 1 <= 5) arr[0]++;
                    break;
            }
            
            if(prev_x == arr[0] && prev_y == arr[1]){
                continue;
            }
            
            set.add(arr[0] + "" + arr[1] + "" + prev_x + "" + prev_y);
            set.add(prev_x + "" + prev_y + "" + arr[0] + "" + arr[1]);
        }
        
        return set.size() / 2;
    }
}