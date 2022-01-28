/*
    https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/submissions/
*/

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2)-> {
            if (o2.length() == o1.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) - '0' < o2.charAt(i) - '0') {
                        return 1;
                    } else if (o1.charAt(i) - '0' > o2.charAt(i) - '0') {
                        return -1;
                    }
                }
                return 0;
            }
            return o2.length() - o1.length();
        });
        return nums[k - 1];
    }
}
