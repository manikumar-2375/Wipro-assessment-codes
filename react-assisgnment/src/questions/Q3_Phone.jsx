import React, { useState } from "react";

const Phone = () => {
  const [price, setPrice] = useState(79999);
  return (
    <div>
      <h3>Q3: Phone (Arrow + useState)</h3>
      <p>Brand: Apple</p>
      <p>Model: iPhone 15</p>
      <p>Price: ₹{price}</p>
      <button onClick={() => setPrice(price + 1000)}>Increase Price</button>
    </div>
  );
};

export default Phone;
