import java.util.Arrays;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int result = -1;

        for(String str : table) {
            int sum = 0;
            String[] arr = str.split(" ");
            
            for(int i = 0; i < languages.length; i++) {
                for(int idx = 0; idx < arr.length; idx++) {
                    if(arr[idx].equals(languages[i]))
                        sum += preference[i] * (arr.length - idx);
                }
            }
            
            if(result < sum || (sum == result && answer.compareTo(arr[0]) > 0)) {
                result = sum;
                answer = arr[0];
            }
        }
        return answer;
    }
}