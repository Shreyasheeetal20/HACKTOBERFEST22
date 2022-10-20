def spiral(row,column,arr):
    rowstart=0;columnstart=0
    while (rowstart<row and columnstart<column):
        for i in range(rowstart,row):
            print(arr[i][columnstart],end=" ")
        columnstart=columnstart+1
        for i in range(columnstart,column):
            print(arr[row-1][i],end=" ")
        row=row-1
        if(rowstart<row):
            for i in range(row-1,rowstart-1,-1):
                print(arr[i][column-1],end=" ")
            column=column-1
        if(columnstart<column):
            for i in range(column-1,columnstart-1,-1):
                print(arr[rowstart][i],end=" ")
            rowstart=rowstart+1
matrix=[[1,2,3],
        [5,6,7],
        [9,10,11]]
row=3
column=3
spiral(row,column,matrix)

                