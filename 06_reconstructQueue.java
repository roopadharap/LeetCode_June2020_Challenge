public int[][] reconstructQueue(int[][] people) 
{
	int [][] res = new int[people.length][];
	List<int[]> lst = new ArrayList<int[]>();
	
	Arrays.sort(people, new Comparator<int[]>()
	{
		public int compare(int [] a, int [] b)
		{
			if(a[0] != b[0])
				return b[0] - a[0];
			else
				return a[1] - b[1];
		}
	});
	
	for(int i =0; i<people.length; i++)
	{
		lst.add(people[i][1], people[i]);
	}
	
	for(int i=0; i<people.length; i++)
	{
		res[i] = lst.get(i);
	}
	
	return res;
}