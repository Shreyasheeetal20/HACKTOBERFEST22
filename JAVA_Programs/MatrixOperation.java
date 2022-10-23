package college_programs;
import java.util.*;
public class MatrixOperation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row numbers or column numbers : ");
        int index = sc.nextInt();
        int[][] matrix1 = new int[index][index];
        int[][] matrix2 = new int[index][index];

        operation op = new operation();
        matrix1 = op.create(index);
        op.display(matrix1,index);

        matrix2 = op.create(index);
        op.display(matrix2,index);

        while(true)
        {
            System.out.println("Enter your choice : ");
            System.out.println("1)Addition"+"\n"+"2)Subtraction"+"\n"+"3)Multiplication"+"\n"+"4)Division"+"\n"+"5)Scalar multiplication for matrix 1"+"\n"+"6)Scalar multiplication for matrix 2"+"\n"+"7)Transpose of 1st matrix"+"\n"+"8)Transpose of 2nd matrix");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1 -> {
                    int[][] result1 = op.addition(matrix1, matrix2, index);
                    op.display(result1,index);
                }
                case 2 -> {
                    int[][] result2 = op.subtraction(matrix1, matrix2, index);
                    op.display(result2,index);
                }
                case 3 -> {
                    int[][] result3 = op.multiplication(matrix1, matrix2, index);
                    op.display(result3,index);
                }
                case 4 -> {
                    int[][] result4 = op.division(matrix1, matrix2, index);
                    op.display(result4,index);
                }
                case 5 -> {
                    int[][] result5 = op.scalar_multi1(matrix1, matrix2, index);
                    System.out.println("Scalar multiplication of first matrix is :");
                    op.display(result5,index);
                }
                case 6 -> {
                    int[][] result6 = op.scalar_multi2(matrix1, matrix2, index);
                    System.out.println("Scalar multiplication of Second matrix is :");
                    op.display(result6,index);
                }
                case 7 -> {
                    int[][] result7 = op.transpose1(matrix1, matrix2, index);
                    System.out.println("Transpose of first matrix is : ");
                    op.display(result7,index);
                }
                case 8 -> {
                    int[][] result8 = op.transpose2(matrix1, matrix2, index);
                    System.out.println("Transpose of second matrix is : ");
                    op.display(result8,index);
                }
                default -> System.out.println("Enter the valid choice...!!!!");
            }
        }
    }
}
 class operation
{
    public int[][] create(int index)
    {
        int n = (int)index;

        int[][] matrix = new int[n][n];
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter the matrix(%d * %d) : ",n,n);
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++ )
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public void display(int[][] matrix,int index)
    {
        int n = (int)index;
        System.out.println("matrix is : ");
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++ )
            {
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] addition(int[][] matrix1,int[][] matrix2,int index)
    {
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
     return matrix3;
    }
    public int[][] subtraction(int[][] matrix1,int[][] matrix2,int index)
    {
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrix3;
    }
    public int[][] multiplication(int[][] matrix1,int[][] matrix2,int index)
    {
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrix3;
    }
    public int[][] division(int[][] matrix1,int[][] matrix2,int index)
    {
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                     matrix3[i][j] = matrix1[i][j] / matrix2[i][j];
            }
        }
        return matrix3;
    }
    public int[][] scalar_multi1(int[][] matrix1,int[][] matrix2,int index)
    {
        Scanner sc = new Scanner(System.in);
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        System.out.println("Enter the no. to multiply the matrix : ");
        int no = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix3[i][j] = no * matrix1[i][j];
            }
        }
        return matrix3;
    }
    public int[][] scalar_multi2(int[][] matrix1,int[][] matrix2,int index)
    {
        Scanner sc = new Scanner(System.in);
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        System.out.println("Enter the no. to multiply the matrix : ");
        int no = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix3[i][j] = no * matrix2[i][j];
            }
        }
        return matrix3;
    }
    public int[][] transpose1(int[][] matrix1,int[][] matrix2,int index)
    {
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix3[i][j]=matrix1[j][i];
            }
        }
        return matrix3;
    }
    public int[][] transpose2(int[][] matrix1,int[][] matrix2,int index)
    {
        int n = (int)index;
        int[][] matrix3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix3[i][j]=matrix2[j][i];
            }
        }
        return matrix3;
    }
}




