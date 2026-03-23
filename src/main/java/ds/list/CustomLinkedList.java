package ds.list;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

}

class LinkedList {

    Node head;

    void findMiddleElement() {
        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("middle element::" + slowPtr.data);

    }

    void lengthOfList() {
        Node temp = head;
        int k = 0;

        while (temp != null) {
            temp = temp.next;
            k++;
        }
        System.out.println("length of list::" + k);

    }

    void pushAtFront(int item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
    }

    void pushAtRear(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;

        }

    }

    void deleteAtFront() {
        if (head == null) System.out.println("nothing to delete");

        else if (head.next == null) {
            System.out.println("deleted" + head.data);
            head = null;
        } else {
            System.out.println("deleted" + head.data);
            head = head.next;

        }

    }

    void deleteAtRear() {
        Node temp = head;
        if (head == null) System.out.println("nothing to delete");

        else if (head.next == null) {
            System.out.println("deleted" + head.data);
            head = null;
        } else {

            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;

        }

    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void detectLoop() {

        Node slowPtr = head;
        Node fastPtr = head;
        boolean flag = false;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                flag = true;
                break;
            }
        }
        if (flag) {
            removeLoop(slowPtr);
            System.out.println("Loop found" + slowPtr.data);
        } else {
            System.out.println("No Loop found");
        }


    }

    public void removeLoop(Node slowPtr) {

        Node ptr1 = slowPtr;
        Node ptr2 = head;

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        Node last = ptr1;
        while (last.next != ptr1) {
            last = last.next;
        }
        last.next = null;

    }

    public boolean palindrome() {
        Node cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.data);
            cur = cur.next;
        }
        for (int i = 0; i < list.size() / 2; i++)
            if (list.get(i) != list.get(list.size() - i - 1)) return false;
        return true;


    }

    public void removeDuplicates() {

        Node cur = head;
        Node prev = null;
        Set<Integer> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur.data)) {
                prev.next = cur.next;
            } else {
                set.add(cur.data);
                prev = cur;
            }
            cur = cur.next;
        }


    }

    public Node sortLinkedList() {
        int[] countArr = {0, 0, 0};

        Node temp = head;
        while (temp != null) {
            countArr[temp.data]++;
            temp = temp.next;
        }

        temp = head;
        int i = 0;

        while (temp != null) {
            if (countArr[i] == 0) {
                i++;
            } else {
                temp.data = i;
                countArr[i]--;
                temp = temp.next;
            }
        }
        return temp;


    }

    public void rotateKtimes(int k) {

        if (head == null || head.next == null) return;

        for (int i = 0; i < k; i++) {
            Node temp = head;
            while (temp.next.next != null) temp = temp.next;
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;

        }

    }

    public void reverseLinkedList(){

        Node prev = null;
        Node curr =head;

        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev=curr;
            curr=temp;

        }
        head= prev;
    }
}

public class CustomLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = new int[]{0, 1, 0, 2, 1, 1, 2, 1, 2};
        for (int i = arr.length - 1; i >= 0; i--) {
            list.pushAtFront(arr[i]);
        }
        System.out.println("Before any operation::");
        list.display();

        System.out.println("Insertion at Rear::");
        list.pushAtRear(3);
        list.display();

        System.out.println("Insertion at Rear::");
        list.pushAtRear(3);
        list.display();

        System.out.println("Insertion at Rear::");
        list.pushAtRear(4);
        list.display();

        list.findMiddleElement();
        list.lengthOfList();

        System.out.println("Palindrome ??::" + list.palindrome());


        list.head.next.next.next.next.next = list.head.next.next;
        list.detectLoop();

        list.detectLoop();

        list.removeDuplicates();
        list.display();

        list.rotateKtimes(1);
        list.display();

        list.reverseLinkedList();
        list.display();


    }

}
