num= 3

s = bin(num)

a = str(s)

b = a.count("1")

if(b % 2 == 0):

    print("Evil number")

else:

    print("Odious number")