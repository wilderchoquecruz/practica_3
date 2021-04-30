var PORT = 33333;
var HOST = '127.0.0.1';
var dgram = require('dgram');
var encodeOperand = {
  '+': 0,
  '-': 1,
  '*': 2,
  'x': 2,
  '/': 3
}
var calc = [process.argv[2], process.argv[4], encodeOperand[process.argv[3]]];
var message = new Buffer(calc);
var client = dgram.createSocket('udp4');
client.send(message, 0, message.length, PORT, HOST, function(err, bytes) {
  if(err) throw err;
  console.log('UDP message sent to ' + HOST + ':' + PORT);
  client.close();
});