/*
https://www.geeksforgeeks.org/reverse-a-string-without-affecting-special-characters/
*/

//java code to illustrate how to reverse
// an array without affecting special cahracters

class special_array_reversal{
	public static void reverse(char str[]){
		// Initialize left and right pointers
		int r = str.length -1, l = 0;

		// Traverse string from both ends until 
		// 'l' and 'r'
		while(l < r){
			// Ignore special characters
			if(!Character.isAlphabetic(str[l]))
				l++;
			else if(!Character.isAlphabetic(str[r]))
				r--;

			//Both str[l] and str[r] are not special 
			else{
				char tmp = str[l];
				str[l] = str[r];
				str[r] = tmp;
				l++;
				r--;
			}
			
		}

	}

	// Driver code
	public static void main(String[] args){
		String str = "(x$l$`ek]$intly$l$ysbzatm";

		char[] charArray = str.toCharArray();

		System.out.println(charArray);
		reverse(charArray);
		System.out.println(charArray);
	}
}
