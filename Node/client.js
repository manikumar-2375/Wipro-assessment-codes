// client.js
const net = require('net');
const readline = require('readline');

const PORT = 5000;
const HOST = '127.0.0.1';

const rl = readline.createInterface({ input: process.stdin, output: process.stdout, prompt: '> ' });
const client = new net.Socket();

client.connect(PORT, HOST, () => {
  console.log(`Connected to ${HOST}:${PORT}`);
  console.log('Type LIST, ADD <id> <name> <quantity> <price>, or EXIT');
  rl.prompt();
});

client.on('data', (data) => {
  // Print server messages but keep prompt usable
  process.stdout.write(`\nServer: ${data.toString()}`);
  rl.prompt();
});

client.on('end', () => {
  console.log('\nDisconnected from server (end).');
});

client.on('close', () => {
  console.log('\nConnection closed.');
  process.exit(0);
});

client.on('error', (err) => {
  console.error('Connection error:', err.message);
  process.exit(1);
});

rl.on('line', (line) => {
  const cmd = line.trim();
  if (!cmd) {
    rl.prompt();
    return;
  }
  client.write(cmd + '\n');
  // If user typed EXIT, client will be closed once server responds / ends connection
}).on('close', () => {
  console.log('Input closed.');
  client.end();
});
