#include <iostream>
#include <cmath>
#include <vector>
#include <bits/stdc++.h>
#include <time.h>

using namespace std;

vector<int>maxHeapList;

void initializeList(int n)
{
    srand(time(NULL));
	maxHeapList.push_back(INT_MAX);
    for(int i = 1; i < n; ++i)
    {
        maxHeapList.push_back(rand()%n+1);
    }
}

void printList()
{
    for(int i = 1; i < maxHeapList.size(); ++i)
    {
        cout<<maxHeapList.at(i)<<"\t";
    }
    cout<<endl;
}

void swap(int&a, int&b)
{
    int temp = a;
    a = b;
    b = temp;
}

int LeftChild(int i)
{
    return 2 * i;
}

int RightChild(int i)
{
    return(2 * i) + 1;
}

int Parent(int i)
{
    return i / 2;
}
/*
* Maintaining Max Heap Property:-
* Left and Right Subtree is a max heap
* A[i] may be smaller than its children 
*/
void MaxHeapify(int i, int n)
{
    int l = LeftChild(i);
    int r = RightChild(i);
    int largest;

    	if (l < n && maxHeapList.at(l) > maxHeapList.at(i))
	{
		largest = l;
	}
	else
	{
		largest = i;
	}
	if (r < n && maxHeapList.at(r) > maxHeapList.at(largest))
	{
		largest = r;
	}
	if(largest != i)
	{
		swap(maxHeapList.at(i), maxHeapList.at(largest));
		MaxHeapify(largest, n);
	}
	
}

/*
* Convert an array into max heap
*/
void BuildMaxHeap()
{
	int n = maxHeapList.size();
	for(int i = n / 2; i >= 1; --i)
	{
		MaxHeapify(i, n);
	}
}

/*
* Sort an array using heap properties
*/
void HeapSort()
{
	int n = maxHeapList.size();
	BuildMaxHeap();
	for(int i = n - 1; i >= 2; --i)
	{
		swap(maxHeapList.at(1), maxHeapList.at(i));
		MaxHeapify(1, i-1);
	}
}

/*
* Extract the max value 
* Return and delete it from the original list
*/
int extractMax()
{
	int n = maxHeapList.size();
	if(n < 1)
	{
		cout<<"Underflow"<<endl;
		return -999;
	}
  	BuildMaxHeap();
	int max = maxHeapList.at(1);
	maxHeapList.at(1) = maxHeapList.at(n-1);
	MaxHeapify(1, n-1);
	return max;
}

/*
*increase the key of the elemnt on index i
*/
void increaseKey(int i, int key)
{
	if(key<maxHeapList.at(i))
	{
		cout<<"New key smaller than current key"<<endl;
	}
	maxHeapList.at(i) = key;
	while(i > 1 && maxHeapList.at(Parent(i)) < maxHeapList.at(i))
	{
		swap(maxHeapList.at(i), maxHeapList.at(Parent(i)));
		i = Parent(i);
	}
}

/*
*insert new element to the heap
*/
void insertVal(int key)
{
	int n = maxHeapList.size();
	maxHeapList.push_back(key);
	increaseKey(n, key);
}

