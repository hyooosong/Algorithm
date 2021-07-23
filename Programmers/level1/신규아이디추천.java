class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase()
            .replaceAll("[^0-9a-z_.-]", "")
            .replaceAll("[.]{2,}", ".")
            .replaceAll("^[.]|[.]$", "");
        
        new_id = new_id.isEmpty() ? "aaa" : new_id;
        
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15)
                .replaceAll("[.]$", "");
        } else if(new_id.length() <= 2) {
            while(new_id.length() < 3) 
                new_id += new_id.charAt(new_id.length() -1);
        }
        return new_id;
    }
}