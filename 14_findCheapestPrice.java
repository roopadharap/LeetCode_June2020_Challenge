public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) 
{
	int [] arr = new int [n];
	int [] tmp;
	int u, v, wt;
	Arrays.fill(arr, Integer.MAX_VALUE);
	
	arr[src] = 0;
	
	for(int i=0; i<=K; i++)
	{
		tmp = Arrays.copyOf(arr, arr.length);
		
		for(int [] e : flights)
		{
			u = e[0];
			v = e[1];
			wt = e[2];
			
			if(arr[u] == Integer.MAX_VALUE)
				continue;
			
			tmp[v] = Math.min(tmp[v], arr[u] + wt);
		}
		
		arr = tmp;
	}
	
	if(arr[dst] != Integer.MAX_VALUE)
		return arr[dst];
	
	
	return -1;
}