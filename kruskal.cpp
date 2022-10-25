#include <bits/stdc++.h>
using namespace std;

int findSet(int p[], int i)
{
    while (p[i] > 0)
        i = p[i];
    return i;
}

void unionSet(int p[], int i, int j)
{
    p[j] = i;
}

void display(vector<pair<int, pair<int, int>>> E)
{
    for (int i = 0; i < E.size(); i++)
    {
        cout << E[i].second.first << " ";
        cout << E[i].second.second << " ";
        cout << E[i].first << endl;
    }
}

void kruskal(vector<pair<int, pair<int, int>>> E, vector<int> V)
{
    vector<pair<int, pair<int, int>>> ans;
    int totalCost = 0, j = 0;
    int p[V.size() + 1];
    for (int i = 0; i <= V.size(); i++)
        p[i] = -1;

    for (int i = 0; i < E.size(); i++)
    {
        if (j >= V.size())
            break;
        int p1 = findSet(p, E[i].second.first);
        int p2 = findSet(p, E[i].second.second);
        if (p1 != p2 || p1 == p2 == -1)
        {
            ans.push_back(E[i]);
            totalCost += E[i].first;
            unionSet(p, p1, p2);
            j++;
        }
    }
    if (j == V.size() - 1)
    {
        display(ans);
        cout << "Total cost: " << totalCost << endl;
    }
}

int main()
{
    vector<int> V = {1, 2, 3, 4, 5, 6, 7};
    vector<pair<int, pair<int, int>>> E;

    E.push_back({28, {1, 2}});
    E.push_back({16, {2, 3}});
    E.push_back({12, {3, 4}});
    E.push_back({22, {4, 5}});
    E.push_back({25, {5, 6}});
    E.push_back({24, {5, 7}});
    E.push_back({18, {4, 7}});
    E.push_back({14, {2, 7}});
    E.push_back({10, {1, 6}});

    sort(E.begin(), E.end());

    cout << "Graph: " << endl;
    display(E);

    cout << "\nMCST: " << endl;
    kruskal(E, V);
    return 0;
}