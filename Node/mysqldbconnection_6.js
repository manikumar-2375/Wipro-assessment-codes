// mysqldbconnection_6.js

const mysql = require("mysql2");

// create connection
const connection = mysql.createConnection({
  host: "localhost",
  user: "root",      // replace with your MySQL username
  password: "M@ni7497",      // replace with your MySQL password
  database: "stock_market"
});

// connect
connection.connect((err) => {
  if (err) {
    console.error("Error connecting to MySQL:", err);
    return;
  }
  console.log("Connected to MySQL");
});

module.exports = connection;
