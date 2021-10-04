class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max_time = 0;
        
        for(String s : musicinfos) {
            String[] arr = s.split(",");
            int start_min = Integer.parseInt(arr[0].substring(3));
            int end_min = Integer.parseInt(arr[1].substring(3));
            int end_hour = Integer.parseInt(arr[1].substring(0, 2));
            int start_hour = Integer.parseInt(arr[0].substring(0, 2));
            
            int time = (end_hour - start_hour) * 60 + (end_min - start_min);
            
            StringBuilder melody = new StringBuilder();
            arr[3] = changeMelody(arr[3]);
            int cnt = arr[3].length();
            
            for(int i = 0; i < time; i++) {
                melody.append(arr[3].charAt(i % cnt));
            }
            
            if(changeMelody(melody.toString()).contains(changeMelody(m))) {
                if(time > max_time) {
                    answer = arr[2];
                    max_time = time;
                }
            }
        }
        
        return answer;
    }
    
    public String changeMelody(String m) {
        m = m.replaceAll("A#", "a")
            .replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g");
        
        return m;
    }
}