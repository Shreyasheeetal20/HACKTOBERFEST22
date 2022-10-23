// Heap Sort Code in C++

#include <bits/stdc++.h>
using namespace std;

void printArray(vector<int> &v)
{
    for (auto i : v)
    {
        cout << i << " ";
    }
    cout << endl;
}

void heapify(vector<int> &v, int n, int i)
{
    int Largest = i;
    int Left_Child = 2 * i + 1;
    int Right_Child = 2 * i + 2;

    if (Left_Child < n && v[Left_Child] > v[Largest])
        Largest = Left_Child;

    if (Right_Child < n && v[Right_Child] > v[Largest])
        Largest = Right_Child;

    if (Largest != i)
    {
        swap(v[i], v[Largest]);
        heapify(v, n, Largest);
    }
}

void heapSort(vector<int> &v, int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(v, n, i);

    for (int i = n - 1; i >= 0; i--)
    {
        swap(v[0], v[i]);
        heapify(v, i, 0);
    }
}

int main()
{
    int n;
    cout << "Enter the size of Array : ";
    cin >> n;
    vector<int> numbers(n);
    cout << "Enter the elements of the array : ";
    for (auto i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        numbers[i] = x;
    }
    heapSort(numbers, n);
    cout << "Sorted array : ";
    printArray(numbers);
}
