/**
	 * Class Name:	NoZero	
	 * Purpose:		customized Exception to validate
	 * 				
	 * Coder:		Mahan Mehdipour	
	 * Date:		April 9, 2020	
*/
public class NoZero extends Exception{

	NoZero()
	{
		super("You should not add zero as the first digit for your loans!");
	}
}
