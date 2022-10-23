#include<stdio.h>
#include <math.h>
#include<sys/time.h>
#include<time.h>
#include<sys/resource.h>
int qu[100]; 
int count=0;
int place(int k,int i) // checks whether kth queen can be placed in ith column
{
int j;
for(j=1;j<k;j++) // x[j]=i means same column, (x[j]-j) =( j-k) means same diagonal
if((qu[j]==i) ||(abs(qu[j]-i)==abs(j-k))) return(0); // kth queen cannot be placed in ith column
return(1);
}

void nqueen(int k,int n)
{
    for(int i=1;i<=n;i++)
    {
        if(place(k,i))
        {
            qu[k] = i;
            if(k == n)
            {
                count++;
                for(int j=1;j<=n;j++)
                {
                    for(int q=1;q<=n;q++)
                    {
                        if(qu[j] == q)
                        {
                            printf(" q ");
                        }
                        else
                        {
                            printf(" 0 ");
                        }
                        
                    }
                    printf("\n");
                }
            }
            else
            {
                nqueen(k+1,n);
            }
        }
        
    }
    printf("\n");
}
int main()
{
    struct timeval tv1, tv2;
    struct rusage r_usage;
    int n;
    printf("Enter the no. of nqueens\n");
    scanf("%d",&n);
    gettimeofday(&tv1, NULL);
    nqueen(1,n);
    gettimeofday(&tv2, NULL);
    if(count == 0)
    {
        printf("No solutions exist\n");
    }
    else
    {
        printf("No. of solutions of nqueens is %d\n",count);
    }

    printf("\nTime =%f microseconds\n",(double)(tv2.tv_usec-tv1.tv_usec));//in microseconds
    //printf ("Time = %f seconds\n", (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 + (double) (tv2.tv_sec - tv1.tv_sec));
    getrusage(RUSAGE_SELF,&r_usage);
    printf("\nMemory usage: %ld kilobytes\n",r_usage.ru_maxrss);
    
}