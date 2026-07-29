class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] freq = new int[26];

        // Count characters of s1
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        // Remove first window
        for (int i = 0; i < s1.length(); i++) {
            freq[s2.charAt(i) - 'a']--;
        }

        if (allZero(freq))
            return true;

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {

            // Remove new character entering the window
            freq[s2.charAt(right) - 'a']--;

            // Add back character leaving the window
            freq[s2.charAt(left) - 'a']++;

            left++;

            if (allZero(freq))
                return true;
        }

        return false;
    }

    private boolean allZero(int[] freq) {
        for (int x : freq) {
            if (x != 0)
                return false;
        }
        return true;
    }
}