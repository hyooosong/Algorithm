import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> list = new ArrayList();
        HashMap<String, Integer> album = new HashMap();
        
        for(int i = 0; i < genres.length; i++) {
            String music = genres[i];
            album.put(music, album.getOrDefault(music, 0) + plays[i]);
        }
        
        ArrayList<String> genreList = new ArrayList(album.keySet());
        Collections.sort(genreList, (v1, v2) -> album.get(v2).compareTo(album.get(v1)));
        
        for(String key : genreList) {
            HashMap<Integer, Integer> best = new HashMap();
            
            for(int i = 0; i < genres.length; i++) {
                if(key.equals(genres[i])) 
                    best.put(i, plays[i]);
            }
            
            ArrayList<Integer> keyList = new ArrayList(best.keySet());
        
            if(keyList.size() == 1) 
                list.add(keyList.get(0));
            else {
                Collections.sort(keyList, (v1, v2) -> best.get(v2) - best.get(v1));
                list.add(keyList.get(0));
                list.add(keyList.get(1));
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer; 
    }
}