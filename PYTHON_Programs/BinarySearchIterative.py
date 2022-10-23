#its an iterative binary search
def binary_search(input_array, value):
    end=(len(input_array)-1)
    start=0
    flag=True
    
    while abs(start-end)>=1:
        mid=(start+end)//2
        if input_array[mid]<value:
            start=mid
        elif input_array[mid]>value:
            end=mid
        else:
            flag=False
            return mid
        
    return -1

test_list = [1,3,9,11,15,19,29]
test_val1 = 25
test_val2 = 15
print (binary_search(test_list, test_val1))
print (binary_search(test_list, test_val2))
