/*
Reverse a Linked List in groups of given size k

Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Example:

Input: 1-2-3-4-5-6-7-8-NULL, K = 3
Output: 3-2-1-6-5-4-8-7-NULL

Input: 1-2-3-4-5-6-7-8-NULL, K = 5
Output: 5-4-3-2-1-8-7-6-NULL
*/


class linkedList{
    class Node{int data; Node next; public Node(int i){data=i;next=null;}}
    
    Node head;
    
    public void push(int i){
        Node newNode = new Node(i);
        newNode.next = head;
        head = newNode;
    }
    
    public void printList(Node head){
        while(head != null){
            System.out.println(head.data+" ");
            head = head.next;
        }
    }
    
    public Node reverseByGroup(Node head, int K){
        Node curr = head;
        Node prev = null;
        Node next = null;
        int countReversedNode = 0;

        while(countReversedNode < K && curr != null){
            //System.out.println("processing "+curr.data);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr==null) return prev;
            //System.out.println("after processing, current is "+curr.data);
            countReversedNode++;
        }
        /*
        System.out.println("current previouse is "+prev.data);
        System.out.println("processing data from "+curr.data);
        */
        
        Node nextPrev = reverseByGroup(curr, K);
        head.next = nextPrev;
        
        return prev;
    }
}


class Playground {
    public static void main(String[ ] args) {
        linkedList l = new linkedList();
        l.push(8);
        l.push(7);
        l.push(6);
        l.push(5);
        l.push(4);
        l.push(3);
        l.push(2);
        l.push(1);
        l.printList(l.head);
        System.out.println("Hello Java");

       l.head = l.reverseByGroup(l.head, 3);
       l.printList(l.head);

        System.out.println("Hello Java");
    }
}
