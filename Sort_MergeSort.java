/*
Merge Sort

It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See following C implementation for details.

Given array is
12 11 13 5 6 7

Sorted array is
5 6 7 11 12 13

*/

class mergeSort{
    
    public void mergeSorting(int[] arr, int l, int r){
        if(l>=r) return;
        int m = (l+r)/2;
        mergeSorting(arr, l, m);
        mergeSorting(arr, m+1, r);
        merge(arr, l, m, r);
    }
    
    public void merge(int[] arr, int l, int m, int r){
        int len_left = m-l+1;
        int len_right = r-m;
        
        int[] left_arr = new int[len_left];
        int j = 0;
        for(int i=l;i<=m;i++){left_arr[j] = arr[i];j++;}
        
        int[] right_arr = new int[len_right];
        j = 0;
        for(int i=m+1;i<=r;i++){right_arr[j] = arr[i];j++;}
        
        int k = l;
        int il = 0, ir =0;
        while(il<len_left && ir<len_right){
            if(left_arr[il]<right_arr[ir]){
                arr[k] = left_arr[il];
                il++;
            }else{
                arr[k] = right_arr[ir];
                ir++;
            }
            k++;
        }
        
        while(il<len_left){arr[k] = left_arr[il];il++;k++;}
        while(ir<len_right){arr[k] = right_arr[ir];ir++;k++;}
    }
    
    public void printList(int[] arr, int n){
        for(int i = 0; i<n; i++) System.out.println(arr[i]+" ");
    }
}

class Playground {
    public static void main(String[ ] args) {
        
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        mergeSort m = new mergeSort();
        m.mergeSorting(arr, 0, 5);
        
        m.printList(arr, arr.length);
        
    }
}

/*
T(n) = 2*T(n/2) + O(n)

O(n*log n)
*/
