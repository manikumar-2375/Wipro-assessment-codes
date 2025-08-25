import React, { useEffect, useState } from 'react';
import axios from 'axios';

// API base URL - if no environment variable is set, it will use localhost:5000
const API_URL = process.env.REACT_APP_API_URL || 'http://localhost:5000';

export default function Q24_TailoringInventory() {
  // State to hold fetched tailoring items
  const [items, setItems] = useState([]);

  // Loading state (true when fetching, false when done)
  const [loading, setLoading] = useState(true);

  // Error message (if API request fails)
  const [error, setError] = useState('');

  // Fetch tailoring items when component loads (useEffect runs once)
  useEffect(() => {
    axios
      .get(`${API_URL}/tailoringItems`) // Call API: http://localhost:5000/tailoringItems
      .then((res) => setItems(res.data)) // Save response data in state
      .catch((err) => setError(err.message)) // Capture error if any
      .finally(() => setLoading(false)); // Always set loading to false
  }, []);

  // Show "Loading..." message while fetching
  if (loading) return <div className="text-center p-4">Loading…</div>;

  // Show error if request fails
  if (error) return <div className="alert alert-danger m-3">Failed to load: {error}</div>;

  // Main UI
  return (
    <div className="container my-5">
      <h1 className="text-center fw-bold mb-4">Tailoring Inventory</h1>

      {/* Responsive table with Bootstrap */}
      <div className="table-responsive">
        <table className="table table-bordered table-striped align-middle">
          <thead className="table-light">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Size</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {/* Loop through tailoring items and display them */}
            {items.map((it) => (
              <tr key={it.id}>
                <td>{it.id}</td>
                <td>{it.name}</td>
                <td>{it.size}</td>
                <td>{it.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

/*


{
  "tailoringItems": [
    { "id": 1, "name": "Men's Shirt", "size": "M", "price": 850 },
    { "id": 2, "name": "Women's Kurti", "size": "L", "price": 1200 },
    { "id": 3, "name": "Children's Frock", "size": "S", "price": 600 },
    { "id": 4, "name": "Men's Trousers", "size": "XL", "price": 950 },
    { "id": 5, "name": "Blazer", "size": "L", "price": 2500 }
  ]
}

2. Install JSON Server (only once):
   npm install -g json-server@0.17.3

3. Start JSON Server (keep running in background):
   json-server --watch db24.json --port 5000

4. Start your React app:
   npm start

5. Visit http://localhost:3000 (React app)
   React app will fetch from http://localhost:5000/tailoringItems


*/
