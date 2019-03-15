package bittech2;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class Exam {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        ListNode l31 = new ListNode(1);
        ListNode l32 = new ListNode(1);
        ListNode l33 = new ListNode(3);
        ListNode l34 = new ListNode(4);
        ListNode l35 = new ListNode(4);
        ListNode l36 = new ListNode(5);
        //l1链表：[-4,2,4]
        l1.next = l2;
        l2.next = l3;
        //l4链表：[1,3,5]
        l4.next = l5;
        l5.next = l6;
        //l31链表[1,4,3,2,5,2]
        l31.next = l32;
        l32.next = l33;
        l33.next = l34;
        l34.next = l35;
        l35.next = l36;
//        ListNode list = mergeTwoLists(l1,l4);//合并两个有序链表
//        ListNode list1 = partition(l31,3);//分隔链表
//        ListNode list2 = deleteDuplicates(l31);
        ListNode list3 = deleteDuplicates2(l31);
        while(list3!=null){
            System.out.print(list3.val+"、");
            list3 = list3.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else{
            ListNode node = new ListNode(0);
            ListNode list = node;//list指向node头节点
            while(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    list.next = l1;
                    l1 = l1.next;
                }else{
                    list.next = l2;
                    l2 = l2.next;
                }
                list = list.next;
            }
            if(l1==null){
                list.next = l1;
            }
            else if(l2==null){
                list.next = l2;
            }
            return node.next;//指向node的开始比较节点
        }
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存小链表和大链表的头节点；
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode node1 = dummy1;
        ListNode node2 = dummy2;
        while (head != null) {
            if(head.val<x){
                node1.next = head;
                node1 = node1.next;
            }else{
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node2.next = null;
        node1.next = dummy2.next;
        return dummy1.next;
    }
    public static ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        while(cur!=null){
            if(prev.val==cur.val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = prev.next;
        }
        return head;
    }
    public static ListNode deleteDuplicates2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while(cur!=null){
            boolean flag = true;
            while(cur.next!=null&&cur.val==cur.next.val){
                flag = false;
                prev.next = cur.next;//删掉前一个重复的元素
                cur = cur.next;
            }
            if(!flag){
                prev.next = cur.next;//删除即越过该元素
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
