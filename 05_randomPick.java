class Solution {
    Random randNo;
    int [] wtRange;
    int totWt = 0;
    
    public Solution(int[] w) {
        wtRange = new int[w.length];
        randNo = new Random();
        
        for(int i = 0; i<w.length; i++)
        {
            totWt = totWt + w[i];
            wtRange[i] = totWt;
        }
    }
    
    public int pickIndex() {
        int selNum = randNo.nextInt(totWt) + 1;
        int l = 0, r = wtRange.length - 1;
        
        while(l <= r)
        {
            int m = l + ((r-l)/2);
            
            if(wtRange[m] == selNum)
                return m;
            else if (wtRange[m] > selNum)
                r = m - 1;
            else
                l = m + 1;
        }
        
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */