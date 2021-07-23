class Solution {
    public String solution(String phone_number) {
        StringBuffer answer = new StringBuffer(phone_number);
        
        for(int i=0; i<phone_number.length()-4; i++) {
            answer.setCharAt(i,'*');
        }
        return answer.toString();
    }
}