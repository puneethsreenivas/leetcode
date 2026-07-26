class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       
        int[][] ans=image;
        int org=image[sr][sc];
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        helper(image,sr,sc,ans,drow,dcol,org,color);
        return ans;

        
    }
    public void helper(int[][] image,int row,int col,int[][] ans,int[] drow,int[] dcol,int org,int color){
         int n=image.length;
        int m=image[0].length;
     ans[row][col]=color;
      
     for(int i=0;i<4;i++){
        int nrow=row+drow[i];
        int ncol=col+dcol[i];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==org && ans[nrow][ncol]!=color){
            helper(image,nrow,ncol,ans,drow,dcol,org,color);
        }
     }
    }
}