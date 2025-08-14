// IIFE definition
const productInventory = (function() {
    // private variable
    let stock = 0;

    return {
        getStock: function() {
            return stock;
        },
        addStock: function(quantity) {
            stock += quantity;
            console.log(`Stock after adding: ${stock}`);
        },
        sell: function(quantity) {
            if (stock >= quantity) {
                stock -= quantity;
                console.log(`Sold ${quantity} items.`);
            } else {
                console.log("Insufficient stock");
            }
        }
    };
})();

// ✅ Usage after IIFE is defined

// Add 10 items to stock
productInventory.addStock(10);

// Sell 3 items
productInventory.sell(3);

// Log current stock
console.log(`Stock remaining: ${productInventory.getStock()}`);
