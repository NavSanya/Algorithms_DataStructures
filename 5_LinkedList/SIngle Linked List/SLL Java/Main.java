import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException
    {
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
        obj.addAfter(10,7);
        obj.printList();

        System.out.println("Add 3 after 9");
        obj.addAfter(3,9);
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
