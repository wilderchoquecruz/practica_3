
var PORT = 33333;
var HOST = '127.0.0.1';

var dgram = require('dgram');
var server = dgram.createSocket('udp4');

server.on('listening', function() {
  var address = server.address();
  console.log('UDP Server listening on ' + address.address + ":" + address.port);
});

server.on('message', function(message, remote) {
  var result = calculate[message[2]](message[0], message[1]);
  console.log(remote.address + ':' + remote.port + ' =' + result);
});

var calculate = {
  '0': function(x, y) { return x + y },
  '1': function(x, y) { return x - y },
  '2': function(x, y) { return x * y },
  '3': function(x, y) { return x / y }
};

server.bind(PORT, HOST);