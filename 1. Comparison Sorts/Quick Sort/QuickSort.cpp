#include <iostream>
#include <vector>
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

int partitionMiddle(vector<int>&vec, int left, int right)
{
	int x = vec.at(left);
	int y = vec.at((left+right)/2);
	int z = vec.at(right);
	int pivot = (x < y ? (y < z ? y : x < z ? z : x) : (x > z ? y : x > z ? z : x));


	int i = left-1;
	int j = right+1;
	
	while(true)
	{
		while(vec.at(++i) < pivot)
		{
		    if(i == right)
		    break;
		}
		
		while(vec.at(--j) > pivot)
		{
		    if(j == left)
		    break;
		}
		
		if(i >= j) 			
		    break;
		swap(vec.at(i), vec.at(j));
	}
	return j;
}

vector<int> quickSort (vector<int>&vec, int left, int right)
{
	int mid;
	if(left < right)
	{
		mid = partitionMiddle(vec, left, right);
		vec = quickSort(vec, left, mid);
		vec = quickSort(vec, mid+1, right);
	}
	return vec;
}

int main()
{
    cout<<"The Array to be Sorted\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    cout<<"**********Quick Sort**********\n";
    quickSort(vec, 0, 9);
    printVector(vec);
    
    return 0;
}