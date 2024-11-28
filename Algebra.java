// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		if(x1==x2 && x2==0) {
			return 0;
		} else if(x2>0){
			for(int i=0;i<x2;i++) {
				x1++;
			} 
			return x1;
		} else {
			for(int i=0;i<-x2;i++) {
				x1--;
			} 
			return x1;
		}
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if(x1==x2 && x2==0) {
			return 0;
		} else if(x2>0){
			for(int i=0;i<x2;i++) {
				x1--;
			} 
			return x1;
		} else {
			int count=0;
			while (x2<0) {
				count++;
				x2++;
			}
			x2=count;
			for(int i=0;i<x2;i++) {
				x1++;
			} 
			return x1;
		}	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		if (x1<0 && x2<0) {
			x1=minus(0, x1);
			x2= minus(0, x2);
		}if (x1 == 0 || x2 ==0) {
			return 0;	
		} else if(x2>0){
			int output = 0;
			for(int i = 0;i<x2;i++) {
				output = (plus(output, x1));
			}
			return output;
		} else {
			int output = 0;
			for(int i = 0;i<-x2;i++) {
				output = (plus(output, x1));
			}
			return output;
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		if (n==0) {
			return 1;
		} else {
			int output = x;
			for(int i=1;i<n;i++) {
				output = times(output, x);			
			}
			if (x<0 && mod(n, 2)==0 || x>0) {
				return output;
			}else {
				return (-output);
			} 
				
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int sign = 1;
		if (x1<0 && x2<0) {
			x1=-x1;
			x2=-x2;
		} if (x1<0) {
			x1=-x1;
			sign = -1;
		} else if (x2<0) {
			x2=-x2;
			sign = -1;
		}
		if (x2==0 || x1==0) {
			return 0;
		} else {
			int checkNum = 0;
			int steps =0;
			while (checkNum<x1) {
				checkNum += x2;
				if (checkNum<=x1) {
					steps++;
				}
			}
			return sign*steps;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		int checker = div(x1, x2);
		if (times(checker, x2)==x1) {
			return 0;
		} else {
			return minus(x1,times(checker, x2)); 
		}
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		if (x<=0) {
			return 0;	
		} else {
			double collective = 0;
			int steps = 0;
			double e = 0.00001;
			while (pow((int)collective, 2)<x) {
				collective +=e;
			}
			if (pow((int)collective, 2)<=x) {
				return (int) collective;
			} else {
				return (int) collective-1;
			}
		}
		
	}	  	  
}