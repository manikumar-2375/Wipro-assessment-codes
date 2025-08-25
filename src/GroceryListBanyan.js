import React from "react";

function GroceryList({ items }) {
  const handleClick = () => {
    alert("Groceries Added to Cart!");
  };

  return (
    <div>
      <h2>Groceries List:</h2>
      <ul>
        {items.map((g, index) => (
          <li key={index}>{g}</li>
        ))}
      </ul>
      <button onClick={handleClick}>Add to Cart</button>
    </div>
  );
}

export default GroceryList;
