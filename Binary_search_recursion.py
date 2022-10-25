##Complexity = O(log(n))

def search(l,a,beg,end):
    mid = (beg+end)//2
    if l[mid] == a:
        print(f"Element found at index position: {mid}")
    else:
        if x<l[mid]:
            end = mid-1
        else:
            beg = mid+1 

        if beg<=end:
            search(l,a,beg,end)
        else:
            print("Element not found")      

n = int(input("Enter the number of elements: "))

l = list(map(int,input().split()))

l.sort()

x = int(input("Enter the element to be found: "))

search(l,x,0,n-1)