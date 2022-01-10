import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> map = new HashMap();
        for(String name: enroll) {
            map.put(name, new Person(name, null, 0));
        }
        
        for(int i = 0; i < enroll.length; i++) {
            if(referral[i].equals("-")) continue;
            map.get(enroll[i]).parent = map.get(referral[i]);    
        }
        
        for(int i = 0; i < seller.length; i++) {
            map.get(seller[i]).calcProfit(amount[i] * 100);
        }
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).profit;
        }
        
        return answer;
    }

    class Person {
        String name;
        Person parent;
        int profit;
        
        public Person(String name, Person parent, int profit) {
            this.name = name;
            this.parent = parent;
            this.profit = profit;
        }
        
        public void calcProfit(int profit) {
            int parentProfit = profit / 10;
            this.profit += profit - parentProfit;
            if(this.parent != null && parentProfit > 0)
                this.parent.calcProfit(parentProfit);
        }
    }
}