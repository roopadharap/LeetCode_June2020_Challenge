public String getPermutation(int n, int k) 
{
	int [] arr = new int [n];
	StringBuilder s = new StringBuilder();
	ArrayList<Integer> alist = new ArrayList<Integer>();
	int remNum;
	
	for(int i = 0; i<n ; i++)
	{
		alist.add(i+1);
		if(i == 0)
			arr[i] = 1;
		else
			arr[i] = i * arr[i-1];
	}
	
	while(n > 0)
	{
		remNum = ((k-1) % arr[n-1]) + 1;
		s.append(alist.remove(((k-1) / arr[n-1])));
		n--;
		k = remNum;
	}
	
	return s.toString();
}