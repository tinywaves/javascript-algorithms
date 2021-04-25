/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/**
 * 2、两数相加
 *
 * @author: zheng donghui  E-mail:zheng.dong.hui@foxmail.com
 * @date: 2021-04-24 19:33
 */
 class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 获取两个数的长度
        int length1 = 0;
        int length2 = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null) {
            length1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }
        // 标记较长和较短的链表
        ListNode tempLong;
        ListNode tempShort;
        if (length1 > length2) {
            tempLong = l1;
            tempShort = l2;
        } else {
            tempLong = l2;
            tempShort = l1;
        }
        // 较短链表遍历至末尾
        ListNode ergodicTemp = tempShort;
        while (ergodicTemp.next != null) {
            ergodicTemp = ergodicTemp.next;
        }
        // 将较短链表的末尾用0补齐
        for (int i = 0; i < Math.max(length1, length2) - Math.min(length1, length2); i++) {
            ergodicTemp.next = new ListNode(0);
            ergodicTemp = ergodicTemp.next;
        }
        // 进位
        int carry = 0;
        // 结果
        ListNode result = new ListNode();
        ListNode temp = result;
        while (tempShort.next != null) {
            result.val = (tempShort.val + tempLong.val + carry) % 10;
            carry = (tempShort.val + tempLong.val + carry) / 10;
            result.next = new ListNode();
            result = result.next;
            tempShort = tempShort.next;
            tempLong = tempLong.next;
        }
        result.val = (tempShort.val + tempLong.val + carry) % 10;
        carry = (tempShort.val + tempLong.val + carry) / 10;
        if (carry != 0) {
            result.next = new ListNode();
            result.next.val = carry;
        }
        return temp;
    }
}

/**
 * 简化代码量后的代码
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}