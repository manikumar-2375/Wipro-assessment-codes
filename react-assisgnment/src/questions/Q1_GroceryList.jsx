import React from "react";

function GroceryList({ items }) {
  const handleClick = () => alert("Groceries Added to Cart!");

  return (
    <div>
      <h3>Q1: Grocery List (Functional Component)</h3>
      <ul className="custom-list">
        {items.map((item, idx) => <li key={idx}>{item}</li>)}
      </ul>
      <button onClick={handleClick}>Add to Cart</button>
    </div>
  );
}

export default GroceryList;
