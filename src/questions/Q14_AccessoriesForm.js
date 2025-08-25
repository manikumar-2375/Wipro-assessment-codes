
import React, { Component } from "react";


class AccessoriesForm extends Component {
  // Constructor initializes the state
  constructor(props) {
    super(props);     // Call parent constructor
    this.state = {
      accessoryName: "", 
      description: "",   
      category: "",      
      brand: "",         
      available: false,  // Store stock availability (checkbox)
      warranty: "",      
      submittedData: [], // Store submitted records (array of objects)
    };
  }

 
  handleChange = (event) => {
    const { name, value, type, checked } = event.target;  // Extract properties from event
    this.setState({
      [name]: type === "checkbox" ? checked : value,  // Handle checkbox differently
    });
  };

  // Method to handle form submission
  handleSubmit = (event) => {
    event.preventDefault();      // Prevent page reload on form submit
    const { accessoryName, description, category, brand, available, warranty } =
      this.state;     // Get current values from state

                        // Create a new data object
    const newData = {
      accessoryName,
      description,
      category,
      brand,
      available,
      warranty,
    };

    // Update submittedData array and reset form fields
    this.setState((prevState) => ({
      submittedData: [...prevState.submittedData, newData], // Add new entry
      accessoryName: "", // Reset input
      description: "",
      category: "",
      brand: "",
      available: false,
      warranty: "",
    }));
  };

  
  render() {
    
    const { accessoryName, description, category, brand, available, warranty, submittedData } =
      this.state;

    return (
      
      <div className="container mt-4">
        
        <h2 className="mb-3 text-center">Accessories Form</h2>

        
        <form onSubmit={this.handleSubmit} className="border p-4 rounded shadow">
          
          {/* Accessory Name */}
          <div className="mb-3">
            <label className="form-label">Accessory Name</label>
            <input
              type="text"
              name="accessoryName"
              value={accessoryName}
              onChange={this.handleChange}
              className="form-control"
              required
            />
          </div>

          {/* Description */}
          <div className="mb-3">
            <label className="form-label">Description</label>
            <textarea
              name="description"
              value={description}
              onChange={this.handleChange}
              className="form-control"
              rows="3"
              required
            ></textarea>
          </div>

          {/* Category */}
          <div className="mb-3">
            <label className="form-label">Category</label>
            <select
              name="category"
              value={category}
              onChange={this.handleChange}
              className="form-select"
              required
            >
              <option value="">-- Select Category --</option>
              <option value="Mobile">Mobile</option>
              <option value="Laptop">Laptop</option>
              <option value="Headphone">Headphone</option>
              <option value="Camera">Camera</option>
            </select>
          </div>

          {/* Brand */}
          <div className="mb-3">
            <label className="form-label">Brand</label>
            <div>
              <input
                type="radio"
                name="brand"
                value="Samsung"
                checked={brand === "Samsung"} // Check if Samsung is selected
                onChange={this.handleChange}
                className="form-check-input me-2"
              />
              Samsung
            </div>
            <div>
              <input
                type="radio"
                name="brand"
                value="Apple"
                checked={brand === "Apple"} // Check if Apple is selected
                onChange={this.handleChange}
                className="form-check-input me-2"
              />
              Apple
            </div>
            <div>
              <input
                type="radio"
                name="brand"
                value="Sony"
                checked={brand === "Sony"} // Check if Sony is selected
                onChange={this.handleChange}
                className="form-check-input me-2"
              />
              Sony
            </div>
          </div>

          {/* Checkbox - Availability */}
          <div className="mb-3 form-check">
            <input
              type="checkbox"
              name="available"
              checked={available}
              onChange={this.handleChange}
              className="form-check-input"
            />
            <label className="form-check-label">Available in Stock</label>
          </div>

          {/*  Warranty */}
          <div className="mb-3">
            <label className="form-label">Warranty (in months)</label>
            <input
              type="number"
              name="warranty"
              value={warranty}
              onChange={this.handleChange}
              className="form-control"
              min="0"
              required
            />
          </div>

          {/* Submit Button */}
          <button type="submit" className="btn btn-primary w-100">
            Submit
          </button>
        </form>

        {/* Table - Display submitted data if available */}
        {submittedData.length > 0 && (
          <div className="mt-4">
            <h4 className="text-center">Submitted Accessories</h4>
            <table className="table table-bordered table-striped mt-3">
              <thead>
                <tr>
                  <th>Accessory Name</th>
                  <th>Description</th>
                  <th>Category</th>
                  <th>Brand</th>
                  <th>Available</th>
                  <th>Warranty (months)</th>
                </tr>
              </thead>
              <tbody>
                                                        {/* Loop through submittedData and display each row */}
                {submittedData.map((item, index) => (
                  <tr key={index}>
                    <td>{item.accessoryName}</td>
                    <td>{item.description}</td>
                    <td>{item.category}</td>
                    <td>{item.brand}</td>
                    <td>{item.available ? "Yes" : "No"}</td>
                    <td>{item.warranty}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}


export default AccessoriesForm;
