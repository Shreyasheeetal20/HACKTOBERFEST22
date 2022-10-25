#include <iostream>
using namespace std;

void printArray( int pArray[], int pArrayLength )
{
    for (int i = 0; i < pArrayLength; i++)
    {
        cout << pArray[i] << endl;
    }
}

int * arrayBubbleSort( int pArray[], int pArrayLength )
{

    int temp;


    for (int i = 0; i < pArrayLength; i++)
    {
        for (int j = 0; j < pArrayLength-1; j++) // why do I put a -1 here..?
        {
            if (pArray[j] > pArray[j+1])
            {
                temp = pArray[j];
                pArray[j] = pArray[j+1];
                pArray[j+1] = temp;
            }
        }
    }

    return pArray;
}

int main()
{

    cout << "Enter length of array:" << endl;

    int uInputArrayLength;
    cin >> uInputArrayLength; // enter the length of array

    const int uArrayLength = 5;
    int uArray[uArrayLength];

    cout << "Enter array elements:" << endl;

    for (int i = 0; i < uArrayLength; i++)
    {
        int t;
        cin >> t;
        uArray[i] = t;
    }

    int *returnArray = arrayBubbleSort(uArray, uArrayLength);

    printArray(returnArray, uArrayLength);

}