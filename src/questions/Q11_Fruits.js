import React, { Component } from "react"; 

// Functional Component
function FruitList11({ fruits }) {    // Receives fruits from parent
  return (
    <div>
      <h3>FruitList</h3>
      <ul>
        {fruits.map((fruit, index) => (      // Loop through fruits array
          <li key={index}>{fruit}</li>  // Display each fruit
        ))}
      </ul>
    </div>
  );
}

// Class Component
class Fruits11 extends Component {
  constructor(props) {
    super(props);           // Call parent constructor
    this.state = { // Component state
      fruits: ["Apple", "Banana", "orange"],        // Initial fruits
      newFruit: ""     // For input box
    };
  }

  handleChange = (e) => {
    this.setState({ newFruit: e.target.value }); // Update newFruit when typing
  };

  addFruit = () => {
    if (this.state.newFruit.trim() !== "") {         // Check input not empty
      this.setState((prevState) => ({   // Update state
        fruits: [...prevState.fruits, prevState.newFruit],      // Add new fruit
        newFruit: ""    // Clear input
      }));
    }
  };

  render() {
    return (
      <div>
        <h3>Fruits</h3>
        <input
          type="text"
          value={this.state.newFruit}  // Controlled input
          onChange={this.handleChange}  // Call handleChange when typing
        />
        <button onClick={this.addFruit}>Add</button> 

       
        <FruitList11 fruits={this.state.fruits} />   {/* Pass fruits array to child functional component */}
      </div>
    );
  }
}

export default Fruits11; 
