// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		//delete before push
		System.out.println(endBalance(loan, rate, n, 10000));
		System.out.println(bruteForceSolver(loan, rate, n, epsilon));
		System.out.println(bisectionSolver(loan, rate, n, epsilon));

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		// Replace the following statement with your code
		double temp=loan;
		if (n<=0) {
			return temp;
		}
		if (loan<=0) {
			return 0;
		}
		for(int i =0;i<n;i++) {
			temp = ((temp-payment)*(1+(rate/100)));
		}
		return temp;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		iterationCounter=0;
		double payment=loan/n;
		double ending = endBalance(loan, rate, n, payment);
		while (ending>epsilon) {
			if (ending>100) {
				payment=payment+10;
			} else {
				payment=payment+epsilon;
			}
			ending=endBalance(loan, rate, n, payment);
			iterationCounter++;
		}
		return payment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        // Replace the following statement with your code
		iterationCounter=0;
		double lower = 0;
		double higher = loan;
		double avarage = (lower+higher)/2;
		double endResult = endBalance(loan, rate, n, avarage);
		while (Math.abs(endResult)>epsilon) {
			if (endBalance(loan, rate, n, higher)*endResult<0) {
				lower = avarage;
			} else {
				higher = avarage;
			}
			avarage = (lower+higher)/2;
			iterationCounter ++;
			endResult = endBalance(loan, rate, n, avarage);
		}
		return avarage;
    }
}