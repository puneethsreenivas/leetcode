class Solution {
     class Node{
        int first;
        int second;
        int third;
       public  Node(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int [][] vis=new int[n][m];
        int [][] dis=new int[n][m];
        Queue<Node>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.offer(new Node(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,+1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int ans=q.peek().third;
            q.remove();
            dis[row][col]=ans;
            for(int i=0;i<4;i++){
              int  nrow=row+delrow[i];
               int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n &&ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow,ncol,ans+1));
                }
            }

        }
        return dis;
    }
}