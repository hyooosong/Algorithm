import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        ArrayList<Player> result = new ArrayList();
        int[] answer = new int[weights.length];

        for(int i = 0; i < head2head.length; i++) {
            int total = head2head[i].length();
            int win = 0;
            int heavy = 0;
            double rate = 0.0;
            
            for(int j = 0; j < head2head[i].length(); j++) {
                if(head2head[i].charAt(j) == 'W') {
                    win++;
                    if(weights[i] < weights[j]) heavy++;
                } else if(head2head[i].charAt(j) == 'N') {
                    total--;
                }
            }
            rate = total == 0 ? 0.0 : (double) win / total;
            
            Player player = new Player(i + 1, weights[i], rate, heavy);
            result.add(player);
        }
        
        Collections.sort(result, new Comparator<Player>() {
           public int compare(Player o1, Player o2) {
                if(o1.rate > o2.rate) return -1;
                else if(o1.rate < o2.rate) return 1;
                else {
                    if(o1.heavy != o2.heavy) 
                        return o2.heavy - o1.heavy;
                    else {
                        if(o1.weight != o2.weight) 
                            return o2.weight - o1.weight;
                        else 
                            return o1.num - o2.num;
                   }
               }
           }
        });
        
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).num;
        }
        
        return answer;
    }
}

class Player{
    int num;
    int weight;
    double rate;
    int heavy;
    
    public Player(int num, int weight, double rate, int heavy) {
        this.num = num;
        this.weight = weight;
        this.rate = rate;
        this.heavy = heavy;
    }
    
}