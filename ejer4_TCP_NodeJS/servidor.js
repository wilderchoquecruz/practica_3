const net = require('net');
var contador=0;
const server = net.createServer(function (connection) {
    
    // connection.write('Hola Mundo!\r\n');
    connection.on('end', function () {
        console.log('cliente desconectado');
    });
    
    connection.on('data', function(data){
        contador = contador + 1;        
        console.log('Contador : '+contador);

        console.log('cliente connectado :' + data);
        connection.write('Hola cliente '+data+ ', usted es el cliente número :'+contador+' conectado');
        
    });
    
});

server.listen(8080, function () {
    console.log('servidor esta escuchando');
});