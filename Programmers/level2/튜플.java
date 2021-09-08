import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.replace("{", "").replace("}}", "").split("},");
        int[] answer = new int[arr.length];
        int idx = 0;
        
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        answer[idx++] = Integer.parseInt(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            for(String str : arr[i].split(",")) {
                int num = Integer.parseInt(str);
                if(!IntStream.of(answer).anyMatch(x -> x == num))
                    answer[idx++] = num;
            }
        }

        return answer;
    }
}