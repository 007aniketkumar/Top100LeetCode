/**
 * 
 */
package com.ani.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author aniket
 * 
 * 
 * Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 *
 */
public class MergeKLists {



	//Requirement was to merge the list in ascending order
	
public static ListNode mergeKLists(ListNode[] lists) {

	
	ListNode result=null;
    ListNode current =null;
    //Simple problem of using a priority queue and putting the items from the list.
//while creating a new list just add them back to the next list from the priority queue

    if(lists==null || lists.length==0){
        return null;
    }

PriorityQueue<Integer> newQueue  = new PriorityQueue<>();

for (ListNode listNode : lists) {

while(listNode!=null) {
	newQueue.add(listNode.val);
	listNode = listNode.next;
}
}

//Read back from the queue and add it a to new list

    if(newQueue.peek()!=null){
      result = new ListNode(newQueue.poll());
        current = result;
    }



while(!newQueue.isEmpty() && newQueue.peek()!=null) {
	current.next = new ListNode(newQueue.poll());
	current = current.next;
	
}	
	
return result;
}





//Merge the list in descending order
//6->5->4->4-3>2->1->1


public static ListNode mergeKListsDescendingOrder(ListNode[] lists) {

	
	ListNode result, current;
	
	//This queue will store the items in descending order
	PriorityQueue<Integer> descendQueue = new PriorityQueue<>(new Comparator<Integer>() {
		
		
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1)	;		
		}
		
	});
	
	
	for (ListNode listNode : lists) {
		while(listNode!=null) {
		descendQueue.add(listNode.val);
		listNode= listNode.next;
		}
	}
	
	
	//add it in the new list.
	
	 result = new ListNode(descendQueue.poll());
	current = result;
	
	while(!descendQueue.isEmpty()) {
		System.out.println("Descend queue"+descendQueue.peek());
		current.next= new ListNode(descendQueue.poll());
		current = current.next;
		
	}
	
return result;}













/**
 * Definition for singly-linked list.*/

  public static void main(String[] args) {
	
	  //create ListNode[]

	  ListNode[] lists = new ListNode[3];
	  
	  ListNode l1 = new ListNode(1);
	  l1.next = new ListNode(4);
	  l1.next.next = new ListNode(5);
	  
	  
	  ListNode l2 =  new ListNode(1);
	  l2.next = new ListNode(3);
	  l2.next.next = new ListNode(4);
	  
	  ListNode l3 = new ListNode(2);
	  l3.next = new ListNode(6);
	  
	  lists[0] = l1;
	  lists[1] = l2;
	  lists[2] = l3;
	  
	  
	  //pass empty lists
	  ListNode l4 = new ListNode();
	  ListNode l5 = new ListNode();
	  
System.out.println("Printing the value in l4"+ l4.val);
	  
	  //let's try to print the lists
	  
	  for (ListNode listNode : lists) {
		 System.out.println("\n");
		 while(listNode!=null) {
			 System.out.print(listNode.val +"-->");
			 listNode = listNode.next;
		 }
	}
	  
	  
	  
	  //call mergeKlists
	  
	 ListNode result =  mergeKLists(lists);
	 System.out.println("Printing the result");
	while(result!=null) {
		System.out.print(result.val + "-->");
		result = result.next;
		
	}
	
	
	//call mergeKDescendlists
	  
		 ListNode resultNew =  mergeKListsDescendingOrder(lists);
		 System.out.println("Printing the result");
		while(resultNew!=null) {
			System.out.print(resultNew.val + "-->");
			resultNew = resultNew.next;
			
		}
	
  }
 
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(){
    }
    }
