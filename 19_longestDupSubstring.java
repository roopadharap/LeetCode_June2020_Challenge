class Solution {
    public String longestDupSubstring(String S) {
        int len = S.length();
        int l = 0, r = len, mid;
        
        int [] arr = new int [len];
        
        for(int i = 0; i < len; i++)
        {
            arr[i] = (int)S.charAt(i) - (int)'a';
        }
        
        long md = (long)Math.pow(2,32);
        
        while(l != r)
        {
            mid = l + (r-l)/2;
            
            if(find(arr, len, mid, md, 26) != -1)
                l = mid + 1;
            else
                r = mid;
        }
        
        int pos = find(arr, len, l-1, md, 26);
        
        if(pos != -1)
            return S.substring(pos, pos+l-1);
        else
            return "";
    }
    
    public int find(int [] arr, int len, int mid, long md, int chrA)
    {
        long hVal = 0;
        long aLong  =1;
        
        for(int i = 0; i<mid; i++)
        {
            hVal = (hVal * chrA + arr[i]) % md;
        }
        
        HashSet<Long> hs = new HashSet();
        
        hs.add(hVal);
        
        for(int i = 1; i<= mid; i++)
        {
            aLong = (aLong * chrA) % md;
        }
        
        for(int pos = 1; pos < len - mid + 1; pos++) 
        {
            hVal = (hVal * chrA - arr[pos - 1] * aLong % md + md) % md;
            hVal = (hVal + arr[pos + mid - 1]) % md;
            
            if (hs.contains(hVal)) 
                return pos;
            
            hs.add(hVal);
         }
        
         return -1;
        
    }
    
}