public String validIPAddress(String IP) 
{
	if(IP.length() == 0)
		return "Neither";
	
	boolean isIP4 = false, isIP6 = false;
	
	if(IP.contains(".") && !IP.contains(":"))
		isIP4 = true;
	else if(!IP.contains(".") && IP.contains(":"))
		isIP6 = true;
	else
		return "Neither";
	
	String [] arr;

	
	if(isIP4)
	{
		if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.')
			return "Neither";
		
		arr = IP.split("\\.");
		
		if(arr.length != 4)
			return "Neither";
		
		for(int i=0; i<arr.length; i++)
		{
			String curr = arr[i];
			//check length
			if(curr.length() == 0 || curr.length() > 3)
				return "Neither";
			
			//check different character
			for(int j=0; j<curr.length(); j++)
			{
				if(curr.charAt(j) < '0' || curr.charAt(j) > '9')
					return "Neither";
			}
			
			//check range
			int tmp = Integer.parseInt(curr);
			if(tmp < 0 || tmp > 255)
				return "Neither";
			
			//check leading zero
			if(!curr.equals(String.valueOf(tmp)))
				return "Neither";
		}
		
		return "IPv4";
	}
	else if(isIP6)
	{
		if(IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':')
			return "Neither";
		
		arr = IP.split(":");
		
		if(arr.length == 0)
		{
			return "Neither";
		}
		else
		{
			//validate IP6
			
			//validate 8 numbers present
		if(arr.length != 8)
			return "Neither";
		
		for(int i=0; i<arr.length; i++)
		{
			String curr = arr[i];
			
			//check length
			if(curr.length() == 0 || curr.length() > 4)
				return "Neither";
			
		   //check different character
			for(int j=0; j<curr.length(); j++)
			{
				if(!((curr.charAt(j) >= '0' && curr.charAt(j) <= '9') || (curr.charAt(j) >= 'a' && curr.charAt(j) <= 'f') || (curr.charAt(j) >= 'A' && curr.charAt(j) <= 'F')))
						return "Neither";
			}
		}
		
		return "IPv6";
		}
	}
	
	return "Neither";
}