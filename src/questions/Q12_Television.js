import React, { Component } from "react"; 

// Functional Component
function TelevisionList12({ televisions }) {  // Receives televisions from parent
  return (
    <div>
      <h3>Television Models</h3>
      <ul>
        {televisions.map((model, index) => (  // Loop through televisions array
          <li key={index}>{model}</li>        // Display each model
        ))}
      </ul>
    </div>
  );
}

// Class Component
class TelevisionManager12 extends Component {
  constructor(props) {
    super(props);    // Call parent constructor
    this.state = {    // Initial state
      televisions: ["Sony Bravia", "Samsung QLED", "LG OLED"],
      newModel: "" // For input box
    };
  }

  handleChange = (e) => {
    this.setState({ newModel: e.target.value });  // Update newModel when typing
  };

  addModel = () => {
    if (this.state.newModel.trim() !== "") {    // Check input not empty
      this.setState((prevState) => ({    // Update state
        televisions: [...prevState.televisions, prevState.newModel], // Add model
        newModel: "" // Clear input
      }));
    }
  };

  render() {
    return (
      <div>
        <h3>Television Manager</h3>
        <input
          type="text"
          value={this.state.newModel} // Controlled input
          onChange={this.handleChange} // Call handleChange when typing
        />
        <button onClick={this.addModel}>Add</button> 

       
        <TelevisionList12 televisions={this.state.televisions} />  {/* Pass televisions array to child functional component */}
      </div>
    );
  }
}

export default TelevisionManager12; 
