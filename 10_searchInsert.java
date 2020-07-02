public int searchInsert(int[] nums, int target) 
{
	if(nums.length == 0)
		return 0;
	
	int mid = 0, l = 0, r = nums.length-1;
	
	while(l<=r)
	{
		mid = l + ((r-l)/2);
		
		if(nums[mid] == target)
			return mid;
		
		if(nums[mid] < target)
			l = mid + 1;
		else if(nums[mid] > target)
			r = mid - 1;
	}
	
	return l;
}