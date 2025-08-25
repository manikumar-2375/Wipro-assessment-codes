// questions/Q18_Furniture.js
import React, { useState } from "react";

// Chair Component
const Chair = () => (
  <div className="card p-3">
    <h5>🪑 Chair</h5>
    <p><strong>Name:</strong> Office Chair</p>
    <p><strong>Price:</strong> ₹2500</p>
    <p><strong>Material:</strong> Plastic</p>
    <p><strong>Brand:</strong> Nilkamal</p>
  </div>
);

// Table Component
const Table = () => (
  <div className="card p-3">
    <h5>📏 Table</h5>
    <p><strong>Name:</strong> Dining Table</p>
    <p><strong>Price:</strong> ₹7500</p>
    <p><strong>Material:</strong> Wood</p>
    <p><strong>Size:</strong> 6 Seater</p>
    <p><strong>Brand:</strong> Godrej</p>
  </div>
);

// Sofa Component
const Sofa = () => (
  <div className="card p-3">
    <h5>🛋️ Sofa</h5>
    <p><strong>Name:</strong> Recliner Sofa</p>
    <p><strong>Price:</strong> ₹30000</p>
    <p><strong>Material:</strong> Leather</p>
    <p><strong>Size:</strong> 3 Seater</p>
    <p><strong>Brand:</strong> Urban Ladder</p>
  </div>
);

// Bed Component
const Bed = () => (
  <div className="card p-3">
    <h5>🛏️ Bed</h5>
    <p><strong>Name:</strong> King Size Bed</p>
    <p><strong>Price:</strong> ₹45000</p>
    <p><strong>Material:</strong> Teak Wood</p>
    <p><strong>Size:</strong> King Size</p>
    <p><strong>Brand:</strong> Durian</p>
  </div>
);

// Main Furniture Store
const FurnitureStore18 = () => {
  const [selected, setSelected] = useState("Chair");

  // Switch-Case Rendering
  const renderFurniture = () => {
    switch (selected) {
      case "Chair":
        return <Chair />;
      case "Table":
        return <Table />;
      case "Sofa":
        return <Sofa />;
      case "Bed":
        return <Bed />;
      default:
        return <p>Please select a furniture item.</p>;
    }
  };

  return (
    <div>
      <h3>Furniture Store</h3>
      <select
        value={selected}
        onChange={(e) => setSelected(e.target.value)}
        className="form-select mb-3"
      >
        <option value="Chair">Chair</option>
        <option value="Table">Table</option>
        <option value="Sofa">Sofa</option>
        <option value="Bed">Bed</option>
      </select>

      {renderFurniture()}
    </div>
  );
};

export default FurnitureStore18;
