class Solution {
    int[] dr={-1,0,+1,0};
    int[] dc={0,+1,0,-1};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }
            if(board[m-1][i]=='O'){
                dfs(m-1,i,board);
            }
        }
        for(int j=0;j<m;j++){
            if(board[j][0]=='O'){
                dfs(j,0,board);
            }
            if(board[j][n-1]=='O'){
                dfs(j,n-1,board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    public void dfs(int r,int c,char[][] board){
        int m=board.length;
        int n=board[0].length;
        board[r][c]='#';
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr< m && nc>=0 && nc<n && board[nr][nc]=='O'){
                dfs(nr,nc,board);
            }
        }
    }
}