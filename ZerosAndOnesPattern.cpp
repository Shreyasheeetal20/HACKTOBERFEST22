#include <iostream>
using namespace std;

int main()
{
    int row;
    cout << "Enter the size of Row: ";
    cin >> row;

    for (int i = 1; i <= row; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            if (j % 2 == 0)
            {
                cout << (0);
            }
            else
            {
                cout << (1);
            }
        }
        cout << ("\n");
    }
}