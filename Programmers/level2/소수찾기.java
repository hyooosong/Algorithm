import java.util.ArrayList;

class Solution {
    ArrayList<Integer> list = new ArrayList();
    boolean[] visit = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;
        String temp = "";
        
        for(int i = 1; i < numbers.length() + 1; i++) {
            makeNum(numbers, temp, i);
        }
        
        for(int num : list) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) 
                return false;
        }
        return true;
    }
    
    public void makeNum(String numbers, String temp, int len) {
        if(temp.length() == len) {
            int number = Integer.parseInt(temp);
            if(!list.contains(number))
                list.add(number);
            return;
        }
         
        for(int i = 0; i < numbers.length(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                temp += numbers.charAt(i);
                makeNum(numbers, temp, len);
                visit[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }
}