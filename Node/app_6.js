const connection = require("./mysqldbconnection_6");
const readline = require("readline");

// Create readline interface
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// CRUD Functions
function addStock(symbol, companyName, price, volume, callback) {
  const sql = "INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)";
  connection.query(sql, [symbol, companyName, price, volume], (err, result) => {
    if (err) return callback(err);
    console.log("Added stock with ID:", result.insertId);
    callback();
  });
}

function listStocks(callback) {
  connection.query("SELECT * FROM stocks", (err, results) => {
    if (err) return callback(err);
    console.log("\nAll Stocks:");
    results.forEach(stock => {
      console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
    });
    callback();
  });
}

function updateStockPriceAndVolume(id, price, volume, callback) {
  const sql = "UPDATE stocks SET price = ?, volume = ? WHERE id = ?";
  connection.query(sql, [price, volume, id], (err, result) => {
    if (err) return callback(err);
    console.log("Updated records:", result.affectedRows);
    callback();
  });
}

function deleteStock(id, callback) {
  const sql = "DELETE FROM stocks WHERE id = ?";
  connection.query(sql, [id], (err, result) => {
    if (err) return callback(err);
    console.log("Deleted records:", result.affectedRows);
    callback();
  });
}

// Interactive menu
function showMenu() {
  console.log("\nStock Market CRUD Menu:");
  console.log("1. Add Stock");
  console.log("2. List Stocks");
  console.log("3. Update Stock");
  console.log("4. Delete Stock");
  console.log("5. Exit");

  rl.question("Choose an option: ", (option) => {
    switch(option) {
      case "1":
        rl.question("Symbol: ", (symbol) => {
          rl.question("Company Name: ", (companyName) => {
            rl.question("Price: ", (price) => {
              rl.question("Volume: ", (volume) => {
                addStock(symbol, companyName, parseFloat(price), parseInt(volume), showMenu);
              });
            });
          });
        });
        break;
      case "2":
        listStocks(showMenu);
        break;
      case "3":
        rl.question("Stock ID to update: ", (id) => {
          rl.question("New Price: ", (price) => {
            rl.question("New Volume: ", (volume) => {
              updateStockPriceAndVolume(parseInt(id), parseFloat(price), parseInt(volume), showMenu);
            });
          });
        });
        break;
      case "4":
        rl.question("Stock ID to delete: ", (id) => {
          deleteStock(parseInt(id), showMenu);
        });
        break;
      case "5":
        console.log("Exiting...");
        connection.end(() => rl.close());
        break;
      default:
        console.log("Invalid option, try again.");
        showMenu();
    }
  });
}

// Start interactive menu
console.log("Connected to MySQL");
showMenu();
