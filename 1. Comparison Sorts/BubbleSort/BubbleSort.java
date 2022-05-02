import java.io.*;
import java.util.*;

class BubbleSort
{
    /*
		creating an array of size n
		initializing the arry with random values
	*/
    public int[] initializeArrayWithRandomNumbers(int n)
    {
        int arr[] = new int[n];
        int i;
        Random rand = new Random();
        for(i = 0; i <n; ++i)
        {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    //Swaps the values at position1 and position2 in the array parameter and returns the edited array
    public int[] swap (int[] arr, int position1, int position2)
    {
        int temporary = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temporary;
        return arr;
    }//swap()

    public void printArray(int arr[])
    {
        int i;
        for(i=0;i<arr.length;++i)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }//printArray()

    protected int[] bubbleSort(int[] arr)
    {
        for (int i = 0; i<arr.length; ++i) //length times
        {
            for(int j= arr.length-1; j>=i+1; --j )//length * length times
            {
                if (arr[j]<arr[j-1])
                    arr = swap(arr, j, j-1);
            }//for j loop (inner)
        }//for i loop (outer)
        return arr;
    }//bubbleSort()
}//Class Bubblesort

class Main
{

    public static void main(String args[]) throws IOException
    {
        BubbleSort bs = new BubbleSort();
        int size = 10;
        int arrAns[];
        int arr[] = bs.initializeArrayWithRandomNumbers(size);
        System.out.println("Unsorted Array");
        bs.printArray(arr);

        //Bubble Sort
        System.out.println("**********Bubble Sort**********");
        arrAns = bs.bubbleSort(arr);
        bs.printArray(arrAns);

    }//main()
}//Class Main

