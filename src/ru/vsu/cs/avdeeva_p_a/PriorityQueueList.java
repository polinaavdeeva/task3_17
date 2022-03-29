package ru.vsu.cs.avdeeva_p_a;

public class PriorityQueueList {

    private class ListNode {
        public String value;
        public ListNode next;

        public ListNode(String value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(String value) {
            this(value, null);
        }

        public int compareTo(ListNode a) {
            Integer wordSize1 = value.length();
            Integer wordSize2 = a.value.length();

            return wordSize1.compareTo(wordSize2);
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private ListNode head = null;
    private ListNode tail = null;
    private int count = 0;

    public void add(String value) {
        ListNode newNode = new ListNode(value);
        if (count == 0) {
            head = tail = newNode;
        } else if (newNode.compareTo(head) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode node = getPrevNode(newNode);
            if (node.equals(tail)) {
                tail.next = newNode;
                tail = newNode;
            } else {
                newNode.next = node.next;
                node.next = newNode;
            }
        }
        count++;
    }

    public ListNode getPrevNode(ListNode newNode) {
        ListNode out = new ListNode(null);
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (newNode.compareTo(curr) < 0) {
                out = curr;
            }
        }
        return out;
    }

    @Override
    public String toString() {
        ListNode value = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (value != null) {
            stringBuilder.append(value.value).append(" ");
            value = value.next;
        }
        return stringBuilder.toString();
    }

    public String remove() throws Exception {
        String result = element();
        head = head.next;
        if (count == 1) {
            tail = null;
        }
        count--;
        return result;
    }

    public String element() throws Exception {
        if (count() == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }

    public int count() {
        return count;
    }

    public boolean isEmpty() {
        return count() == 0;
    }
}
