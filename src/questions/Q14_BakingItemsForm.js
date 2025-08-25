import React, { useState } from "react";

function BakingItemsForm() {
  // State to store form inputs (controlled form)
  const [formData, setFormData] = useState({
    itemName: "",        
    quantity: "",        
    ingredients: "",     
    bakingTime: "",      
    category: "Cake",    // Default category is "Cake"
  });

                                                         
  const [bakingItems, setBakingItems] = useState([]);    // State to store the list of added baking items

  // Function to handle input changes in all form fields
  const handleChange = (e) => {
    const { name, value } = e.target; // Get field name and value
    setFormData({
      ...formData,       // Keep previous form data
      [name]: value,     // Update only the changed field
    });
  };

  // Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();          // Prevent page refresh on form submit

    // Validation: Check if any required field is empty
    if (!formData.itemName || !formData.quantity || !formData.ingredients || !formData.bakingTime) {
      alert("Please fill all fields!");      // Show alert if any field missing
      return;
    }

   
    setBakingItems([...bakingItems, formData]);   // Add new item to the bakingItems list

    // Reset form fields after submit
    setFormData({
      itemName: "",
      quantity: "",
      ingredients: "",
      bakingTime: "",
      category: "Cake", // Reset category back to Cake
    });
  };

  return (
    <div className="container mt-4">  {/* Bootstrap container */}
      <div className="card p-4 shadow"> 
        <h3 className="mb-3">🧁 Baking Items Form</h3>

       
        <form onSubmit={handleSubmit}>
          {/* Item Name */}
          <div className="mb-3">
            <label>Item Name</label>
            <input
              type="text"
              name="itemName"
              value={formData.itemName}  // Controlled input
              onChange={handleChange}    // Update formData when typing
              className="form-control"
              placeholder="Enter item name"
            />
          </div>

          {/* Quantity  */}
          <div className="mb-3">
            <label>Quantity</label>
            <input
              type="number"
              name="quantity"
              value={formData.quantity}
              onChange={handleChange}
              className="form-control"
              placeholder="Enter quantity"
            />
          </div>

          {/* Ingredients  */}
          <div className="mb-3">
            <label>Ingredients</label>
            <textarea
              name="ingredients"
              value={formData.ingredients}
              onChange={handleChange}
              className="form-control"
              placeholder="Enter ingredients"
            />
          </div>

          {/* Baking time */}
          <div className="mb-3">
            <label>Baking Time (minutes)</label>
            <input
              type="text"
              name="bakingTime"
              value={formData.bakingTime}
              onChange={handleChange}
              className="form-control"
              placeholder="e.g. 45 mins"
            />
          </div>

          {/* Category */}
          <div className="mb-3">
            <label>Category</label>
            <select
              name="category"
              value={formData.category}
              onChange={handleChange}
              className="form-control"
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          {/* Submit button */}
          <button type="submit" className="btn btn-success">
            Add Baking Item
          </button>
        </form>
      </div>

     
      <div className="mt-4">
        <h4>Baking Items List</h4>

        {/* If no items, show message */}
        {bakingItems.length === 0 ? (
          <p>No items added yet.</p>
        ) : (
          // Else show table with items
          <table className="table table-bordered table-striped mt-2">
            <thead className="table-dark">
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Ingredients</th>
                <th>Baking Time</th>
                <th>Category</th>
              </tr>
            </thead>
            <tbody>
              {/* Loop through bakingItems and show each item */}
              {bakingItems.map((item, index) => (
                <tr key={index}>
                  <td>{index + 1}</td> {/* Serial number */}
                  <td>{item.itemName}</td>
                  <td>{item.quantity}</td>
                  <td>{item.ingredients}</td>
                  <td>{item.bakingTime}</td>
                  <td>{item.category}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}

export default BakingItemsForm; 
