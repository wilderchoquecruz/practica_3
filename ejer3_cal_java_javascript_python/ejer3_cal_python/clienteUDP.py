# Cliente UDP
from socket import *

serverName = "localhost"
serverPort = 12000
clientSocket = socket(AF_INET, SOCK_DGRAM)

while True:
 print("----------------- MENU elija: +,-,*,/")
 message = str.encode(input("opreacion  : "))
 clientSocket.sendto(message, (serverName, serverPort))

 message = str.encode(input("Ingrese n1= : "))
 clientSocket.sendto(message, (serverName, serverPort))

 message = str.encode(input("Ingrese n2= : "))
 clientSocket.sendto(message, (serverName, serverPort))

 modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
 print('respuesta de servidor= ', modifiedMessage.decode())

clientSocket.close()