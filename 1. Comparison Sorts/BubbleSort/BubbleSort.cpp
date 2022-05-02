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
}//initializeArrayWithRandomNumbers

void swap(int& val1, int& val2)
{
    int temp = val1;
    val1 = val2;
    val2 = temp;
}//swap

void printVector(vector<int>vec)
{
    for(int i =0; i<vec.size(); ++i)
    {
        cout<<vec.at(i)<<"\t";
    }

    cout<<endl;
}//printVector

vector<int> bubbleSort(vector<int>vec)
{
    for(int i = 0; i< vec.size(); ++i)
    {
        for(int j = vec.size()-1; j>=i+1; --j)
        {
            if(vec.at(j) < vec.at(j-1))
                swap(vec.at(j), vec.at(j-1));
        }
    }
    return vec;
}//bubbleSort

int main()
{
    cout<<"The Array to be Sorted\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    cout<<"**********Bubble Sort**********\n";
    vector<int>ans = bubbleSort(vec);
    printVector(ans);
    
    return 0;
}//main