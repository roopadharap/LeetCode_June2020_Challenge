public int numSquares(int n) 
{
	int [] arr = new int[n+1];
	
	int sq, min;
	
	for(int i = 1; i<= n; i++)
	{
		sq = (int)Math.sqrt(i);
		
		min = arr[i-1];
		
		for(int j=sq; j > 0; j--)
		{
			min = Math.min(arr[i-(j*j)], min);
		}
		
		arr[i] = min + 1;
	}
	
	return arr[n];
}