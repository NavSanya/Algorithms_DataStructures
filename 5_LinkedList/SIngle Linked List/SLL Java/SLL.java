import java.io.*;
import java.util.*;

public class SLL {
    private NodeSLL head;

    public SLL() {
        head = null;
    }

    public SLL(NodeSLL h) {
        head = h;
    }

    public void printList() {
        if (head == null) {
            System.out.println("No List");
            return;
        }

        NodeSLL temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + "--->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public void swap(NodeSLL a, NodeSLL b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void addEnd(int newVal) {
        NodeSLL nn = new NodeSLL(newVal, null);

        // if there is no list
        if (head == null) {
            head = nn;
            return;
        }

        // SLL traversal - add at the end of the list
        NodeSLL temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = nn;
    }

    public void addAfter(int newVal, int prevVal) {
        NodeSLL nn = new NodeSLL(newVal, null);

        if (head == null)
            return;

        NodeSLL temp = head;
        while (temp.next != null && temp.val != prevVal) {
            temp = temp.next;
        }

        NodeSLL newNext = temp.next;
        temp.next = nn;
        nn.next = newNext;
    }

    public void deleteFirstInstance(int target) {
        NodeSLL temp = head;
        NodeSLL prev = null;
        int retVal;
        if (head == null) {
            return;
        }

        while (temp != null) {
            if (temp.val == target) {
                retVal = temp.val;
                if (temp == head) {
                    head = head.next;
                    break;
                }
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteAllInstances(int target) {
        NodeSLL temp = head;
        NodeSLL prev = null;

        if (head == null) {
            return;
        }

        while (temp != null) {
            if (temp.val == target) {
                if (temp == head) {
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteFront() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    public void deleteEnd() {
        if (head == null) {
            return;
        }

        NodeSLL temp = head;
        NodeSLL prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    public void sortSLL() {
        if (head == null) {
            return;
        }

        NodeSLL i = head;
        NodeSLL j;
        while (i != null) {
            j = i.next;
            while (j != null) {
                if (i.val > j.val) {
                    swap(i, j);
                }
                j = j.next;
            }
            i = i.next;
        }
    }
}

class MainSLL {
    public static void main(String args[]) throws IOException {
        System.out.println("The Single Linked List");
        SLL obj = new SLL();
        obj.addEnd(7);
        obj.addEnd(9);
        obj.addEnd(10);
        obj.addEnd(1);
        obj.addEnd(0);
        obj.addEnd(9);
        obj.addEnd(2);
        obj.addEnd(4);
        obj.printList();

        System.out.println("Add 10 after 7");
        obj.addAfter(10, 7);
        obj.printList();

        System.out.println("Add 3 after 9");
        obj.addAfter(3, 9);
        obj.printList();

        System.out.println("Sorted List");
        obj.sortSLL();
        obj.printList();

        System.out.println("Delete front");
        obj.deleteFront();
        obj.printList();

        System.out.println("Delete end");
        obj.deleteEnd();
        obj.printList();

        System.out.println("Delete the first instance of 9");
        obj.deleteFirstInstance(9);
        obj.printList();

        System.out.println("Delete all instances of 10");
        obj.deleteAllInstances(10);
        obj.printList();
    }
}
