# Servidor UDP
from socket import *

serverPort = 12000
serverSocket = socket(AF_INET, SOCK_DGRAM)
serverSocket.bind(("localhost", serverPort))
print("Servidor listo para recibir .... ")
while True:
    message1, clientAddress = serverSocket.recvfrom(2048)
    print("Se ha recibido1 : ", message1)
    message2, clientAddress = serverSocket.recvfrom(2048)
    print("Se ha recibido2 : ", message2)
    message3, clientAddress = serverSocket.recvfrom(2048)
    print("Se ha recibido3 : ", message3)
    

    print('se recibio:', message1.decode())
    answer = message2 +message1+message3
    print('union:', answer.decode())
    result = eval(answer)
    print(result)

    serverSocket.sendto(str(result).encode(), clientAddress)



