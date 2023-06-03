import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        MaxHeapList mhl = new MaxHeapList(20);
        System.out.println("Original Array");
        mhl.printList(mhl.maxheap, 20);
        mhl.BuildMaxHeap();
        System.out.println("Build Max Heap");
        mhl.printList(mhl.maxheap, 20);
        mhl.HeapSort();
        System.out.println("Heap Sort");
        mhl.printList(mhl.maxheap, 20);
        System.out.println("Extract Max");
        System.out.println(mhl.extractMax());
        mhl.increaseKey(8, 87);
        System.out.println("Increase Key");
        mhl.printList(mhl.maxheap, 20);
        mhl.insertVal(16);
        System.out.println("Insert Value");
        mhl.printList(mhl.maxheap, 21);
        mhl.HeapSort();
        System.out.println("Heap Sort");
        mhl.printList(mhl.maxheap, 21);
    }
}
