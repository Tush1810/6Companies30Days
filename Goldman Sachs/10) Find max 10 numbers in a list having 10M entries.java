import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n < 10) return;

        int[] max = findMax(arr, n);
        for (int i = 0; i < 10; i++) {
            System.out.println(max[i]);
        }
    }

    public static int[] findMax(int[] arr, int n) {
        int[] ans = new int[10];
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            for (int j = 0; j < 10; j++) {
                if (num > ans[j]) {
                    for (int q = 9; q > j; q--) {
                        ans[q] = ans[q - 1];
                    }
                    ans[j] = num;
                    break;
                }
            }
        }
        return ans;
    }
}
