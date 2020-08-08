/*

1) Sort the input array in increasing order.
2) Initialize result as 0.
3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
   triplets with arr[i] as first element.
     a) Initialize other two elements as corner elements of subarray
        arr[i+1..n-1], i.e., j = i+1 and k = n-1
     b) Move j and k toward each other until they meet, i.e., while (j = sum), then do k--

            // Else for current i and j, there can (k-j) possible third elements
            // that satisfy the constraint.
            (ii) Else Do ans += (k - j) followed by j++ 

*/

import java.util.Arrays;

class triplets_count_smaller_than_a_value{
	static int arr[] = new int[]{5,1,3,4,7};

	static int countTriplets(int n, int sum){

		// Initialize result
		int ans = 0;

		// Fix the first element as A[i]
		for(int i=0;i < n-1; i++){

			// Initialize other two elements as corner elements
			// of substray arr[j+1..k]

			int j = i+1, k = n-1;

			// Use meet in the middle concept
			while(j < k){
				// If sum of current triplet is more of equal, 
				// move right corner to look for smaller values
				if(arr[i] + arr[j] + arr[k] >= sum){
					k--;
				}
				
				// Else move left corner
				else{
					// This is import. For current i and j, there
					// can be total k-j third elements
					ans += (k-j);
					j++;
				}
			}

		}

		return ans;

	}

	// Driver methods to test the above function 
	public static void main(String[] args){
		int sum = 12;
		System.out.println(countTriplets(arr.length, sum));
	}
}

