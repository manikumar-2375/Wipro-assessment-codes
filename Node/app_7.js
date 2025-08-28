// app_7.js

const connection = require("./mysqldbconnection_7");
const readline = require("readline");

// Create readline interface
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// CRUD Functions
function addStock(callback) {
  rl.question("Enter Stock Symbol: ", (symbol) => {
    if (!symbol) return console.log("Symbol cannot be empty!") || addStock(callback);

    rl.question("Enter Company Name: ", (companyName) => {
      if (!companyName) return console.log("Company name cannot be empty!") || addStock(callback);

      rl.question("Enter Price: ", (price) => {
        if (isNaN(price) || price <= 0) return console.log("Price must be a valid number!") || addStock(callback);

        rl.question("Enter Volume: ", (volume) => {
          if (isNaN(volume) || volume < 0) return console.log("Volume must be a valid number!") || addStock(callback);

          const sql = "INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)";
          connection.query(sql, [symbol, companyName, parseFloat(price), parseInt(volume)], (err, result) => {
            if (err) throw err;
            console.log("Stock added successfully! ID:", result.insertId);
            callback();
          });
        });
      });
    });
  });
}

function viewAllStocks(callback) {
  connection.query("SELECT * FROM stocks", (err, results) => {
    if (err) throw err;
    console.log("\nAll Stocks:");
    results.forEach(stock => {
      console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
    });
    callback();
  });
}

function viewStockById(callback) {
  rl.question("Enter Stock ID: ", (id) => {
    connection.query("SELECT * FROM stocks WHERE id = ?", [parseInt(id)], (err, results) => {
      if (err) throw err;
      if (results.length === 0) console.log("Stock not found!");
      else {
        const stock = results[0];
        console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
      }
      callback();
    });
  });
}

function updateStock(callback) {
  rl.question("Enter Stock ID to update: ", (id) => {
    rl.question("Enter New Price: ", (price) => {
      rl.question("Enter New Volume: ", (volume) => {
        const sql = "UPDATE stocks SET price = ?, volume = ? WHERE id = ?";
        connection.query(sql, [parseFloat(price), parseInt(volume), parseInt(id)], (err, result) => {
          if (err) throw err;
          console.log("Updated records:", result.affectedRows);
          callback();
        });
      });
    });
  });
}

function deleteStock(callback) {
  rl.question("Enter Stock ID to delete: ", (id) => {
    connection.query("DELETE FROM stocks WHERE id = ?", [parseInt(id)], (err, result) => {
      if (err) throw err;
      console.log("Deleted records:", result.affectedRows);
      callback();
    });
  });
}

// Interactive menu
function showMenu() {
  console.log("\nStock Market Management System");
  console.log("--------------------------------");
  console.log("1. Add Stock");
  console.log("2. View All Stocks");
  console.log("3. View Stock by ID");
  console.log("4. Update Stock Price & Volume");
  console.log("5. Delete Stock");
  console.log("6. Exit");

  rl.question("Enter your choice: ", (choice) => {
    switch(choice) {
      case "1": addStock(showMenu); break;
      case "2": viewAllStocks(showMenu); break;
      case "3": viewStockById(showMenu); break;
      case "4": updateStock(showMenu); break;
      case "5": deleteStock(showMenu); break;
      case "6":
        console.log("Exiting...");
        connection.end(() => rl.close());
        break;
      default:
        console.log("Invalid choice, try again.");
        showMenu();
    }
  });
}

// Start interactive console
console.log("Connected to MySQL");
showMenu();
