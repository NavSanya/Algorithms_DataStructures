#include<iostream>
using namespace std;

class Node
{
        public:
        int val;
        Node* next;

        Node(int v = 0, Node* n = nullptr)
        {
                val = v;
                next = n;
        }
};

class CLL
{
        private:
        Node* start;

        public:
        CLL();
        CLL(Node* s);
        void printList();
        void swap();
        

}