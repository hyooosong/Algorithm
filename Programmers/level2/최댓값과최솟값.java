class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = min;
        
        for(int i = 1; i < arr.length; i++) {
            int now = Integer.parseInt(arr[i]);
            if(max < now) max = now;
            if(min > now) min = now;
        }
        
        return min + " " + max;
    }
}