import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();
        System.out.println(check(s1, s2));
    }
    public static String check(String s1, String s2) {
        String[] temp1 = s1.split("\\.");
        String[] temp2 = s2.split("\\.");
        int i = 0;
        for (i = 0; i < Math.min(temp1.length, temp2.length); i++) {
            if (Integer.parseInt(temp1[i]) == Integer.parseInt(temp2[i])) continue;
            if (Integer.parseInt(temp1[i]) < Integer.parseInt(temp2[i])) {
                return s2;
            } else return s1;
        }
        if (temp1.length < temp2.length) return s2;
        return s1;
    }
}
