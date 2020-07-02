public int calculateMinimumHP(int[][] dungeon) 
{
	int M = dungeon.length;
	int N = dungeon[0].length;
	int [][] arr = new int [M][N];
	
	for(int i=M-1; i>=0; i--)
	{
		for(int j=N-1; j>=0; j--)
		{
			if(i == M-1 && j == N-1)
				arr[i][j] = Math.max(1, 1-dungeon[i][j]);
			else if(i == M-1)
				arr[i][j] = Math.max(1, arr[i][j+1] - dungeon[i][j]);
			else if(j == N-1)
				arr[i][j] = Math.max(1, arr[i+1][j] - dungeon[i][j]);
			else
				arr[i][j] = Math.min(Math.max(1, arr[i][j+1] - dungeon[i][j]), Math.max(1, arr[i+1][j] - dungeon[i][j]));
		}
	}
	
	return arr[0][0];
}