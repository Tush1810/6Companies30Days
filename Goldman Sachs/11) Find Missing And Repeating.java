/*
    https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/#
*/

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int i = 0, a = -1, b = -1;
        for (i = 0; i < n; i++) {
            arr[i]--;
        }
        for (i = 0; i < n; i++) {
            if (arr[i] == i) continue;
            int temp = i, j = arr[i];
            while (arr[j] != j && arr[i] != i) {
                swap(arr, i, j);
                j = arr[i];
            }
            if (arr[i] != i) {
                b = j;
                break;
            }
        }

        arr[b] = -1;
        long sum = 0;
        for (i = 0; i < n; i++) {
            sum += arr[i] + 1;
        }
        long temp = n;
        temp = temp * (n + 1);
        temp /= 2;
        a = (int)(temp - sum);
        b++;
        return new int[] {b, a};
    }

    public void swap(int arr[], int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
