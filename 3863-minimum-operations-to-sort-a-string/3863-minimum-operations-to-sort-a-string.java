class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Case 0: If the string is already sorted, 0 operations needed
        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            return 0;
        }
        
        // Case 1: If length is 2 and it's not sorted, it's impossible
        if (n == 2) {
            return -1;
        }
        
        char mn = s.charAt(0);
        char mx = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }
        
        // Case 2: If the smallest is at the start OR the largest is at the end
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        
        // Case 3: If the min or max is anywhere in the interior/middle
        boolean hasInteriorMinMax = false;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                hasInteriorMinMax = true;
                break;
            }
        }
        if (hasInteriorMinMax) {
            return 2;
        }
        
        // Case 4: Otherwise, it takes at most 3 operations
        return 3;
    }
}
