class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1;
        int high = max;
        int ans = max;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;   // ceiling division
            }

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}