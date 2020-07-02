public List<Integer> largestDivisibleSubset(int[] nums) 
{
	List<Integer> lst = new ArrayList<Integer>();
	int [] arr = new int [nums.length];
	int max = 1;
	int i;
	
	if(nums == null)
		return lst;
	if(nums.length == 0)
		return lst;
	
	Arrays.sort(nums);
	
	for(i=0; i<nums.length; i++)
	{
		arr[i] = 1;
		for(int j = 0; j<i; j++)
		{
			if(nums[i] % nums[j] == 0)
			{
				arr[i] = Math.max(arr[i], arr[j]+1);
				max = Math.max(max, arr[i]);
			}
		}
	}
	
	i = nums.length - 1;
	while (i >= 0 && arr[i] != max) {
		i--;
	}
	 
	lst.add(nums[i]);
	
	i--;
	max--;
	 
	while (i >= 0) 
	{
		if ((lst.get(lst.size() - 1) % nums[i]) == 0 && arr[i] == max) 
		{
			lst.add(nums[i]);
			max--;
		}
		
		i--;
	}
	
	return lst;
}