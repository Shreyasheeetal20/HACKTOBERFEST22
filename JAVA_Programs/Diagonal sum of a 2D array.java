/*2D Array program 1
 *Diagonal sum of a 2D array */
class Diagonal_Sum
  {
     public static void abc(int a[][])
      {
        int lr,lc;
        lr= a.length;
        lc = a[0].length;
        // Checking square array or not
        if(lr!=lc)
          System.out.println("The array is not a square array");
        
        else
          {
            for(int i=0;i<lr; i++)
             {
               for(int j=0;j<lc; j++)
                {
                  System.out.print(a[i][j]+ "\t");
                }
               System.out.println();
             }
            // Diagonal sum
            int sr=0, sl=0;
            for(int i=0,j=0,k=(lr-1); i<lr; i++,j++,k--)
             {
               sr+=a[i][j];
               sl+=a[i][k];
             }
            System.out.println("The sum of the array elements of right diagonal = "+sr);
            System.out.println("The sum of the array elements of left diagonal = "+sl);
          }
      }
  }
