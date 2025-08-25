import React from "react";

function SweetsList() {
  const sweets = [
    { id: 1, name: "Laddu", price: 50 },
    { id: 2, name: "Jalebi", price: 40 },
    { id: 3, name: "Rasgulla", price: 60 },
    { id: 4, name: "Gulab Jamun", price: 70 },
  ];
  return (
    <div>
      <h3>Q4: Sweets List</h3>
      <ul className="custom-list">
        {sweets.map((s) => (
          <li key={s.id}>{s.name} - Price: ₹{s.price}</li>
        ))}
      </ul>
    </div>
  );
}

export default SweetsList;
