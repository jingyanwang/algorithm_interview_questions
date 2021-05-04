'''
Reverse to Make Equal
Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
Signature
bool areTheyEqual(int[] arr_a, int[] arr_b)
Input
All integers in array are in the range [0, 1,000,000,000].
Output
Return true if B can be made equal to A, return false otherwise.
Example
A = [1, 2, 3, 4]
B = [1, 4, 3, 2]
output = true
After reversing the subarray of B from indices 1 to 3, array B will equal array A.
'''


# Python3 implementation to
# check whether two arrays
# can be made equal by
# reversing a sub-array
# only once

# Function to check whether two arrays
# can be made equal by reversing
# a sub-array only once
def checkArray(A, B, N):
	
	# Integer variable for
	# storing the required
	# starting and ending
	# indices in the array
	start = 0
	end = N - 1

	# Finding the smallest index
	# for which A[i] != B[i]
	# i.e the starting index
	# of the unequal sub-array
	for i in range(N):
		if (A[i] != B[i]):
			start = i
			break
			
	# Finding the largest index
	# for which A[i] != B[i]
	# i.e the ending index
	# of the unequal sub-array
	for i in range(N - 1, -1, -1):
		if (A[i] != B[i]):
			end = i
			break

	# Reversing the sub-array
	# A[start], A[start+1] .. A[end]
	A[start:end + 1] = reversed(A[start:end + 1])
	
	# Checking whether on reversing
	# the sub-array A[start]...A[end]
	# makes the arrays equal
	for i in range(N):
		if (A[i] != B[i]):
			
			# If any element of the
			# two arrays is unequal
			# print No and return
			print("No")
			return
			
	# Print Yes if arrays are
	# equal after reversing
	# the sub-array
	print("Yes")
	
# Driver code
if __name__ == '__main__':
	
	A = [ 1, 3, 2, 4 ]
	B = [ 1, 2, 3, 4 ]
	N = len(A)
	
	checkArray(A, B, N)
	
# This code is contributed by mohit kumar 29
