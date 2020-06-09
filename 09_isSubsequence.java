public boolean isSubsequence(String s, String t) 
{
	int i=0, j = 0;
	
	if(s.equals(t))
		return true;

	for(i=0; i<t.length() && j<s.length(); i++)
	{
		if(t.charAt(i) == s.charAt(j))
			j++;
	}
	
	if(j == s.length())
		return true;
	
	return false;
}