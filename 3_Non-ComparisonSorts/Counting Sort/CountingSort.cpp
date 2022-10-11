#include <iostream>
#include <vector>
#include <time.h>
#include <algorithm>
using namespace std;

vector<int> initializeArrayWithRandomNumbers(int n)
{
    srand (time(NULL));
    vector<int> vec;
    vec.push_back(0);
    for(int i = 1; i < n+1; ++i)
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
    for(int i = 1; i<vec.size(); ++i)
    {
        cout<<vec.at(i)<<"\t";
    }

    cout<<endl;
}

int findMax(vector<int> a)
{
    int max = a.at(0);
    for(int i = 1; i < a.size(); ++i)
    {
        if (max < a.at(i))
        max = a.at(i);
    }
    return max;
}

void countingSort(vector<int>&invec, vector<int>&cumulativeSum, vector<int>&outvec)
{
    int max = findMax(invec);// find the max element in the input vector
    cumulativeSum.resize(max+1);
    outvec.resize(invec.size());

    for(int i = 0; i <= max; ++i)
    {
        cumulativeSum.at(i) = 0;
    }

    for(int i = 1; i < invec.size(); ++i)
    {
        ++ cumulativeSum.at(invec.at(i));
    }

    for(int i = 1; i <= max; ++i)
    {
        cumulativeSum.at(i) += cumulativeSum.at(i-1);
    }

    for(int i = invec.size() - 1; i >= 1; --i)
    {
        outvec.at(cumulativeSum.at(invec.at(i))) = invec.at(i);
        -- cumulativeSum.at(invec.at(i));
    }

}

int main()
{
    cout<<"The Array to be Sorted\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    vector<int>answer(size);
    vector<int>cumulative;

    cout<<"**********Counting Sort**********\n";
    countingSort(vec, cumulative, answer);
    printVector(answer);
    
    return 0;
}