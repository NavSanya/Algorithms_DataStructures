#include <iostream>
#include <vector>
#include <cmath>
#include <time.h>
using namespace std;

vector<int> initializeArrayWithRandomNumbers(int n)
{
    srand (time(NULL));
    vector<int> vec;
    for(int i = 0; i<n; ++i)
    {
        vec.push_back(rand()%n+1);
    }

    return vec;
}

void swap(int& val1, int& val2)
{
    int temp = val1;
    val1 = val2;
    val2 = temp;
}

void printVector(vector<int>vec)
{
    for(int i =0; i<vec.size(); ++i)
    {
        cout<<vec.at(i)<<"\t";
    }

    cout<<endl;
}

vector<int> merge(vector<int>&vec, int low, int high, int mid)
{
	int i,j,k;
	int lengthLeft, lengthRight;
    lengthLeft = mid - low + 1;
    lengthRight = high - mid;
	
	vector<int>leftArray;
	leftArray.resize(lengthLeft);
	vector<int>rightArray;
	rightArray.resize(lengthRight);
	for(i=0; i<lengthLeft; ++i)
	{
		leftArray.at(i) = vec.at(low+i);
	}
	
	for(i=0; i<lengthRight; ++i)
	{
		rightArray.at(i) = vec.at(mid+1+i);
	}
	
	i = 0;
	j = 0;
	k = low;
	while (i < lengthLeft && j < lengthRight)
	{
		if(leftArray.at(i) <= rightArray.at(j))
		{
			vec.at(k) = leftArray.at(i);
			i++;
			k++;
		}//if block
		else
		{
			vec.at(k)=rightArray.at(j);
			j++;
			k++;
		}//else block
	}//while loop

	while (i<lengthLeft) //for the remaining elements in the left array
	{
		vec.at(k) = leftArray.at(i);
		++i;
		++k;
	}//while i loop

	while (j<lengthRight)//for the remaining elements in the right array
	{
		vec.at(k) = rightArray.at(i);
		++j;
		++k;
	}//while j loop

	return vec;
}

vector<int> mergeSort(vector<int>&vec, int high, int low)
{
	int mid;
        if(low < high)
        {
            mid = (high + low) / 2;
            vec = mergeSort(vec, high, (mid+1));//redivide the right half
            vec = mergeSort(vec, mid, low);//redivide the left half
            vec = merge(vec, low, high, mid);//merge the sorted halves
        }//if block
        return vec;
}

int main()
{
    cout<<"The Array to be Sorted\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    cout<<"**********Merge Sort**********\n";
    vector<int>ans = mergeSort(vec, size-1, 0);
    printVector(ans);
    
    return 0;
}