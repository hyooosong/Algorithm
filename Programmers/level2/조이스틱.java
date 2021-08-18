class Solution {
    public int solution(String name) {
        int answer = 0;
        int lenStr = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
            int num = (int) name.charAt(i);
            
            if(num - 'A' > 'Z' - num + 1) 
                answer += 'Z' - num + 1;
            else
                answer += num - 'A';
            
            int idxA = i + 1;
            
            while(idxA < lenStr && name.charAt(idxA) == 'A') {
                idxA++;
            }
            lenStr = Math.min(lenStr, i * 2 + name.length() - idxA);
        }
        return answer + lenStr;
    }
}