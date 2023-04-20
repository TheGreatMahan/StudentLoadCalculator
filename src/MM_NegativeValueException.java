/**
	 * Class Name:	MM_NegativeValueException	
	 * Purpose:		customized Exception to validate
	 * 				
	 * Coder:		Mahan Mehdipour	
	 * Date:		April 9, 2020	
*/


public class MM_NegativeValueException extends Exception{
	
	MM_NegativeValueException(){
		super("The value entered as Student ID doesn't have seven characters!");

	}

}
