// questions/Q17_Electronics.js
import React, { useState, useEffect } from "react";

// Loading Component
const LoadingComponent = () => (
  <div className="alert alert-info">Loading product details...</div>
);

// Error Component
const ErrorComponent = () => (
  <div className="alert alert-danger">⚠️ Error fetching product details</div>
);

// Product Component
const ProductComponent = ({ product }) => {
  return (
    <div className="card p-3">
      <h4>Electronic Product Details</h4>
      <p><strong>Name:</strong> {product.name}</p>
      <p><strong>Brand:</strong> {product.brand}</p>
      <p><strong>Price:</strong> ₹{product.price}</p>
      <p><strong>Category:</strong> {product.category}</p>
      <p>
        <strong>Brand:</strong>{" "}
        {product.price > 50000 ? "Premium Product" : "Budget Product"}
      </p>
      <p>
        <strong>Warranty:</strong>{" "}
        {product.warranty > 0 ? `${product.warranty} years` : "No Warranty"}
      </p>
      <p>
        {product.availability ? (
          <span style={{ color: "green" }}> In Stock</span>
        ) : (
          <span style={{ color: "red" }}> Out of Stock</span>
        )}
      </p>
      <p>
        {product.category === "Laptop" ? " Free Laptop Bag Offer" : null}
      </p>
    </div>
  );
};

// Main Electronics Component
const Electronics17 = () => {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [product, setProduct] = useState(null);

  useEffect(() => {
    // Simulate API Call
    setTimeout(() => {
      const success = Math.random() > 0.3; // 70% success chance
      if (success) {
        setProduct({
          name: "Sony Bravia TV",
          brand: "Sony",
          price: 65000,
          category: "TV",
          warranty: 2,
          availability: true,
        });
        setLoading(false);
      } else {
        setError(true);
        setLoading(false);
      }
    }, 2000);
  }, []);

  // Conditional Rendering with Ternary
  return (
    <div>
      {loading ? (
        <LoadingComponent />
      ) : error ? (
        <ErrorComponent />
      ) : (
        <ProductComponent product={product} />
      )}
    </div>
  );
};

export default Electronics17;
