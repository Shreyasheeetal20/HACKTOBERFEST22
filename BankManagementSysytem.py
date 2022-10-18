# Code by Atharv Patil

import mysql.connector as ship

mycon = ship.connect(user='root', passwd='1111',
                     host='localhost', database='project')

cursor = mycon.cursor()
print("\t\t===============================================================================")
print("\t\t\t\t\t\tBANK MANAGEMENT SYSTEM")
print("\t\t===============================================================================")


def MENU():
    print("\t---------------------------")
    print("\tMAIN MENU")
    print("\t---------------------------")
    print('\t1. Insert Record')
    print('\t2. Display records as per Account number')
    print('\t3. Search Record Details as per the account number')
    print('\t4. Update Record')
    print('\t5. Delete Record')
    print('\t6. Transactions from the account')
    print('\t7. Exit')
    print('='*148)


def MenuTransactions():
    print(" a. Debit/Withdraw from the account")
    print(" b. Credit into the account")
    print(" c. Back to MAIN MENU")


def Create():
    try:
        cursor.execute('Create table BOB( ACCNO varchar(20), NAME varchar(20), PHONE varchar(20), EMAILID varchar(50), ADDRESS varchar(50), CITY varchar(15), COUNTRY varchar(20), Balance int(10))')
        cursor.fetchall()
        print('Table Created')
        Insert()
    except:
        Insert()


def Insert():
    while True:
        def A():
            global Acc
            Acc = input("Enter the Account No. ")
            l = "select accno from BOB"
            cursor.execute(l)
            ad = cursor.fetchall()
            for i in ad:
                if Acc == i[0]:
                    print("This account already exists....")
                    print("Please Enter Unique Account Number")
                    A()
            else:
                pass

        A()
        Name = input("Enter Name: ")

        def Mobile():
            global Mob
            Mob = input("Enter Mobile: ")
            if len(Mob) == 10:
                pass
            else:
                print("Please enter valid mobile number of 10 digits ")
                Mobile()
                print()

        Mobile()
        EmailID = input("Enter EmailID: ")
        Address = input("Enter your Address: ")
        City = input("Enter City: ")
        Country = input("Enter your country: ")
        Bal = float(input("Enter Balance: "))
        Rec = [Acc, Name.upper(), Mob, EmailID.upper(), Address.upper(),
               City.upper(), Country.upper(), Bal]
        Cmd = 'insert into BOB values(%s,%s,%s,%s,%s,%s,%s,%s)'
        cursor.execute(Cmd, Rec)
        mycon.commit()
        print("Account added successfully...")
        tp = input("Do You Want To Enter More Records (Y/N)?  ")
        if tp == "N" or tp == "n":
            break


def DispSortAcc():
    cmd = "select * from BOB order by ACCNO"
    cursor.execute(cmd)
    S = cursor.fetchall()
    print('*'*102)
    print('ACCNO', '   NAME', '     MOBILE', '                   EMAIL',
          '             ADDRESS', '        CITY', '     COUNTRY', '      BALANCE')
    print('*'*102)
    for i in S:
        for j in range(len(i)):
            print(i[j], end="      ")
        print()
    mycon.commit()


def DispSortName():
    try:
        cmd = "select * from BOB order by Name"
        cursor.execute(cmd)
        S = cursor.fetchall()
        F = '%15s %15s %15s %15s %15s %15s %15s %15s'
        print(F % ('ACCNO', 'NAME', 'MOBILE', 'EMAIL',
              'ADDRESS', 'CITY', 'COUNTRY', 'BALANCE'))
        print('*'*157)
        for i in S:
            for j in i:
                print('%14s' % j, end=' ')
            print()
        print('*'*157)
    except:
        print("Table doesn't exists")


def DispSortBal():
    try:
        cmd = "select * from BOB order by Balance"
        cursor.execute(cmd)
        S = cursor.fetchall()
        F = '%15s %15s %15s %15s %15s %15s %15s %15s'
        print(F % ('ACCNO', 'NAME', 'MOBILE', 'EMAIL',
              'ADDRESS', 'CITY', 'COUNTRY', 'BALANCE'))
        print('*'*157)
        for i in S:
            for j in i:
                print('%14s' % j, end=' ')
            print()
        print('_'*157)
    except:
        print("Table doesn't exists")


def DispSearchAcc():
    ch = int(input('Enter the account no. to be searched: '))
    cmd = 'select * from BOB where accno=%s' % (ch,)
    cursor.execute(cmd)
    a = cursor.fetchone()

    if a != ():
        f = 0
        for i in a:
            f += 1
            print(i, end='    ')
            if len(a) == f:
                print()

    else:
        print("No record found")


def UPDATE():
    A = input("Enter the Account number whose details to be changed")
    cmd = "select * from BOB where accno = %s" % (A,)
    cursor.execute(cmd)
    S = cursor.fetchone()
    print(S)
    a = 0
    while a == 0:
        print("What do you wan to change : ")
        print("\t1. Name ")
        print("\t2.Mobile ")
        print("\t3.Email Id ")
        print("\t4. Address ")
        print("\t5.City ")
        print("\t6. Country ")
        print("\t7. Balance ")
        print("\tPress 8 for exit ")
        ch = input('\t')
        if ch == '1':
            name = input("Enter New Name: ")
            cmd = 'update BOB set name="%s" where accno=%s' % (name, A)
            cursor.execute(cmd)
            mycon.commit()
            print("Updated name is", name)

        elif ch == '2':
            phone = input("Enter the new phone number: ")
            cmd = 'update BOB set phone="%s" where accno=%s' % (phone, A)
            cursor.execute(cmd)
            mycon.commit()
            print("Updated phone is ", phone)

        elif ch == '3':
            email = input("Enter the new email id: ")
            cmd = 'update BOB set emailid="%s" where accno=%s' % (email, A)
            cursor.execute(cmd)
            mycon.commit()
            print("Updated Email Id is ", email)

        elif ch == '4':
            add = input("Enter the new Address: ")
            cmd = 'update BOB set address="%s" where accno=%s' % (add, A)
            cursor.execute(cmd)
            mycon.commit()
            print("Updated Address is ", add)

        elif ch == '5':
            city = input("Enter the new city: ")
            cmd = 'update BOB set city="%s" where accno=%s' % (city, A)
            cursor.execute(cmd)
            mycon.commit()
            print("Updated City is ", city)

        elif ch == '6':
            count = input("Enter the new country: ")
            cmd = 'update BOB set country="%s" where accno=%s' % (count, A)
            cursor.execute(cmd)
            mycon.commit()
            print("Updated Country is", count)

        elif ch == '7':
            bal = int(input("Enter the New Balance: "))
            cmd = 'update BOB set balance=%s where accno=%s' % (bal, A)
            cursor.execute(cmd)
            mycon.commit()
            print("Updated balance  is", bal)

        elif ch == '8':
            a = 1

        else:
            print("Please enter valid choice")


def Delete():
    def A():
        global acc
        acc = input("Enter the account number: ")
        l = "select accno from BOB"
        cursor.execute(l)
        ad = cursor.fetchall()
        for i in ad:
            if acc == i[0]:
                break

        else:
            print("Sorry,This account does not exist")
            A()

    A()
    cmd = 'delete from BOB where accno=%s' % (acc,)
    print("Account deleted Successfully...")
    cursor.execute(cmd)
    mycon.commit()


def Debit():
    def A():
        global acc
        acc = input("Enter the accno. from which the money is to be debited: ")
        l = "select accno from BOB"
        cursor.execute(l)
        ad = cursor.fetchall()
        for i in ad:
            if acc == i[0]:
                break

        else:
            print("Sorry,This account does not exist")
            print()
            A()

    A()
    print()
    cmd = "select balance from BOB where accno=%s" % (acc,)
    cursor.execute(cmd)
    S = cursor.fetchone()
    print("Please note that money can only be debited if the min balance is of Rs 5000")
    print()
    wd = int(input("How much amount to be debited: "))
    if wd > S[0]:
        print()
        print("Not enough balance")

    else:
        if S[0] >= 5000:
            final = S[0]-wd
            cd = "update bob set balance=%s where accno=%s" % (final, acc)
            cursor.execute(cd)
            mycon.commit()
            print("Amount Debited Successfully...")
            print("Current Balance :-", final)
            print()

        else:
            print("Your Balance is less than Rs 5000")
            print("You cannot withdraw Money")


def Credit():
    def A():
        global acc
        acc = input("Enter the accno. from which the money is to be Credited: ")
        l = "select accno from BOB"
        cursor.execute(l)
        ad = cursor.fetchall()
        for i in ad:
            if acc == i[0]:
                break

        else:
            print("Sorry,This account does not exist")
            A()

    A()
    print()
    cmd = "select balance from BOB where accno=%s" % (acc,)
    cursor.execute(cmd)
    S = cursor.fetchone()
    wd = int(input("How much amount to be credited:"))

    final = S[0]+wd
    cd = "update bob set balance=%s where accno=%s" % (final, acc)
    cursor.execute(cd)
    mycon.commit()
    print()
    print("Amount Credited Successfully...")
    print("Current Balance :-", final)
    print()


while True:
    MENU()
    ch = input("Enter Your Choice: ")
    if ch == "1":
        Create()
    elif ch == "2":
        DispSortAcc()
    elif ch == '3':
        DispSearchAcc()
    elif ch == '4':
        UPDATE()
    elif ch == '5':
        Delete()
    elif ch == '6':
        while True:
            MenuTransactions()
            ch1 = input("Enter choice a/b/c: ")
            if ch1 in ['a', 'A']:
                Debit()
            elif ch1 in ['b', 'B']:
                Credit()
            elif ch1 in ['c', 'C']:
                print("Back to main menu")
                break
            else:
                print("Invalid Choice")
    elif ch == '7':
        print("Exiting...")
        print()
        print("\t\t===============================================================================")
        print("\t\t\t\t\tTHANKS FOR USING BANK MANAGEMENT SYSTEM")
        print("\t\t===============================================================================")
        break
    else:
        print("Entered Wrong Choice ")
