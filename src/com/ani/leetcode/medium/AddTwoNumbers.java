/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
      Output: 7 -> 0 -> 8
      Explanation: 342 + 465 = 807.
 */
package com.ani.leetcode.medium;

/**
 * @author aniket
 *
 */
public class AddTwoNumbers {

	
	
	
	
	
	public static void main(String[] args) {
//Create a list l1: 2->4->3
		//let's assume the lenght of list to be 3
		
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(4);
		l1.next.next= new ListNode(3);
		
		//list 2 with 5->6->4
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		System.out.println("Printing the input nodes" + l2.nodeValue +"-->" + l2.next.nodeValue + "-->" +l2.next.next.nodeValue);
		System.out.println("Printing the input 1 nodes" + l1.nodeValue +"-->" + l1.next.nodeValue + "-->" +l1.next.next.nodeValue);

		ListNode result = addTwoNumbers(l1,l2);
		
		System.out.println("result : -> "+ result.nodeValue +"->"+result.next.nodeValue+"->" + result.next.next.nodeValue);
		//System.out.println("result : -> "+ result.nodeValue);

	}
	
	
 
 public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	 
	 int sum =0 ; // variable sum with the initial value as 0;
	 //head Node to store begining object/begining position
	 
	 ListNode headNode = new ListNode(0);
	 ListNode result= headNode;
	 
	 System.out.println("start of iteration");
	 //iterate over the  end of linked list
	 while(l1!=null || l2!=null) {
		if(l1!=null) {
			 sum = sum + l1.nodeValue; 
			 l1= l1.next;
		}
		if(l2!=null) {
			 sum =sum + l2.nodeValue; 
			 l2=l2.next;
		}
		//Take care of carry over value
		 result.next = new ListNode(sum%10);
		sum = sum/10; //in case its greater than 10, it will have the carry over , else O.
		result = result.next;
		
	 }
	  //in case you reach the end , check the last value , no need to carry over, so sum should be as it is.
	 if(sum>0) {//carry over of the last value, to an extra node in the result.
		 result.next = new ListNode(sum);
 
	 }
	 return headNode.next;//because the head has 0 , so start from the next node, where the value is computed.
    }
	
	
	
	
	
	
	
	
	
	
	

}

//Initialize a linkedlist

class ListNode {
	
	int nodeValue;
	
	public int getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}

	ListNode next;
	
	ListNode(int nodeValue) {
		this.nodeValue = nodeValue;
	}
}
