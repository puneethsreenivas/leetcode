class Solution {
    class Node{
        int first;
        int second;
        int third;
        public Node(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Node>q=new LinkedList<>();
        int tcnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.offer(new Node(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    tcnt++;
                }
            }
        }
        int mtm=0;
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int tm=q.peek().third;
            q.remove();
            mtm=Math.max(tm,mtm);
            
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.offer(new Node(nrow,ncol,tm+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=tcnt){
            return -1;
        }
        return mtm;


    }
}