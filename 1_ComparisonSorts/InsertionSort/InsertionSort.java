import java.io.*;
import java.util.*;

class InsertionSort {
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

    protected int[] insertionSort(int[] arr) {
        int j, i, key;
        for (i = 1; i < arr.length; ++i)// length times
        {
            key = arr[i];
            j = i - 1;
            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr[j] > key) // length - 1 times
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            } // while loop (inner)
            arr[j + 1] = key;
        } // for loop (outer)
        return arr;
    }// insertionSort()

}

class MainInsertion {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int size = 10;
        int arrAns[];
        int arr[] = is.initializeArrayWithRandomNumbers(size);
        System.out.println("Unsorted Array");
        is.printArray(arr);

        // Bubble Sort
        System.out.println("**********Insertion Sort**********");
        arrAns = is.insertionSort(arr);
        is.printArray(arrAns);
    }
}
