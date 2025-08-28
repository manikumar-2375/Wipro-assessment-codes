// app.js
const { calculateVAT } = require("./vatCalculator_3");

// Example: Single jewellery item
const jewellery1 = { id: 1, name: "Gold Necklace", price: 50000 };

// Use module to calculate VAT & total
const result1 = calculateVAT(jewellery1.price);

console.log("Jewellery ID:", jewellery1.id);
console.log("Name:", jewellery1.name);
console.log("Price:", jewellery1.price);
console.log("VAT (3%):", result1.vat);
console.log("Total Price:", result1.totalPrice);

// -----------------
// Q4: Bonus: Multiple items + configurable VAT
// -----------------
console.log("\nHandling multiple jewellery items:\n");

const jewelleryItems = [
  { id: 2, name: "Gold Ring", price: 20000 },
  { id: 3, name: "Silver Bracelet", price: 10000 },
  { id: 4, name: "Diamond Earrings", price: 75000 },
];

jewelleryItems.forEach((item) => {
  // Example: Pass custom VAT rate (say 5%) for diamonds
  const vatPercent = item.name.includes("Diamond") ? 5 : 3;
  const { vat, totalPrice } = calculateVAT(item.price, vatPercent);

  console.log("Jewellery ID:", item.id);
  console.log("Name:", item.name);
  console.log("Price:", item.price);
  console.log(`VAT (${vatPercent}%):`, vat);
  console.log("Total Price:", totalPrice);
  console.log("-------------------");
});
