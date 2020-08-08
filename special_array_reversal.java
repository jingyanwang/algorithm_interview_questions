/*
https://www.geeksforgeeks.org/reverse-a-string-without-affecting-special-characters/

Efficient Solution:
Time complexity of above solution is O(n), but it requires extra space and it does two traversals of input string.
We can reverse with one traversal and without extra space. Below is algorithm.

1) Let input string be 'str[]' and length of string be 'n'
2) l = 0, r = n-1
3) While l is smaller than r, do following
    a) If str[l] is not an alphabetic character, do l++
    b) Else If str[r] is not an alphabetic character, do r--
    c) Else swap str[l] and str[r]
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
