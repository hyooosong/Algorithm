class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'p' : pCount++; break;
                case 'P' : pCount++; break;
                case 'y' : yCount++; break;
                case 'Y' : yCount++; break;
            }  
        }
        
        return pCount == yCount;
    }
}