import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int common = 0;
        ArrayList<String> list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);
            if(str.matches("^[a-zA-Z]*$")) 
                list1.add(str);
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);
            if(str.matches("^[a-zA-Z]*$")) 
                list2.add(str);
        }
  
        int union = list1.size() + list2.size();
        
        for(String s : list1) {
            if(list2.remove(s))
                common++;
        }
        
        if(union - common == 0) 
            return 65536;
        
        return common * 65536 / (union - common);
    }
}