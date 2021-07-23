import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % 5]) {
                count[0]++;
            }
            if(answers[i] == two[i % 8]) {
                count[1]++;
            }
            if(answers[i] == three[i % 10]) {
                count[2]++;
            }
        }
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        
        for(int j = 0; j < count.length; j++) {
            if(max == count[j]) {
                answer.add(j + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}