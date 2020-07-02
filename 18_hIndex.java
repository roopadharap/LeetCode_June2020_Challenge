public int hIndex(int[] citations) 
{
	int len = citations.length;
	int l = 0, r = len - 1, mid;
	
	if(citations.length == 0)
		return 0;
	
	
	while(l <= r)
	{
		mid = (l+r)/2;
		
		if(citations[mid] < (len - mid))
			l = mid + 1;
		else
			r = mid - 1;
	}
	
   return len - l;
}