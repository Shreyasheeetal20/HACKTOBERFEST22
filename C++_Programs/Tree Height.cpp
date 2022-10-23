// C++ Program to find height of the tree.
// using Bottom-Up Dynamic Programming (Tabulation).

#include <bits/stdc++.h>
using namespace std;

const int N = 1e5; // max number of nodes.

vector<int> adj[N]; // Adjacency list
vector<bool> vis;   // Visited Array
vector<int> dp;     // DP Array

void dfs(int u)
{
    vis[u] = true;
    int child_height = 1;
    for (int v : adj[u])
    {
        if (!vis[v])
        {
            dfs(v);
            // selecting maximum sub-tree height from all children.
            child_height = max(child_height, dp[v] + 1);
        }
    }
    // Current visited node is assigned with the max child height.
    dp[u] = child_height;
}

int main()
{
    int nodes; // number of nodes
    cout << "Enter number of nodes of the tree : " << endl;
    cin >> nodes;
    int u, v; // u, v denotes an undirected edge of tree.

    cout << "Enter edges of the tree : " << endl;
    for (int i = 0; i < nodes - 1; i++)
    {
        cin >> u >> v;
        adj[u].push_back(v); // u -> v
        adj[v].push_back(u); // v -> u
    }

    vis.assign(nodes + 1, false); // initializing all nodes as unvisited.
    dp.assign(nodes + 1, 0);      // initialize depth of all nodes to 0.
    dfs(1);                       // function call which will initialize the height of all nodes.

    cout << "Height of the Tree : " << dp[1] << endl;
}