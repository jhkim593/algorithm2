import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (t[i] + i <= n) {
                dp[t[i] + i] = Math.max(dp[t[i] + i], dp[i] + p[i]);
            }
            if (i + 1 <= n)
                dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.print(dp[n]);

    }
}
