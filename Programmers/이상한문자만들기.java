import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] div = s.split(" ", -1);
        
       for(int i = 0; i < div.length; i++) {
           if(i != 0) {
               answer.append(" ");
           }
           
           for(int j = 0; j < div[i].length(); j++) {
               if(j % 2 == 0) {
                   answer.append(
                       Character.toString(div[i].charAt(j)).toUpperCase());
               } else {
                   answer.append(
                       Character.toString(div[i].charAt(j)).toLowerCase());
               }
           }
       }
        return answer.toString();
    }
}