/**
	 * Class Name:	MM_LoanPayable	
	 * Purpose:		An interface that is being used by implemented classes
	 * 				
	 * Coder:		Mahan Mehdipour	
	 * Date:		April 9, 2020	
*/
public interface MM_LoanPayable
{
	double ANNUAL_RATE_TO_MONTHLY_RATE=1.0/1200;
	
	
	public double calculateLoanPayment(double oslOrCsl, double anualPrimeInterest,int amorization); 

}
