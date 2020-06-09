public int twoCitySchedCost(int[][] costs) 
{
	int [] arr = new int [costs.length];
	int tot = 0;
	
	for(int i =0; i < costs.length; i++)
	{
		tot = tot + costs[i][0];
		arr[i] = costs[i][1] - costs[i][0];
	}
	
	Arrays.sort(arr);
	
	for(int i=0; i < arr.length/2; i++)
		tot = tot + arr[i];
	
	return tot;
}