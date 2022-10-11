import java.io.*;
import java.util.*;

class SelectionSort
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
    } 
    
    protected int[] selectionSort(int[] arr)
    {
        int smallest,i,j, SmallestPosition;
        // One by one move boundary of unsorted subarray
        for(i=0; i<((arr.length)-1); ++i)
        {
            smallest = arr[i];
            SmallestPosition = i;
            // Find the minimum element in unsorted array
            for (j=i+1; j < arr.length; ++j)
            {
                if (arr[j] < smallest)
                {
                    smallest = arr[j];
                    SmallestPosition = j;
                }//if block
            }//for j loop (inner)
            // Swap the found minimum element with the first element
            arr = swap (arr, i, SmallestPosition);
        }//for i loop (outer)
        return arr;
    }//selectionSort()
}
class Main
{
	public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int size = 10;
        int arrAns[];
        int arr[] = ss.initializeArrayWithRandomNumbers(size);
        System.out.println("Unsorted Array");
        ss.printArray(arr);

        //Bubble Sort
        System.out.println("**********Selection Sort**********");
        arrAns = ss.selectionSort(arr);
        ss.printArray(arrAns);	
	}
}
