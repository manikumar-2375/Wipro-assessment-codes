// server.js
const net = require('net');

const PORT = 5000;
const HOST = '0.0.0.0';

let items = [
  { id: 1, name: 'Gold Ring', quantity: 5, price: 15000 },
  { id: 2, name: 'Silver Necklace', quantity: 3, price: 5000 }
];

const clients = [];

const server = net.createServer((socket) => {
  const remote = `${socket.remoteAddress}:${socket.remotePort}`;
  console.log(`Client connected: ${remote}`);
  clients.push(socket);

  socket.write('Welcome to Jewellery Stock Server.\nCommands: LIST, ADD <id> <name> <quantity> <price>, EXIT\n');

  socket.on('data', (data) => {
    // Allow multiple commands in one chunk
    const text = data.toString();
    const lines = text.split(/\r?\n/).map(l => l.trim()).filter(Boolean);
    for (const line of lines) {
      console.log(`[${remote}] ${line}`);
      handleCommand(line, socket);
    }
  });

  socket.on('error', (err) => {
    console.error(`Socket error (${remote}):`, err.message);
  });

  socket.on('end', () => {
    console.log(`Client ended: ${remote}`);
    removeClient(socket);
  });

  socket.on('close', (hadErr) => {
    console.log(`Client closed: ${remote} ${hadErr ? '(error)' : ''}`);
    removeClient(socket);
  });
});

function handleCommand(line, socket) {
  const parts = line.split(' ').filter(Boolean);
  const cmd = (parts[0] || '').toUpperCase();

  if (cmd === 'LIST') {
    if (items.length === 0) {
      socket.write('No items in stock.\n');
    } else {
      const out = items.map(i => `ID: ${i.id}, Name: ${i.name}, Quantity: ${i.quantity}, Price: ${i.price}`).join('\n') + '\n';
      socket.write(out);
    }
  } else if (cmd === 'ADD') {
    // Expect at least: ADD id name quantity price
    if (parts.length < 5) {
      socket.write('Invalid ADD. Usage: ADD <id> <name> <quantity> <price>\n');
      return;
    }

    const id = parseInt(parts[1], 10);
    const price = parseFloat(parts[parts.length - 1]);
    const quantity = parseInt(parts[parts.length - 2], 10);
    const name = parts.slice(2, parts.length - 2).join(' ');

    if (Number.isNaN(id) || Number.isNaN(quantity) || Number.isNaN(price) || !name) {
      socket.write('Invalid ADD parameters. Ensure id, quantity, price are numbers and name is present.\n');
      return;
    }

    if (items.some(it => it.id === id)) {
      socket.write(`Item with id ${id} already exists.\n`);
      return;
    }

    const newItem = { id, name, quantity, price };
    items.push(newItem);

    socket.write('Jewellery item added successfully!\n');
    console.log(`Added item: ${JSON.stringify(newItem)}`);

    // Broadcast to other clients
    broadcast(`[Update] Item added: ID:${id}, Name:${name}, Quantity:${quantity}, Price:${price}\n`, socket);
  } else if (cmd === 'EXIT') {
    socket.write('Goodbye!\n');
    socket.end();
  } else {
    socket.write('Unknown command. Use LIST, ADD, or EXIT\n');
  }
}

function removeClient(sock) {
  const i = clients.indexOf(sock);
  if (i !== -1) clients.splice(i, 1);
}

function broadcast(message, exceptSocket) {
  clients.forEach(s => {
    if (s !== exceptSocket) {
      s.write(message);
    }
  });
}

server.on('error', (err) => {
  console.error('Server error:', err.message);
});

server.listen(PORT, HOST, () => {
  console.log(`Server listening on ${HOST}:${PORT}`);
});
