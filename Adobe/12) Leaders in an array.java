/*
    https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/#
*/

class Solution {
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = -1;
        for (int i = n - 1; i > -1; i--) {
            if (arr[i] >= max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        for (int i = 0, j = ans.size() - 1; i < j; i++, j--) {
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
        }
        return ans;
    }
}
