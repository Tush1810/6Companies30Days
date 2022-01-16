/*
    https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1#
*/

class Solution {
    private ArrayList<ArrayList<Integer>> ans;

    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            while (i < n - 3 && i != 0 && arr[i] == arr[i - 1]) { i++;}
            if (i == n - 3) break;
            for (int j = i + 1; j < n - 2; j++) {
                while (j < n - 2 && j != i + 1 && arr[j] == arr[j - 1]) { j++;}
                if (j == n - 2) break;
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    if (arr[left] + arr[right] + arr[i] + arr[j] == k) {
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[left]);
                        temp.add(arr[right]);
                        ans.add(temp);
                        temp = new ArrayList<>();

                        left++;
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        right--;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (arr[left] + arr[right] + arr[i] + arr[j] < k) {
                        left++;
                    } else if (arr[left] + arr[right] + arr[i] + arr[j] > k) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
