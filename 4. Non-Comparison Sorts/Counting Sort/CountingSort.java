import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int size = 10;
        int arrAns[];
        int arr[] = cs.initializeArrayWithRandomNumbers(size);
        System.out.println("Unsorted Array");
        cs.printArray(arr);

        //Counting Sort
        System.out.println("**********Counting Sort**********");
        arrAns = cs.countingSort(arr);
        cs.printArray(arrAns);
    }
}
class CountingSort
{
    public int[] initializeArrayWithRandomNumbers(int n)
    {
        int arr[] = new int[n];
        int i;
        arr[0] = 0;
        Random rand = new Random();
        for(i = 1; i <n; ++i)
        {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    public void printArray(int arr[])
    {
        int i;
        for(i=1;i<arr.length;++i)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

    protected int findMax(int[]a)
    {
        int max = a[0];
        for(int i = 1; i < a.length; ++i)
        {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }

    protected int[] countingSort (int[] arr)
    {
        int[] outarr = new int [arr.length];
        int max = findMax(arr);
        int[] cumFreq = new int[max+1];

        for(int i = 1; i < arr.length; ++i)
        {
            ++cumFreq[arr[i]];
        }

        for(int i = 1; i <= max; ++i)
        {
            cumFreq[i] += cumFreq[i-1];
        }

        for(int i = arr.length - 1; i >= 1; --i)
        {
            outarr[cumFreq[arr[i]]] = arr[i];
            --cumFreq[arr[i]];
        }

        return outarr;

    }//countingSort()

}
