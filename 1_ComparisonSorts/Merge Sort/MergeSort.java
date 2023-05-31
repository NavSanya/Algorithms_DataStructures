import java.io.*;
import java.util.*;

class MergeSort {
    /*
     * creating an array of size n
     * initializing the arry with random values
     */
    public int[] initializeArrayWithRandomNumbers(int n) {
        int arr[] = new int[n];
        int i;
        Random rand = new Random();
        for (i = 0; i < n; ++i) {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    // Swaps the values at position1 and position2 in the array parameter and
    // returns the edited array
    public int[] swap(int[] arr, int position1, int position2) {
        int temporary = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temporary;
        return arr;
    }// swap()

    public void printArray(int arr[]) {
        int i;
        for (i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    protected int[] merge(int[] arr, int low, int high, int mid) {
        int i, j, k;
        int lengthLeft, lengthRight;
        lengthLeft = mid - low + 1;
        lengthRight = high - mid;

        int[] leftArray = new int[lengthLeft]; // creating 2 arrays to merge
        int[] rightArray = new int[lengthRight];

        // giving the left array its values
        for (i = 0; i < lengthLeft; ++i) {
            leftArray[i] = arr[low + i];
        } // for loop

        // giving the right array its values
        for (i = 0; i < lengthRight; ++i) {
            rightArray[i] = arr[mid + 1 + i];
        } // for loop

        i = 0;
        j = 0;
        k = low;
        while (i < lengthLeft && j < lengthRight) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } // if block
            else {
                arr[k] = rightArray[j];
                j++;
                k++;
            } // else block
        } // while loop

        while (i < lengthLeft) // for the remaining elements in the left array
        {
            arr[k] = leftArray[i];
            ++i;
            ++k;
        } // while i loop

        while (j < lengthRight)// for the remaining elements in the right array
        {
            arr[k] = rightArray[j];
            ++j;
            ++k;
        } // while j loop

        return arr;
    }// merge()

    // the function that sorts the array from mid to low using the merge function
    protected int[] mergeSort(int[] arr, int high, int low) {
        int mid;
        if (low < high) {
            mid = (int) (Math.floor((high + low) / 2.0));
            arr = mergeSort(arr, high, (mid + 1));// redivide the right half
            arr = mergeSort(arr, mid, low);// redivide the left half
            arr = merge(arr, low, high, mid);// merge the sorted halves
        } // if block
        return arr;
    }// mergeSort()
}

class MainMerge {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int size = 10;
        int arrAns[];
        int arr[] = ms.initializeArrayWithRandomNumbers(size);
        System.out.println("Unsorted Array");
        ms.printArray(arr);

        // Bubble Sort
        System.out.println("**********Merge Sort**********");
        arrAns = ms.mergeSort(arr, 9, 0);
        ms.printArray(arrAns);
    }
}