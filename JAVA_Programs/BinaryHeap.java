public class BinaryHeap {
    static class binaryHeap
    {
        int arr[];
        int size;


        //creation

        public binaryHeap(int size)
        {
            arr = new int[size+1];
            this.size = 0;
            System.out.println("Binary heap created");
        }

        public boolean isEmpty()
        {
            if(size == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //peek

        public Integer peek()
        {
            if(isEmpty())
            {
                System.out.println("Empty heap");
                return null;
            }
            return arr[1];
        }

        public int sizeOfHeap()
        {
            return size;
        }

        //traversal

        public void levelOrder()
        {
                for(int i=1;i<=size;i++)
                {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
        }

        //INSERT 

        //heapify

        public void heapifyBottomToTop(int index, String heapType) {
            int parent = index / 2;
            if (index <= 1 ) {
              return;
            }
            if (heapType == "Min") {
              if (arr[index] < arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
              }
            } else if (heapType == "Max") {
              if (arr[index] > arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
              }
            }
            heapifyBottomToTop(parent, heapType);
        
          }

        public void insert(int value, String typeHeap) {
            arr[size+1] = value;
            size++;
            heapifyBottomToTop(size, typeHeap);
            System.out.println("Inserted " +value+ " successfully in Heap");
          }

          //delete

          //heapify top to bottom

          public void heapifyTopToBottom(int index, String type)
          {
            int left = index*2;
            int right = index*2 + 1;
            int swapChild=0;
            if(size < left)
            {
                return;
            }
            if(type == "Max")
            {
                if(size == left)
                {
                    if(arr[index] < arr[left])
                    {
                        int temp = arr[index];
                        arr[index] = arr[left];
                        arr[left] = temp;
                    }
                    return;
                }
                else{
                    if(arr[left] > arr[right])
                    {
                        swapChild = left;
                    }
                    else{
                        swapChild = right;
                    }

                    if(arr[index]< arr[swapChild])
                    {
                        int temp = arr[index];
                        arr[index] = arr[swapChild];
                        arr[swapChild] = temp;
                    }
                }
            }
            else if(type == "Min")
            {
                if(size == left)
                {
                    if(arr[index] > arr[left])
                    {
                        int temp = arr[index];
                        arr[index] = arr[left];
                        arr[left] = temp;
                    }
                    return;
                }
                else{
                    if(arr[left] < arr[right])
                    {
                        swapChild = left;
                    }
                    else{
                        swapChild = right;
                    }

                    if(arr[index]> arr[swapChild])
                    {
                        int temp = arr[index];
                        arr[index] = arr[swapChild];
                        arr[swapChild] = temp;
                    }
                }
            }
            heapifyTopToBottom(swapChild, type);
          }

          //extract head
          public int extractHead(String heapType)
          {
              if(isEmpty())
              {
                  return -1;
              }
              else{
                  int extractedValue = arr[1];
                  arr[1] = arr[size];
                  size--;
                  heapifyTopToBottom(1, heapType);
                  return extractedValue;
              }
          }

          // delete
  public void deleteBH() {
    arr = null;
    System.out.println("BH has been successfully deleted");
  }

    }

    public static void main(String[] args)
    {
        binaryHeap bh = new binaryHeap(4);
        bh.insert(10, "Max");
        bh.insert(5, "Max");
        bh.insert(15, "Max");
        bh.insert(1, "Max");
        System.out.println(bh.sizeOfHeap());
        bh.levelOrder();
        bh.extractHead("Max");
        bh.levelOrder();
    }

}
