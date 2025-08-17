import React, { useState } from "react";

function Electronics() {
  const [name] = useState("Laptop");
  const [brand, setBrand] = useState("Dell");
  const [price, setPrice] = useState(5500);

  return (
    <div>
      <h3>Q5: Electronics (useState)</h3>
      <p><b>Name:</b> {name}</p>
      <p><b>Brand:</b> {brand}</p>
      <p><b>Price:</b> ₹{price}</p>
      <button onClick={() => setBrand("HP")}>Change Brand</button>
      <button onClick={() => setPrice(price + 500)}>Increase Price</button>
    </div>
  );
}

export default Electronics;
