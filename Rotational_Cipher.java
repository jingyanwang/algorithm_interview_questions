/*

Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.
Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678

*/

//A Java Program to illustrate Caesar Cipher Technique
class CaesarCipher
{
	// Encrypts text using a shift od s
	public static StringBuffer encrypt(String text, int s)
	{
		StringBuffer result= new StringBuffer();

		for (int i=0; i<text.length(); i++)
		{
			if (Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i) +
								s - 65) % 26 + 65);
				result.append(ch);
			}
			else if (Character.isLowerCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i) +
								s - 97) % 26 + 97);
				result.append(ch);
			}
			else if (Character.isDigit(text.charAt(i)))
			{
                //System.out.println((int)text.charAt(i));
				char ch = (char)(((int)text.charAt(i) +
								s - 48) % 10 + 48);
				result.append(ch);
			}
            else {
                result.append(text.charAt(i));
            }
		}
		return result;
	}

	// Driver code
	public static void main(String[] args)
	{
		String text = "Zebra-493?";
		int s = 3;
		System.out.println("Text : " + text);
		System.out.println("Shift : " + s);
		System.out.println("Cipher: " + encrypt(text, s));
	}
}
