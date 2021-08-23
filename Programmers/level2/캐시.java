import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList(cacheSize);
        
        for(int i = 0; i < cities.length; i++) {
            if(cacheSize == 0) 
                return cities.length * 5;
            
            String city = cities[i].toLowerCase();
            
            if(list.contains(city)) {
                list.remove(list.indexOf(city));
                answer++;
            } else {
                if(list.size() >= cacheSize) 
                    list.remove(0);
                answer += 5;
            }
            
            list.add(city);
            }
            
        return answer;
    }
}