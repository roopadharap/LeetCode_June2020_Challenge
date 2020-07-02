class RandomizedSet {
    HashMap<Integer,Integer> hm;
    ArrayList<Integer> alist;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap<Integer,Integer>();
        alist = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val))
            return false;
        
        int pos = alist.size();
        alist.add(val);
        
        hm.put(val,pos);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hm.containsKey(val))
            return false;
        
        Integer pos = hm.get(val);
        Collections.swap(alist, pos, alist.size()-1);
        
        hm.put(alist.get(pos), pos);
        
        alist.remove(alist.size()-1);
        hm.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int i = r.nextInt(alist.size());
        
        return alist.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */