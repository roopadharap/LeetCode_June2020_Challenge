class Solution {
    static int r, c;
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) 
            return ;
     
        r = board.length;
        c = board[0].length;
        
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                if (board[i][j] == 'O') 
                    board[i][j] = '-'; 
            }
        }
      
        for (int i = 0; i < r; i++)
        {
            if (board[i][0] == '-') 
                dfsFill(board, i, 0,'-', 'O'); 
        }
        
        for (int i = 0; i < r; i++)
        {
            if (board[i][c - 1] == '-') 
                dfsFill(board, i, c - 1,'-', 'O'); 
        }
        for (int i = 0; i < c; i++) 
        {
            if (board[0][i] == '-') 
                dfsFill(board, 0, i,'-', 'O'); 
        }
        for (int i = 0; i < c; i++)
        {
            if (board[r - 1][i] == '-') 
                dfsFill(board, r - 1, i, '-', 'O'); 
        }
        
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                if (board[i][j] == '-') 
                    board[i][j] = 'X'; 
            }
        }
    }
    
    static void dfsFill(char board[][], int x, int y, char orgChar, char newChar) 
    { 
        if (x < 0 || x >= r || y < 0 || y >= c) 
            return; 
              
        if (board[x][y] != orgChar) 
            return; 
      
        board[x][y] = newChar; 
      
        dfsFill(board, x + 1, y, orgChar, newChar); 
        dfsFill(board, x - 1, y, orgChar, newChar); 
        dfsFill(board, x, y + 1, orgChar, newChar); 
        dfsFill(board, x, y - 1, orgChar, newChar); 
    } 
    
    
}