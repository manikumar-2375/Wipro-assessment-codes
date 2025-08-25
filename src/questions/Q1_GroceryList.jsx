import React from "react";

function GroceryList({ items }) {  //functional componet //items-props ( data passsed from parent component)
  const handleClick = () => alert("Groceries Added to Cart!");//popup msg

  return (
    <div>
      <h3>Q1: Grocery List (Functional Component)</h3>
      <ul className="custom-list">
        {items.map((item, idx) => <li key={idx}>{item}</li>)}  { /* loop through iems and created list-items with unique key*/}
      </ul>
      <button onClick={handleClick}>Add to Cart</button>
    </div>
  );
}

export default GroceryList;
