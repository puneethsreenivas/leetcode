class Solution {
    public int strStr(String haystack, String needle) {
        StringBuilder sb=new StringBuilder();
        sb.append(haystack);
        int x=sb.indexOf(needle);
        return x;
        
    }
}