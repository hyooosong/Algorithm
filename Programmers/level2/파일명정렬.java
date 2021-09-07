import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String prev = o1.split("[0-9]")[0].toLowerCase();
                String next = o2.split("[0-9]")[0].toLowerCase();
                int result = prev.compareTo(next);
                
                StringBuilder s1 = new StringBuilder();
                s1.append(o1);
                s1.delete(0, prev.length());
                
                StringBuilder s2 = new StringBuilder();
                s2.append(o2);
                s2.delete(0, next.length());
                
                if(result == 0) {
                    return checkNum(s1.toString()) - checkNum(s2.toString());
                }
                
                return result;
            }
        });
        
        return files;
    }

    public int checkNum(String s) {
        String result = "";
        
        for(Character now : s.toCharArray()) {
            if(Character.isDigit(now) && result.length() < 5) 
                result += now;
            else 
                break;
        }
        
        return Integer.valueOf(result);
    }
}