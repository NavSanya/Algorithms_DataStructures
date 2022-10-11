#include "Graphs.hpp"

void Graph::BFS(int start)
{
	vector<int>visited(numNodes, 0);
	queue<int>q;
	
	q.push(start);
	while(!q.empty())
	{
		int curr = q.front();
		cout << curr << "\t";
		q.pop();
		
		for(int i = 0; i < graph.at(curr).size(); ++i)
		{
			if(graph.at(curr).at(i) > 0 && visited.at(i) == 0)
			{
				q.push(i);
				visited.at(i)++;
				
			}
		}
	}
}



int main()
{
	int numVertices;
	
	return 0;
}