import java.util.*;

public class Task55_FindTownJudge {
    public static int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] relation : trust) {
            score[relation[0]]--;
            score[relation[1]]++;
        }

        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) return person;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] trust = new int[m][2];
        for (int i = 0; i < m; i++) {
            trust[i][0] = sc.nextInt();
            trust[i][1] = sc.nextInt();
        }
        System.out.println(findJudge(n, trust));
        sc.close();
    }
}
