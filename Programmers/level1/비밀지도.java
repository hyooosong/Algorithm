class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            String result = Integer.toBinaryString(arr1[i]|arr2[i]);
            
            answer[i] = numLength(result, n).replace("0", " ")
                            .replace("1", "#");
        }
        return answer;
    }
    
    public String numLength(String s, int size) {
        StringBuilder sb = new StringBuilder(s);
        if(sb.length() != size) {
            while(sb.length() < size)
                sb.insert(0, 0);
        }
        return sb.toString();
    }
}