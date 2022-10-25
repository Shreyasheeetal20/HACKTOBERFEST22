#include <iostream>
#include <iterator>
using namespace std;

int * arraySorting(int pArray[], int pArrayLength)
{
    int temp;

    for (int i = 0; i < pArrayLength-1; i++)
    {
        for (int j = 0; j < pArrayLength-1; j++)
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

void printArray(int pArray[], int pArrayLength)
{
    for (int i = 0; i < pArrayLength; i++)
    {
        cout << pArray[i] << endl;
    }
}

int binaryArraySearch(int pArray[], int elementToFind, int lowerBound, int upperBound)
{
    int midSection = (lowerBound + upperBound) / 2;

    if (pArray[midSection] == elementToFind)
    {
        return midSection;
    }
    if (pArray[midSection] < elementToFind)
    {
        return binaryArraySearch(pArray, elementToFind, midSection+1, upperBound);
    }
    if (pArray[midSection] > elementToFind)
    {
        return binaryArraySearch(pArray, elementToFind, lowerBound, midSection-1);
    }

    return -1;
}

int main()
{
    const int uArrayLength = 5;
    int uArray[uArrayLength] = { 1, 2, 3, 5, 4 };

    printArray(uArray, uArrayLength);

    int *sortedArray;
    sortedArray = arraySorting(uArray, uArrayLength);

    cout << "\nbreak\n" << endl;
    printArray(sortedArray, uArrayLength);

    cout << "\nbreak\n" << endl;

    int indexPosition = binaryArraySearch(sortedArray, 1, 0, uArrayLength);

    cout << indexPosition << endl;

}