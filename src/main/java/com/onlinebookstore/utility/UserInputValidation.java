package com.onlinebookstore.utility;

public class UserInputValidation {
	
	public static boolean checkString(Object obj)
	{
		if(obj.getClass().getName().equals("java.lang.String"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	

}
