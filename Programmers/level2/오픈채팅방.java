import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList();
        HashMap<String, String> hm = new HashMap();

        for(int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
         
            if(arr.length == 3) 
                hm.put(arr[1], arr[2]);
            
            switch(arr[0]) {
                case "Leave" :
                    list.add(arr[1] + "���� �������ϴ�.");
                    break;
                case "Enter" :
                    list.add(arr[1] + "���� ���Խ��ϴ�.");
                    break;
            }
        }
        
        String[] answer = new String[list.size()];
        int count = 0;
        
        for(String s : list) {
            int endNick = s.indexOf("��");
            String uid = s.substring(0, endNick);
            answer[count] = s.replace(uid, hm.get(uid));
            count++;
        }

        return answer;
    }
}