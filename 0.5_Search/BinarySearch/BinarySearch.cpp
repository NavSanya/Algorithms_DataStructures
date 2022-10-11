#include <iostream>
#include <vector>
#include <time.h>
#include<algorithm>
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

int binarySearch(vector<int>arr, int target, int low, int high)
{
    if(low>high)
        return -1;
    int mid = (low + high) / 2;
    if(target == arr.at(mid))
    {
        return mid;
    }

    if(target < arr.at(mid))
    {
        binarySearch(arr, target, low, mid);
    }

    if(target > arr.at(mid))
    {
        binarySearch(arr, target, mid+1, high);
    } 
}//binarySearch

int main()
{
    cout<<"The array that needs to be searched through\n";
    int size = 10;
    vector<int>vec = initializeArrayWithRandomNumbers(size);
    printVector(vec);

    cout<<"**********BInary Search**********\n";
    srand (time(NULL));
    int tar = (rand()%size+1);
    cout<<"Value to be searched: "<<tar<<endl;
    sort(vec.begin(), vec.end());
    cout<<"Sorted Array\n";
    printVector(vec);
    int ans = binarySearch(vec, tar, 0, vec.size());
    cout<<"Value present on Index: "<<ans<<endl;
    
    return 0;
}//main