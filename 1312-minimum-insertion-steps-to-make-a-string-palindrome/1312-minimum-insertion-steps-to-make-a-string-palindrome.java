class Solution {
    public int minInsertions(String s) {
        String t=new StringBuilder(s).reverse().toString();
        int lps=lcs(s,t);
        return s.length()-lps;
        
    }
    public int f(int i,int j,String s, String t,int[][]dp){
        if(i<0 ||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j] ;
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=1+f(i-1,j-1,s,t,dp);
        }
        return dp[i][j]=Math.max(f(i-1,j,s,t,dp),f(i,j-1,s,t,dp));
    }
    public int lcs(String s,String t){
        int m=s.length();
        int n=t.length();
        int[][]dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,s,t,dp);
    }
}