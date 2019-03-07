package bittech;

import java.util.List;

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
    public static ListNode middleNode(ListNode head) {
//        int count = 0;
//        ListNode list = head;
//        while(head!=null){
//            count++;
//            head = head.next;
//        }
//        for(int i = 1;i<(count/2+1);i++){
//            list = list.next;
//        }
//        return list;
        ListNode middle = head;
        ListNode end = head;
        while(end!=null&&end.next!=null){
            middle = middle.next;
            end = end.next.next;
        }
        return middle;
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
//        int count = 0;
//        ListNode list = head;
//        while(head!=null){
//            count++;
//            head = head.next;
//        }
//        if(k<0||k>count){
//            return null;
//        }
//        for(int i = 0;i<count-k;i++){
//            list = list.next;
//        }
//        return list;
        ListNode begin = head;
        ListNode end = head;
        if(k<=0){  //k值错误
            return null;
        }
        for(int i = 0;i<k;i++){//第一个人先走k步
            if(begin!=null){ //防止k值超出总个数
                begin = begin.next;
            }
        }
        while(begin!=null){ //第一个人走到null
            begin = begin.next;
            end = end.next;
        }
        return end;
    }
    public static ListNode reverseList(ListNode head){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }else{
            ListNode f = dummyHead.next;
            ListNode s = f.next;
            while(s!=null){
                f.next = s.next;
                s.next = dummyHead.next;  // 新头指向旧头
                dummyHead.next = s;  //每次s作为新头
                s = f.next;
            }
            return dummyHead.next;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }else{
            ListNode mid = ListNode.middleNode(head);
            ListNode last = ListNode.reverseList(mid);
            for(ListNode node = head;node != mid;node = node.next){
                if(node.val!=last.val){
                    return false;
                }
                last = last.next;
            }
            return true;
        }
    }
}
public class Solution {
    public static void main(String[] args) {
//        ListNode list1 = new ListNode(1);
//        ListNode list2 = new ListNode(2);
//        ListNode list3 = new ListNode(3);
//        ListNode list4 = new ListNode(6);
//        ListNode list5 = new ListNode(4);
//        ListNode list6 = new ListNode(5);
//        ListNode list7 = new ListNode(6);
//        list1.next = list2;
//        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;
//        list5.next = list6;
//        list6.next = list7;
//        Solution solu = new Solution();
//        ListNode list = ListNode.removeElements(list1,6);
//        while(list!=null){
//            System.out.print(list.val+"、");
//            list = list.next;
//        }
//        System.out.println(ListNode.middleNode(list1));
//        System.out.println(ListNode.FindKthToTail(list1,2));
//        ListNode result = ListNode.reverseList(list1);
//        while(result!=null){
//            System.out.print(result.val+"、");
//            result = result.next;
//        }
        //        ListNode list1 = new ListNode(1);
        ListNode list1 = new ListNode(0);
        //ListNode list2 = new ListNode(1);
        //ListNode list3 = new ListNode(2);
        //ListNode list4 = new ListNode(1);
        //list1.next = list2;
        //list2.next = list3;
        //list3.next = list4;
        System.out.println(ListNode.isPalindrome(list1));
    }
}
