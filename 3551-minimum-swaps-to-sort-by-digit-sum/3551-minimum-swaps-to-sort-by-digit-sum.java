
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Step 1: Store digit sum and number
        for (int i = 0; i < n; i++) {
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
        }

        // Step 2: Sort by digit sum, then by value
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // Step 3: Map each number to its target index
        Map<Integer, Integer> targetIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetIndex.put(arr[i][1], i);
        }

        // Step 4: Count cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int current = i;
            int cycleSize = 0;

            while (!visited[current]) {
                visited[current] = true;

                int num = nums[current];
                current = targetIndex.get(num);

                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
