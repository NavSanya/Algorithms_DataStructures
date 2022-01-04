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

vector<int> insertionSort(vector<int>vec)
{
	int i,j,key;
	for(i=1; i<vec.size(); ++i)
	{
		key = vec.at(i);
		j = i-1;
		while(j>=0&&vec.at(j)>key)
		{
			vec.at(j+1) = vec.at(j);
			--j;
		}
		
		vec.at(j+1) = key;
	}
	return vec;
}

int main()
{
    cout<<"The Array to be Sorted\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    cout<<"**********Insertion Sort**********\n";
    vector<int>ans = insertionSort(vec);
    printVector(ans);
    
    return 0;
}