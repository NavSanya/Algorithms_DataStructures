import java.io.*;
import java.util.*;

class QuickSort
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
	
	 /* This function takes middle element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    protected int partitionMiddle (int[] arr, int left, int right)
    {
        int x = arr[left];
        int y=arr[(left+right)/2];
        int z = arr[right];
        int pivot = (x < y ? (y < z ? y : x < z ? z : x) : (x > z ? y : x > z ? z : x));

        int i = left - 1;
        int j = right + 1;

        while (true)
        {
            while (arr[++i] < pivot)
            {
                if (i == right)
                    break;
            }// while i loop (inner)
            while (arr[--j] > pivot)
            {
                if (j == left)
                    break;
            }//while j loop (inner)
            if (i >= j) break;
            arr = swap(arr, i, j);
        }// while true loop (outer)
        return j;
    }//partitionMiddle()


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    protected int[] quickSort (int[] arr, int left,int right)
    {
        int mid;
        if (left<right)
        {
            mid = partitionMiddle(arr, left, right);
            arr = quickSort(arr, left, mid); //sorting the left half
            arr = quickSort(arr, (mid+1), right); //sorting the right half
        }//if

        return arr;
    }//quickSort()
	
}

class Main
{
	public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int size = 10;
        int arrAns[];
        int arr[] = qs.initializeArrayWithRandomNumbers(size);
        System.out.println("Unsorted Array");
        qs.printArray(arr);

        //Bubble Sort
        System.out.println("**********Quick Sort**********");
        arrAns = qs.quickSort(arr,0,size-1);
        qs.printArray(arrAns);	
	}
}
