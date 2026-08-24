import java.io.*;
import java.util.*;

public class Main {
    static void rotateLayer(int[][] a, int r1, int c1, int r2, int c2, int k) {
        ArrayList<Integer> values = new ArrayList<>();

        for (int j = c1; j <= c2; j++) values.add(a[r1][j]);
        for (int i = r1 + 1; i <= r2; i++) values.add(a[i][c2]);
        for (int j = c2 - 1; j >= c1; j--) values.add(a[r2][j]);
        for (int i = r2 - 1; i > r1; i--) values.add(a[i][c1]);

        int len = values.size();
        k %= len;

        int idx = 0;

        for (int j = c1; j <= c2; j++) a[r1][j] = values.get((idx++ + k) % len);
        for (int i = r1 + 1; i <= r2; i++) a[i][c2] = values.get((idx++ + k) % len);
        for (int j = c2 - 1; j >= c1; j--) a[r2][j] = values.get((idx++ + k) % len);
        for (int i = r2 - 1; i > r1; i--) a[i][c1] = values.get((idx++ + k) % len);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            rotateLayer(a, layer, layer, m - 1 - layer, n - 1 - layer, r);
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) out.append(' ');
                out.append(a[i][j]);
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}
