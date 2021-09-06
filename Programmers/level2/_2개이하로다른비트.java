class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            String str = Long.toBinaryString(numbers[i]);
            StringBuilder sb = new StringBuilder();
            
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                if(str.contains("0")) {
                    int idx = str.lastIndexOf("0");
                    sb.append(str);
                    sb.setCharAt(idx, '1');
                    sb.setCharAt(idx + 1, '0');
                } else {
                    sb.append(str);
                    sb.insert(1, "0");
                }
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        return answer;
    }
}