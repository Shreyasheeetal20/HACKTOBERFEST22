#include<bits/stdc++.h>

using namespace std ;

signed main(){

    int n , m ;
    cin >> n >> m ;

    vector<pair<int,int>> graph(n) ;

    int a , b , wt ;

    for(int i = 0 ; i < m ; i++){
        cin >> a >> b >> wt ;

        graph[a].push_back(make_pair(b,wt)) ;
        graph[b].push_back(make_pair(a,wt)) ;
    }

    vector<int> key(n , INT_MAX) ;
    vector<int> parent(n) ;

    vector<bool> mstSet(n , false) ;

    key[0] = 0 ;
    parent[0] = -1 ;

    priority_queue<pair<int,int> , vector<pair<int,int>> , greater<pair<int,int>>> pq ;

    pq.push({0,0}) ;

    while (!pq.empty())
    {
        /* code */
        int u = pq.top().second ;
        pq.pop() ;

        mstSet[u] = true ;

        for(auto it : graph[u]){
            int v = it.first ;
            int weight = it.second ;

            if(mstSet[v] == false and weight < key[v]){
                key[v] = weight ;
                parent[v] = u ;

                pq.push({key[v] , v}) ;
            }
        }
    }
    
}