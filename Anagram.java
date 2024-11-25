/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if(str1.length()!=str2.length()) return false;
		int counter1=0;
		int counter2=0;
		for(int i=0;i<str1.length();i++) {
			char current = str1.charAt(i); 
			for(int j=0;j<str2.length();j++) {
				if (current == str2.charAt(j)) {
					counter1++;
				}
				if(current == str1.charAt(j)) {
					counter2++;
				}
			}
			if (counter1!=counter2) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String ret = "";
		boolean adder= true;
		char test = ' ';
		for(int i=0;i<str.length();i++) {
			test = str.charAt(i);
			if (test==' ') {
				adder=false;
			} else if ((int)test<65 || (int) test > 122 ) {
				adder=false;
			} else if ((int)test>90 && (int) test < 97) {
				adder=false;
			}
			if (adder) {
				if ((int)str.charAt(i)>=65 && (int)str.charAt(i)<=90) {
					int replaceINT = (int) str.charAt(i) +32 ;
					test = (char) replaceINT;
				}
			} else {
				adder=false;
			}
			if (adder) {
				ret+=test;
			}
			adder = true;
		}
		return ret;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		str = preProcess(str);
		String res = str;
		String result = "";
		String temp="";
		int counter = 0;
		while (res.length()>0) {
			//System.out.println("counter: " + counter);
			int index =(int)(Math.random()*res.length()-1);
			result+=res.charAt(index);
			//System.out.println("result char:" + res.charAt(index));
			for(int i=0;i<res.length();i++) {
				if (i!=index) {
					temp+=res.charAt(i);
				}
			}
			//System.out.println("Length: " + res.length());
			res = temp;
			temp = "";
			counter++;
		}
		return result;
	}
}
