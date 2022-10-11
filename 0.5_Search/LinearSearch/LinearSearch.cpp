#include <iostream>
#include <vector>
#include <time.h>
using namespace std;

/*
		creating an array of size n
		initializing the array with random values
*/
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

void printVector(vector<int>vec)
{
    for(int i =0; i<vec.size(); ++i)
    {
        cout<<vec.at(i)<<"\t";
    }

    cout<<endl;
}//printVector

int linearSearch(vector<int>arr, int target)
{
    for(int i = 0; i<arr.size(); ++i)
    {
        if(target == arr.at(i))
            return i;
    }
    return -1;
}//linearSearch

int main()
{
    cout<<"The array that needs to be searched through\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    cout<<"**********Linear Search**********\n";
    srand (time(NULL));
    int tar = (rand()%size+1);
    cout<<"Value to be searched: "<<tar<<endl;
    int ans = linearSearch(vec, tar);
    cout<<"Value present on Index: "<<ans<<endl;
    
    return 0;
}//main