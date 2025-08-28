// streams_lab.js
const fs = require("fs");

// Q1: Create a Writable Stream & write fruit data
const fruitsFile = "fruits.txt";
const writable = fs.createWriteStream(fruitsFile);

const fruits = [
  { id: 1, name: "Apple", color: "Red", price: 120 },
  { id: 2, name: "Banana", color: "Yellow", price: 40 },
  { id: 3, name: "Mango", color: "Orange", price: 150 },
];

fruits.forEach((fruit) => {
  writable.write(JSON.stringify(fruit) + "\n"); // newline for separation
});

// Close the stream
writable.end(() => {
  console.log("Q1 -> Data written to fruits.txt successfully.\n");

  // Q2: Create a Readable Stream & read content
  console.log("Q2 -> Reading fruits.txt using stream...");
  const readable = fs.createReadStream(fruitsFile, { encoding: "utf8" });

  // Q4: Handle events (data, end, error)
  let leftover = "";
  readable.on("data", (chunk) => {
    leftover += chunk; // collect data chunk by chunk
    let lines = leftover.split("\n");
    leftover = lines.pop(); // last line may be incomplete
    lines.forEach((line) => {
      if (line.trim()) {
        const fruit = JSON.parse(line);
        console.log(
          `Fruit ID: ${fruit.id}, Name: ${fruit.name}, Color: ${fruit.color}, Price: ${fruit.price}`
        );
      }
    });
  });

  readable.on("end", () => {
    console.log("\nQ2 -> Finished reading fruits.txt.\n");

    // Q3: Pipe Streams (copy file)
    const copyFile = "fruits_copy.txt";
    const rStream = fs.createReadStream(fruitsFile);
    const wStream = fs.createWriteStream(copyFile);

    rStream.pipe(wStream).on("finish", () => {
      console.log("Q3 -> Content copied to fruits_copy.txt using pipe.");
    });
  });

  readable.on("error", (err) => {
    console.error("Error while reading file:", err.message);
  });
});
