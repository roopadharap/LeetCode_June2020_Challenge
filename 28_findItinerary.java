class Solution {
    HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
    LinkedList<String> lst = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> temp : tickets)
        {
            String src = temp.get(0);
            String dest = temp.get(1);
            
            if(!hm.containsKey(src))
                hm.put(src, new PriorityQueue<>());
            
            hm.get(src).add(dest);
        }
        
        fillList("JFK");
        
        return lst;
    }
    
    void fillList(String str)
    {
        PriorityQueue<String> pq = hm.get(str);
        
        while(pq != null && !pq.isEmpty())
        {
            fillList(pq.poll());
        }
        
        lst.addFirst(str);
    }
}