from email import message
from operator import mod
import socket
import sys



#considering Both client and server in present in the same folder 
# Create server
if(len(sys.argv)>1):
    ServerName = sys.argv[1]
    ServerPort = int(sys.argv[2])
    ServerAddress = (ServerName, ServerPort)

    # Create client socket
    clientSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # IPv4, TCP socket

    # Ask for connection to server
    clientSocket.connect(ServerAddress)

    # three-way handshake is performed
    # a TCP connection is established between the client and server.
        # Create message
    message1=input('Enter Command ').encode()
    m=message1.decode("utf-8")
    if(m.find("quit")>=0):
        print("Exiting program!")
        sys.exit()
    if(m.find("put")>=0):
        print("Awaiting Server response")
            # Send message
        clientSocket.sendall(message1 )
            # Receive from server
        modified_sent = clientSocket.recvfrom(2048)

            # Print received message
        if(len(modified_sent)!=0):
            print ("Server response: File uploaded")
        message2=input('Enter Command ').encode()
        m=message2.decode("utf-8")
        if(m.find("quit")>=0):
            print("Exiting program!")
            sys.exit()
        if(m.find("remap")>=0):
            clientSocket.sendall(message2)
            old= clientSocket.recvfrom(2048)
            new= clientSocket.recvfrom(2048)
            print("File",repr(old[0])[2:-1],"Remapped. Output file is ",repr(new[0])[2:-1])
        else:
            print("You should remap or quit now")
        message3=input("Enter Commend")
        if(message3.find("get")>=0):
            print("File",repr(new[0])[2:-1],"downloaded")
        elif(message3.find("quit")>=0):
            print("Exiting program!")
            sys.exit()
        else:
            print("You should get or quit Now")
        comnd=input("Enter Commend")
        if(comnd.find('quit')>=0):
            print("Exiting program!")
        else:
            print("You should quit Now")
    else:
        print("You Should Put the file first")
    # Close connection
    clientSocket.close
else:
    print("Less No of arguments")
