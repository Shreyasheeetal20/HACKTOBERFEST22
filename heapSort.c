#include <stdio.h>
#include <sys/time.h>
#include <time.h>
#include <sys/resource.h>
void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void heap(int arr[], int n, int i)
{
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest])
        largest = l;

    if (r < n && arr[r] > arr[largest])
        largest = r;

    if (largest != i)
    {
        swap(&arr[i], &arr[largest]);

        heap(arr, n, largest);
    }
}

void heapsort(int arr[], int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
    {
        heap(arr, n, i);
    }
    for (int i = n - 1; i >= 0; i--)
    {
        swap(&arr[0], &arr[i]);
        heap(arr, i, 0);
    }
}

int main()
{
    struct timeval tv1, tv2;
    struct rusage r_usage;
    int n;
    printf("Enter the size of array\n");
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    gettimeofday(&tv1, NULL);
    heapsort(arr, n);
    gettimeofday(&tv2, NULL);
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");

    printf("\nTime of Heap Sort =%f microseconds\n", (double)(tv2.tv_usec - tv1.tv_usec)); //in microseconds
    //printf ("Time = %f seconds\n", (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 + (double) (tv2.tv_sec - tv1.tv_sec));
    getrusage(RUSAGE_SELF, &r_usage);
    printf("\nMemory usage: %ld kilobytes\n", r_usage.ru_maxrss);

    return 0;
}
