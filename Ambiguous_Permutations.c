#include <stdio.h>

int main(void) {
      while(1){
            int n;
            scanf("%d",&n);
            if(n==0)
            break;
            int a[n+1],b[n+1],am=0;
            for(int i=1;i<n+1;i++){
            scanf("%d",&a[i]);
            b[i]=1;
            }
            for(int i=1;i<n+1;i++){
                  b[a[i]]=i;
            }
            for(int i=1;i<n+1;i++)
            {
                  if(a[i]!=b[i]){
                        am=1;
                        break;
                  }
            }
            if(am==1)
            printf("not ambiguous\n");
            else
            printf("ambiguous\n");
         //   printf("\n");
      }
	return 0;
}

