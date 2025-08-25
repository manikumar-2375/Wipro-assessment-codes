import React from "react";

const CanteenItem = ({ name, price, category, available }) => (
  <li>
    {name} - Price: ₹{price} - Category: {category} - {available ? "Available" : "Not Available"}
  </li>
);

function CanteenMenu({ canteenName, location, openHours }) {
  const items = [
    { name: "Idli", price: 30, category: "Breakfast", available: true },
    { name: "Dosa", price: 50, category: "Breakfast", available: true },
    { name: "Vada", price: 20, category: "Snack", available: false },
    { name: "Poori", price: 40, category: "Breakfast", available: true },
    { name: "Meals", price: 120, category: "Lunch", available: true },
  ];

  return (
    <div>
      <h3>Q6: Canteen Menu (Parent + Child)</h3>
      <p><b>Canteen:</b> {canteenName}</p>
      <p><b>Location:</b> {location}</p>
      <p><b>Open Hours:</b> {openHours}</p>
      <h4>Canteen Items</h4>
      <ul className="custom-list">
        {items.map((it, i) => <CanteenItem key={i} {...it} />)}
      </ul>
    </div>
  );
}

export default CanteenMenu;
