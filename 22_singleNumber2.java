public int singleNumber(int[] nums) 
{
	int ob = 0, nb = 0;
	
	for(int i=0; i<nums.length; i++)
	{
		ob = ~nb & (ob ^ nums[i]);
		nb = ~ob & (nb ^ nums[i]);
	}
	
	return ob;
}