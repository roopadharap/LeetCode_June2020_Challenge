class Solution {
    
    class TrieNode 
    {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode tr = root;
            for (char c : w.toCharArray()) 
            {
                int i = c - 'a';
                
                if (tr.next[i] == null) 
                    tr.next[i] = new TrieNode();
                tr = tr.next[i];
            }
            tr.word = w;
        }
        
        return root;
    }
    
    public void search(char[][] board, int i, int j, TrieNode tr, List<String> lst) 
    {
        char c = board[i][j];
        if (c == '-' || tr.next[c - 'a'] == null) 
            return;
        
        tr = tr.next[c - 'a'];
        
        if (tr.word != null) 
        {
            lst.add(tr.word);
            tr.word = null;     
        }
        
        board[i][j] = '-';
        
        if (i > 0) 
            search(board, i - 1, j ,tr, lst); 
        
        if (j > 0) 
            search(board, i, j - 1, tr, lst);
        
        if (i < board.length - 1) 
            search(board, i + 1, j, tr, lst); 
        
        if (j < board[0].length - 1) 
            search(board, i, j + 1, tr, lst); 
        
        board[i][j] = c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> lst = new ArrayList<>();
        
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) 
        {
            for (int j = 0; j < board[0].length; j++) 
            {
                search(board, i, j, root, lst);
            }
        }
        return lst;
         
    }
}