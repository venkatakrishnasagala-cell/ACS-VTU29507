import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            int n = s.length();
            int[] freq = new int[26];

            for (int i = 0; i < n / 2; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            int start = (n + 1) / 2;
            for (int i = start; i < n; i++) {
                freq[s.charAt(i) - 'a']--;
            }

            boolean ok = true;
            for (int x : freq) {
                if (x != 0) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
