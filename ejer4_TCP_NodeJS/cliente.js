var net = require('net');
const rl = require('./readl');

var client = net.connect({ port: 8080 }, function () {
    console.log('conectado al servidor!');
    console.log('Introduzca su nombre :');

});

rl.on('line', function (msg) {
    if(msg == 'salir'){
        rl.close();
        client.end();
    }else{
        client.write(msg);
    }
});

client.on('data', function (data) {
    console.log(data.toString());
    // client.end();
});

client.on('end', function () {
    console.log('desconectado del servidor!');
});