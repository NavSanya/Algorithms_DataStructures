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

vector<int> selectionSort(vector<int>vec)
{
    int smallest, i, j, smallPos;
	for (i=0; i<vec.size();++i)
	{
		smallest = vec.at(i);
		smallPos = i;
		for(j=i+1; j<vec.size(); ++j)
		{
			if(vec.at(j) < smallest)
			{
				smallest = vec.at(j);
				smallPos = j;
			}
		}
		swap(vec.at(i), vec.at(smallPos));
	}
	return vec;
}

int main()
{
    cout<<"The Array to be Sorted\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    cout<<"**********Selection Sort**********\n";
    vector<int>ans = selectionSort(vec);
    printVector(ans);
    
    return 0;
}