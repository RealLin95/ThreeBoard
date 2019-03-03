package bittech;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    public static ListNode removeElements(ListNode head, int val) {
        while(head!= null && head.val == val){
            head = head.next;    //头结点往后走一步
        }
        if(head==null){
            return null;
        }
        ListNode prev = head;
        while(prev.next!=null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;  //头结点往后走一步
            }
        }
        return head;
        /*ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next!=null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummyHead.next;*/
    }
}
public class Solution {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(6);
        ListNode list5 = new ListNode(4);
        ListNode list6 = new ListNode(5);
        ListNode list7 = new ListNode(6);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        Solution solu = new Solution();
        ListNode list = ListNode.removeElements(list1,6);
        while(list!=null){
            System.out.print(list.val+"、");
            list = list.next;
        }

    }
}
