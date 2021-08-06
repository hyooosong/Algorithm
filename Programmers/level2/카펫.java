class Solution {
    public int[] solution(int brown, int yellow) {
        for (int w = 1; w <= yellow; w++) {
            int h = yellow / w;
            if(yellow % w == 0 && 2 * (w + h) + 4 == brown) {
                if(w >= h) return new int[]{w + 2, h + 2};
                else return new int[]{h + 2, w + 2};
            }
        }
        return new int[0];
    }
}