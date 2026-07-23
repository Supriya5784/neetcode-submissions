class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left =0;
        int right =0;
        int maxLen =0;
        int n = s.length();
        while(right<n){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            int currLen = right-left+1;
            maxLen = Math.max(maxLen,currLen);
            right++;
        }
        return maxLen;
        
    }
}
