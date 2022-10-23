# Code by Atharv Patil IIIT Pune

print("Enter the number where you want to mark your sign(X/O)")
print('''1 2 3
4 5 6
7 8 9''')
count = space = draw = 0
c = 0
k = 1
while c == 0:
    if k == 1:
        A = [1]
        B = [2]
        C = [3]
        D = [4]
        E = [5]
        F = [6]
        G = [7]
        H = [8]
        I = [9]
        k = 0

    count += 1
    if count % 2 == 1:
        x = 1
    if count % 2 != 1:
        x = 2
    print("Player", x, end=" ")

    a = (input("Enter the position of marking(1-9):"))

    for i in (A, B, C, D, E, F, G, H, I):

        if i[0] == int(a):
            if x == 1:
                i.clear()
                i.append("O")
            if x == 2:
                i.clear()
                i.append('X')

    for i in (A, B, C, D, E, F, G, H, I):

        print(i[0], end=" ")
        space += 1

        if space % 3 == 0:
            print()

        if space == 81:
            print("The round is DRAWN!!!")
            space = 0
            k = 1
            cond = input("If you want to play next round"
                         "(y/n):")
            if cond == "n":
                c = 1
                print()
                print("THANK YOU for playing this game")
                break
            elif cond == "y":
                c = 0
                print()
                print("WELCOME AGAIN")
                print('''1 2 3
4 5 6
7 8 9''')

    if space > 4:
        if A == B == C or D == E == F or G == H == I or A == D == G or B == E == H or C == F == I or A == E == I or C == E == G:
            print("CONGRATATION Player", x, end=" ")
            print("you won")
            space = 0
            k = 1

            cond = input("If you want to play again(y/n):")
            if cond == "n":
                c = 1
                print()
                print("THANK YOU for playing the game")
                break

            elif cond == "y":
                c = 0
                print()
                print("WELCOME AGAIN")
                print('''1 2 3
4 5 6
7 8 9''')
