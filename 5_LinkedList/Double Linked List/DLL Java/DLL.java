import java.io.IOException;

public class DLL {
        private NodeDLL head;
        private NodeDLL tail;

        public DLL() {
                head = null;
                tail = null;
        }

        public DLL(NodeDLL h) {
                head = h;
                tail = h;
        }

        public void printList() {
                if (head == null) {
                        System.out.println("No List");
                        return;
                }

                NodeDLL temp = head;
                while (temp.next != null) {
                        System.out.print(temp.val + "<---->");
                        temp = temp.next;
                }
                System.out.println(temp.val);
        }

        public void printRevLsit() {
                if (tail == null) {
                        System.out.println("No List");
                        return;
                }

                NodeDLL temp = tail;
                while (temp.prev != null) {
                        System.out.print(temp.val + "<---->");
                        temp = temp.prev;
                }

                System.out.println(temp.val);
        }

        public void addEnd(int newVal) {
                NodeDLL nn = new NodeDLL(newVal, null, null);

                if (head == null) {
                        head = nn;
                        tail = nn;
                        return;
                }

                NodeDLL temp = tail;
                nn.prev = temp;
                temp.next = nn;
                tail = nn;

        }

        public void addAfter(int newVal, int prevVal) {
                NodeDLL nn = new NodeDLL(newVal, null, null);

                if (head == null) {
                        return;
                }

                NodeDLL tempStart = head;
                while (tempStart.next != null && tempStart.val != prevVal) {
                        tempStart = tempStart.next;
                }

                NodeDLL newNext = tempStart.next;
                tempStart.next = nn;
                nn.next = newNext;
                nn.prev = tempStart;
                nn.next.prev = nn;
        }

        public void addBefore(int newVal, int nextVal) {
                NodeDLL nn = new NodeDLL(newVal, null, null);

                if (head == null) {
                        return;
                }

                NodeDLL tempEnd = tail;
                while (tempEnd.prev != null && tempEnd.val != nextVal) {
                        tempEnd = tempEnd.prev;
                }

                nn.prev = tempEnd.prev;
                tempEnd.prev = nn;
                nn.next = tempEnd;
                nn.prev.next = nn;
        }

        public int deleteFirstInstance(int target) {
                if (head == null)
                        return -9999;

                NodeDLL temp = head;
                while (temp != null && temp.val != target) {
                        temp = temp.next;
                }

                if (temp == null) {
                        System.out.println("Not Present");
                        return -9999;
                }

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                return temp.val;
        }

        public void deleteAllInstances(int target) {
                if (head == null)
                        return;

                NodeDLL temp = head;
                while (temp != null) {
                        if (temp.val == target) {
                                if (temp == head) {
                                        head = head.next;
                                } else {
                                        temp.prev.next = temp.next;
                                        temp.next.prev = temp.prev;
                                }
                        }
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
                if (tail == null) {
                        return;
                }
                tail = tail.prev;
                if (tail != null) {
                        tail.next = null;
                }
        }

        public void swap(NodeDLL a, NodeDLL b) {
                int temp = a.val;
                a.val = b.val;
                b.val = temp;
        }

        public void sortDLL() {
                if (head == null) {
                        return;
                }

                NodeDLL i = head;
                NodeDLL j;
                while (i != tail.next) {
                        j = i.next;
                        while (j != tail.next) {
                                if (i.val > j.val) {
                                        swap(i, j);
                                }
                                j = j.next;
                        }
                        i = i.next;
                }
        }

}

class MainDLL {
        public static void main(String args[]) throws IOException {
                System.out.println("The Double Linked List");
                DLL objDll = new DLL();

                objDll.addEnd(7);
                objDll.addEnd(9);
                objDll.addEnd(10);
                objDll.addEnd(1);
                objDll.addEnd(0);
                objDll.addEnd(9);
                objDll.addEnd(2);
                objDll.addEnd(4);
                objDll.printList();
                System.out.println("The Reverse List");
                objDll.printRevLsit();

                System.out.println("Add 10 after 7");
                objDll.addAfter(10, 7);
                objDll.printList();

                System.out.println("Add 3 before 9");
                objDll.addBefore(3, 9);
                objDll.printList();

                System.out.println("Delete front");
                objDll.deleteFront();
                objDll.printList();

                System.out.println("Delete end"); // Not working right
                objDll.deleteEnd();
                objDll.printList();

                System.out.println("Delete the first instance of 9");
                objDll.deleteFirstInstance(9);
                objDll.printList();

                System.out.println("Delete all instances of 10"); // Not working right
                objDll.deleteAllInstances(10);
                objDll.printList();

                System.out.println("Sort List"); // Not working right
                objDll.sortDLL();
                objDll.printList();

        }
}