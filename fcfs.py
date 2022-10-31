def waitingTime(bt,wt,N):
    for i in range(1,N):
        wt[i] = wt[i-1] + bt[i-1]
    print('waiting times are:',wt)    
    print('Average waiting time: ',sum(wt)/N)


def turnAroundTime(bt,wt,tat,N):
    for i in range(N):
        tat[i] = wt[i] + bt[i]
    print('Turn Around times are:',tat)
    print('Average Turn Around time: ',sum(tat)/N)


N = int(input('Enter no.of Process: '))
bt = []
wt = [0]*N
tat = [0]*N
for i in range(N):
    print('Enter the Burst Time of process',i)
    bt.append(int(input()))
waitingTime(bt,wt,N)
turnAroundTime(bt,wt,tat,N)


