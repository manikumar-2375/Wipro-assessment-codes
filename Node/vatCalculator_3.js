// vatCalculator.js

// Default VAT percentage = 3%
const DEFAULT_VAT_PERCENT = 3;

/**
 * Calculate VAT for a given price.
 * @param {number} price - Price of jewellery item
 * @param {number} vatPercent - VAT percentage (optional, default 3%)
 * @returns {object} - { vat, totalPrice }
 */
function calculateVAT(price, vatPercent = DEFAULT_VAT_PERCENT) {
  const vat = (price * vatPercent) / 100;
  const totalPrice = price + vat;
  return { vat, totalPrice };
}

// Export the function
module.exports = { calculateVAT };
