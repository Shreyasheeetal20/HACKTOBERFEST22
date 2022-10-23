import java.util.Arrays;
import java.util.Scanner;

class Bubblesort {
    static void bubbleSort(int array[]) {
    int size = array.length;
    for(int i = 0; i < size - 1; i++)
      for(int j = 0; j < size - i - 1; j++)
        if(array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no. of elements: ");
        int n = scan.nextInt();
        int[] data = new int[n];
        System.out.println("Enter data: ");
        for(int i = 0; i < n; i++) {
            data[i] = scan.nextInt();
        }
        Main.bubbleSort(data);
        System.out.println("Sorted Array in Ascending Order using bubble sort:");
        System.out.println(Arrays.toString(data));
    }
}
