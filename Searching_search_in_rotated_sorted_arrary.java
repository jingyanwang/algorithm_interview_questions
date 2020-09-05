/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

Search an element in a sorted and rotated array

we rotate an ascending order sorted array at some pivot unknown to you beforehand.
Devise a way to find an element in the rotated array in O(log n) time and O(1) space

Example:

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3

*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] <= nums[nums.length-1]) return binarySearch(nums, nums.length,0, nums.length-1, target);

        int pivot = findPivot(nums, nums.length, 0, nums.length-1);
        //System.out.println("pivot: "+pivot+", arr[pivot]: "+nums[pivot]);

        if(nums[pivot] == target) return pivot;
        if(nums[pivot+1] == target) return pivot+1;
        if(target < nums[pivot] && target >= nums[0]) return binarySearch(nums, nums.length, 0, pivot, target);

        if(target > nums[pivot+1] && target <= nums[nums.length-1]) return binarySearch(nums, nums.length, pivot+1, nums.length-1, target);

        return -1;
    }
    
    public int findPivot(int[] arr, int n, int low, int high){
        if(arr[low]<=arr[high]) return -1;
        if(low==high) return low;
        int mid = (low+high)/2;

        if(mid+1 <= high && arr[mid]>arr[mid+1]) return mid;
        if(mid-1 >= low && arr[mid-1]>arr[mid]) return mid-1;
        
        if(arr[mid]>arr[high]) return findPivot(arr, n, mid+1, high);
        else return findPivot(arr, n, low, mid);
    }
    
    public int binarySearch(int arr[], int n, int low, int high, int key){
        if(key > arr[high] || key < arr[low]) return -1;
        int mid = (low+high)/2;
        if(arr[mid] == key) return mid;
        if(key > arr[mid]) return binarySearch(arr, n, mid+1, high, key);
        else return binarySearch(arr, n, low, mid, key);
    }
    
    public void printArrary(int[] arr){
        for(int i=0; i<arr.length; i++) System.out.print(arr[i]+",");
        System.out.println();
    }
}

class Playground {
    public static void main(String[ ] args) {
        Solution s = new Solution();
        int arr[] = {3,5,1};
        
        System.out.println(s.search(arr, 3));
        
        /*
        int arr[] = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        System.out.println(s.binarySearch(arr, n, 0, n-1, 100));
        */
        
        //System.out.println(arr[pivot]);
        
        //s.printArrary(arr);
        System.out.println("Hello Java");
    }
}
