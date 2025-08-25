// src/questions/Q21_FruitCommunication.js
import React, { useState } from "react"; // Import React and useState hook for state management

function FruitList({ fruits, onSelect }) { // Child component A: displays list of fruits & sends selected fruit to parent
  return (
    <div style={boxStyle}> {/* Styled container */}
      <h4>Fruit List</h4> {/* Heading */}
      {fruits.map((fruit, idx) => ( // Loop through fruits array
        <div
          key={idx} // Unique key for each fruit
          style={{ cursor: "pointer" }} // Pointer cursor for clickable items
          onClick={() => onSelect(fruit)} // Call parent function with selected fruit
        >
          {fruit} {/* Display fruit name */}
        </div>
      ))}
    </div>
  );
}

function Sender({ onSend }) { // Child component B: button to add/send fruit to parent
  return (
    <div style={boxStyle}> {/* Styled container */}
      <h4>Sender</h4> {/* Heading */}
      <button onClick={onSend}>Send Fruit</button> {/* Button triggers parent callback */}
    </div>
  );
}

function SelectedFruit({ fruit }) { // Child component C: displays the currently selected fruit
  return (
    <div style={boxStyle}> {/* Styled container */}
      <h4>Selected Fruit</h4> {/* Heading */}
      <p>{fruit || "None"}</p> {/* Show selected fruit or "None" if empty */}
    </div>
  );
}

function FruitCommunicationApp() { // Parent component: manages state and communication between children
  const [fruits, setFruits] = useState(["Apple", "Mango"]); // State for fruit list, initially 2 fruits
  const [selectedFruit, setSelectedFruit] = useState(""); // State for selected fruit, initially empty

  // Child B → Parent: add Orange
  const handleSendFruit = () => {
    setFruits((prev) => [...prev, "Orange"]); // Add "Orange" to the fruits array
  };

  // Child A → Parent → Child C
  const handleSelectFruit = (fruit) => {
    setSelectedFruit(fruit); // Update selected fruit when clicked in FruitList
  };

  return (
    <div style={{ padding: "20px" }}> {/* Main container with padding */}
      <h3>React – Parent / Child / Sibling Communication</h3> {/* Page heading */}
      <FruitList fruits={fruits} onSelect={handleSelectFruit} /> {/* Render FruitList, pass fruits & select handler */}
      <div style={{ display: "flex", gap: "20px", marginTop: "20px" }}> {/* Flex container for sender & display */}
        <Sender onSend={handleSendFruit} /> {/* Render Sender, pass add fruit handler */}
        <SelectedFruit fruit={selectedFruit} /> {/* Render SelectedFruit, pass currently selected fruit */}
      </div>
    </div>
  );
}

const boxStyle = { // Reusable styling object for child components
  border: "1px solid #ccc", // Border color
  padding: "10px",           // Padding inside the box
  borderRadius: "8px",       // Rounded corners
  background: "#fff",        // Background color
  minWidth: "150px",         // Minimum width
};

export default FruitCommunicationApp; // Export parent component to use in App.js
