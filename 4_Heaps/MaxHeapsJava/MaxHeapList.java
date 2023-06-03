import java.util.*;
import java.io.*;

public class MaxHeapList {
    public int maxheap[];

    // UTILITY FUNCTIONS
    protected MaxHeapList(int n) {
        Scanner sc = new Scanner(System.in);
        maxheap = new int[n];
        maxheap[0] = (Integer.MAX_VALUE);
        for (int i = 1; i < n; ++i) {
            maxheap[i] = (int) (Math.random() * 100000000 % n);
        }
    }

    protected void printList(int x[], int size) {
        for (int i = 1; i < size; i++) {
            System.out.print(x[i] + "\t");
        }
        System.out.println();
    }

    protected int[] swap(int[] arr, int position1, int position2) {
        int temporary = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temporary;
        return arr;
    }

    public int LeftChild(int i) {
        return 2 * i;
    }

    public int RightChild(int i) {
        return (2 * i) + 1;
    }

    public int Parent(int i) {
        return i / 2;
    }

    public void MaxHeapify(int i, int n) {
        int l = LeftChild(i);
        int r = RightChild(i);
        int largest;
        if (l < n && maxheap[l] > maxheap[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < n && maxheap[r] > maxheap[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(maxheap, i, largest);
            MaxHeapify(largest, n);
        }
    }

    public void BuildMaxHeap() {
        int n = maxheap.length;
        for (int i = n / 2; i >= 1; --i) {
            MaxHeapify((i), n);
        }
    }

    public void HeapSort() {
        int n = maxheap.length;
        BuildMaxHeap();
        for (int i = n - 1; i >= 2; --i) {
            swap(maxheap, 1, i);
            MaxHeapify(1, i - 1);
        }
    }

    public int extractMax() {
        int n = maxheap.length;
        if (n < 1) {
            System.out.println("Underflow");
            return -999;
        }
        BuildMaxHeap();
        int max = maxheap[1];
        maxheap[1] = maxheap[n - 1];
        MaxHeapify(1, n - 1);
        return max;
    }

    public void increaseKey(int i, int key) {
        if (key < maxheap[i]) {
            System.out.println("New key smaller than current key");
        }
        maxheap[i] = key;
        while (i > 1 && maxheap[Parent(i)] < maxheap[i]) {
            swap(maxheap, i, Parent(i));
            i = Parent(i);
        }
    }

    public void insertVal(int key) {
        int n = maxheap.length;
        int newMaxHeap[] = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            newMaxHeap[i] = maxheap[i];
        }
        newMaxHeap[n] = key;

        maxheap = newMaxHeap;

        increaseKey(n, key);
    }
}
