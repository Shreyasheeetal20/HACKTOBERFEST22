// Insertion sort in C++

#include <bits/stdc++.h>
using namespace std;

void insertionSort(vector<int> &v, int n)
{
    for (int i = 1; i < n; i++)
    {
        int key = v[i];
        int j = i - 1;

        while (key < v[j] && j >= 0)
        {
            v[j + 1] = v[j];
            j--;
        }
        v[j + 1] = key;
    }
}

void printArray(vector<int> v, int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << v[i] << " ";
    }
    cout << endl;
}

int main()
{
    int n;
    cout << "Enter the size of the array : ";
    cin >> n;
    vector<int> numbers(n);
    cout << "Enter the elements of the Array : ";
    for (auto i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        numbers[i] = x;
    }
    insertionSort(numbers, n);
    cout << "Sorted array in ascending order : ";
    printArray(numbers, n);
}