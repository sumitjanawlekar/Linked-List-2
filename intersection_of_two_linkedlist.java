// Time Complexity : O(m+n), where m and n are the sizes of linkedlist with headA and headB respectively (or O(greater of m and n))
// Space Complexity :O(1), no extra space is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Calculate the size of the both the linkedlist. Take 2 pointer one starting at the head of the smaller linkedlist and the other
        //starting at the node that is obtained from taking the difference of the length of 2 lists
//2. start moving the pointer together, while checking if the 2 pointers points to the same refernce
//3. If yes return any pointer, as both the pointers are at the intersection of the 2 linkedlist

// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if any or both the heads are null return null, as there cannot be an intersection
        if(headA == null || headB == null) return null;
        
        //variables to store the lengths of both the linkedlist
        int lengthA = 0;
        int lengthB = 0;
        
        //Pointers to traverse the 2 linkedlist
        ListNode listA = headA;
        ListNode listB = headB;
        
        //calcute the length of linkedlist with headA
        while(listA != null){
            lengthA++;
            listA = listA.next;
        }
        
        //calculate the length of linkedlist with headB
        while(listB != null){
            lengthB++;
            listB = listB.next;
        }
        
        //Reseting the two pointers to the head of the linkedlists
        listA = headA;
        listB = headB;
        //bring the pointer of larger linkedlist ahead so that both the linkedlist's end is at the same distance from the pointer
        while(lengthA > lengthB){
            listA = listA.next;
            lengthA--;
        }
        while(lengthB > lengthA){
            listB = listB.next;
            lengthB--;
        }
        
        //Starting moving the 2 pointers together, till you find an intersection or null
        while(listA != null && listB != null){
            //If both the pointers are equal, then you are at the intersection, return either of the 2 pointers
            if(listA == listB){
                return listA;
            }
            listA = listA.next;
            listB = listB.next;
        }
        //If you dont find the intersection return null
        return null;
    }
}