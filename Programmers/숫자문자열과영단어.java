import java.util.HashMap;

class Solution {
    public int solution(String s) {
        HashMap<String, String> hm = new HashMap<>() {{
            put("zero", "0");
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
        }};
        
        for(String eng : hm.keySet()) {
            if(s.contains(eng)) {
                s = s.replace(eng, hm.get(eng));
            }
        }
        return Integer.parseInt(s);
    }
}