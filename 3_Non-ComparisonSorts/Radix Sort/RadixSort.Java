import java.io.*;
import java.util.*;

public class RadixSort
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

    protected void countingSort (int[] arr, int exp, int[] outarr)
    {
        int max = findMax(arr);
        int[] cumFreq = new int[max+1];

        for(int i = 1; i < arr.length; ++i)
        {
            ++cumFreq[(arr[i] / exp) % 10];
        }

        for(int i = 1; i <= max; ++i)
        {
            cumFreq[i] += cumFreq[i-1];
        }

        for(int i = arr.length - 1; i >= 1; --i)
        {
            outarr[cumFreq[(arr[i] / exp) % 10]] = arr[i];
            --cumFreq[(arr[i] / exp) % 10];
        }

    }//countingSort()

    protected int[] radixSort(int[] arr)
    {
        int[] outarr= new int[arr.length];
        int m = findMax(arr);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countingSort(arr, exp, outarr);
        return outarr;
    }

}

class MainRadix
{
    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int size = 10;
        int arrAns[];
        int arr[] =rs.initializeArrayWithRandomNumbers(size);
        System.out.println("Unsorted Array");
        rs.printArray(arr);

        //Counting Sort
        System.out.println("**********Radix Sort**********");
        arrAns = rs.radixSort(arr);
        rs.printArray(arrAns);
    }
}
