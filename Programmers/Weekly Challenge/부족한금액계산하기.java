class Solution {
    public long solution(int price, int money, int count) {
        long total = (long) price * count * (count + 1) / 2L;
        return total > money ? total - money : 0;
    }
}