// src/questions/Q20_RestaurantForm.js
import React, { useState, useEffect } from "react";

function RestaurantForm20() {
  const [formData, setFormData] = useState({
    restaurantName: "",
    ownerName: "",
    email: "",
    contact: "",
    address: "",
    cuisine: "",
    hours: "",
  });

  const [submittedData, setSubmittedData] = useState(null);

  // Q1: Run on every render
  useEffect(() => {
    console.log("Restaurant Form Rendered");
  });

  // Q2: Run only once (on mount)
  useEffect(() => {
    console.log("Welcome to Restaurant Registration 🏛️");
    alert("Welcome to Restaurant Registration 🏛️");
  }, []);

  // Q3: Run whenever form data changes
  useEffect(() => {
    console.log("Form data changed:", formData);
  }, [formData]);

  // Q4: Auto-save every 5 seconds (with cleanup)
  useEffect(() => {
    const interval = setInterval(() => {
      console.log("Auto-saving form data:", formData);
    }, 5000);

    return () => clearInterval(interval); // cleanup
  }, [formData]);

  // Handle input change
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // Handle form submit
  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmittedData(formData);
  };

  return (
    <div>
      <h2>🍴 Restaurant Registration Form</h2>
      <p>Welcome to Restaurant Registration 🏛️</p>

      <form onSubmit={handleSubmit}>
        <div>
          <label>Restaurant Name</label>
          <input
            type="text"
            name="restaurantName"
            value={formData.restaurantName}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Owner Name</label>
          <input
            type="text"
            name="ownerName"
            value={formData.ownerName}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Contact Number</label>
          <input
            type="text"
            name="contact"
            value={formData.contact}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Address</label>
          <input
            type="text"
            name="address"
            value={formData.address}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Cuisine Type</label>
          <input
            type="text"
            name="cuisine"
            value={formData.cuisine}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Opening Hours</label>
          <input
            type="text"
            name="hours"
            value={formData.hours}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Submit</button>
      </form>

      {/* Submitted Data */}
      {submittedData && (
        <div>
          <h3>📂 Submitted Data (JSON)</h3>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </div>
      )}
    </div>
  );
}

export default RestaurantForm20;
