#include <iostream>
#include <vector>
#include <time.h>
#include <queue>
#include <fstream>
using namespace std;


class Graph
{
    public:
        vector<vector<int>>graph;
		vector<int>parent;
		vector<int>cost;
		int numNodes;

    public:
		Graph(vector<vector<int>g = {},vector<int>p = {}, vector<int>c = {}, int n = 0)
		{
			if(g.size==0)
			{
				graph.resize(n);
				for(int i = 0; i < n; ++i)
				{
					graph.at(i).resize(n+1);
				}
			}
			else
			{
				graph = g;
			}
			
			if(p.size==0)
			{
				parent.resize(n);
			}
			else
			{
				parent = p;
			}
			
			if(c.size==0)
			{
				cost.resize(n);
			}
			else
			{
				cost = c;
			}
			
			numNodes = n;
		}

        void inputGraph()
        {
            ifstream infile("");//file name
            int a, b, c;//vertices and cost
            int n; //number of vertices

            if(infile>>n)
            {
                numNodes = n;
                while(infile>>a>>b>>c)
                {
                    for(int i=0;i<n;++i) {
                        for (int j = 0; j < n; ++j) {
                            graph[a - 1][b - 1] = c;
                        }
                    }
                }
            }

        }

        void printGraph()
        {
            for(int i=0;i<numNodes;++i) {
                for(int j=0;j<numNodes;++j) {
                    cout<<Graph[i][j]<<"\t";
                }
                cout<<endl;
            }
        }
		
		void addEdge(int a, int b, int weight = 1)
		{
			graph.at(a).at(b) = weight;
			graph.at(b).at(a) = weight;
		}
		

        //Uninformed Search
        void BFS(int start);

        void DFS(int start);
        void init();

        void UniformedCostSearch(int start);

        void BidirectionalSearch(int start, int goal);

        //Informed Search
        void BestFirstSearch();
        
        void A_star();

        void hillclimbing();

        void geneticAlgo();
        
};