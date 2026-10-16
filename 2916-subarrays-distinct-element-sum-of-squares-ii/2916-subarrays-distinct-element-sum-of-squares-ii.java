
import java.util.Arrays;

class Solution {
    static final long MOD = 1000000007L;

    long[] sum, square, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int previous = last[nums[i]];

            update(1, 0, n - 1, previous + 1, i);

            last[nums[i]] = i;
            ans = (ans + square[1]) % MOD;
        }

        return (int) ans;
    }

    void apply(int node, int left, int right, long value) {
        long length = right - left + 1L;

        square[node] = (square[node]
                + 2 * value * sum[node]
                + value * value % MOD * length) % MOD;

        sum[node] = (sum[node] + value * length) % MOD;
        lazy[node] = (lazy[node] + value) % MOD;
    }

    void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int left, int right,
                int ql, int qr) {
        if (left > qr || right < ql) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        square[node] =
                (square[node * 2] + square[node * 2 + 1]) % MOD;
    }
}
