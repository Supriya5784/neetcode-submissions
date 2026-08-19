/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list2.next,list1);
            return list2;
        }
    }
    public ListNode partitionLists(int start,int end,ListNode[] lists){
        if(start>end){
            return null;
        }
        if(start == end){
            return lists[start];
        }
        int mid = start+(end-start)/2;
        ListNode L1 = partitionLists(start,mid,lists);
        ListNode L2 = partitionLists(mid+1,end,lists);
        return mergeTwoLists(L1,L2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0 || lists==null){
            return null;
        }
        return partitionLists(0,k-1,lists);

    }
}
