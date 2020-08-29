/**
https://leetcode.com/problems/add-two-numbers-ii/submissions/
https://www.geeksforgeeks.org/sum-of-two-linked-lists/

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int carry = 0;
    public ListNode resultHead = null;
    
    public Solution(){carry = 0;resultHead=null;}
    
    public int listSize(ListNode l){
        int len = 0;
        while(l!=null){len++;l=l.next;}
        return len;
    }
 
    public void pushToResult(int i){
        ListNode newData = new ListNode(i);
        newData.next = resultHead;
        resultHead = newData;
    }
    
    public void addListSameSize(ListNode l1, ListNode l2){
        if(l1==null || l2==null) return;
        addListSameSize(l1.next, l2.next);
        int result = (carry+l1.val+l2.val);
        pushToResult(result%10);
        carry = result/10;
    }
    
    public void processRemainingDigitsOfLongerList(ListNode longerL, ListNode longerCurrent){
        if(longerL == longerCurrent) return;
        processRemainingDigitsOfLongerList(longerL.next, longerCurrent);
        int sum = longerL.val+carry;
        carry = sum/10;
        pushToResult(sum%10);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = listSize(l1);
        int len2 = listSize(l2);
        //System.out.println(len1+" "+len2);
        
        //if the two lists are of the same length
        if(len1 == len2){
            addListSameSize(l1,l2);
            if(carry>0) pushToResult(carry);
            return resultHead;
        }
        
        //if not, find the longer and shorter length lists
        ListNode longerL, shoterL;
        int longerLen, shorterLen;
        if(len1 > len2){
            longerL = l1;
            shoterL = l2;
            longerLen = len1;
            shorterLen = len2;
        }else{
            longerL = l2;
            shoterL = l1;
            longerLen = len2;
            shorterLen = len1;
        }
        
        //aligh the longer list to the shorter list and do the same size adding
        int diffLen = Math.abs(len1-len2);
        //System.out.println("length difference "+diffLen);
        
        ListNode longerCurrent = longerL;
        int count = 0;
        while(count < diffLen){
            longerCurrent = longerCurrent.next;
            count++;
        }
        //System.out.println("longerCurrent.val: "+longerCurrent.val);
        
        addListSameSize(longerCurrent,shoterL);
        
        ListNode n;

        //process the remaining digits of the longer list
        processRemainingDigitsOfLongerList(longerL, longerCurrent);
        if(carry>0) pushToResult(carry);
        
        /*
        n = resultHead;
        while(n!=null){System.out.println(n.val+" ");n=n.next;}
        System.out.println("carry "+carry);
        */
        
        return resultHead;
    }

}

class Playground {
    public static void main(String[ ] args) {
        ListNode n;
        
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        /*
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(8);
        */
        n = l1;
        while(n!=null){System.out.println(n.val+" ");n=n.next;}

        System.out.println("Hello Java");

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        n = l2;
        while(n!=null){System.out.println(n.val+" ");n=n.next;}
        
        System.out.println("Hello Java");
        
        Solution s = new Solution();
        //s.addListSameSize(l1,l2);
        s.addTwoNumbers(l1,l2);

        System.out.println("Hello Java");
     
        n = s.resultHead;
        while(n!=null){System.out.println(n.val+" ");n=n.next;}
        //System.out.println(s.carry+" ");
    }
}
