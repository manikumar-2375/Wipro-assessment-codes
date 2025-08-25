import React from "react";

class MenuItem extends React.Component {
  render() {
    const { name, price, category, available } = this.props;
    return (
      <li>
        {name} - ₹{price} ({category}) - {available ? "Available" : "Not Available"}
      </li>
    );
  }
}

class Restaurant extends React.Component {
  render() {
    const items = [
      { name: "Paneer Butter Masala", price: 150, category: "Main Course", available: true },
      { name: "Chicken Biryani", price: 200, category: "Main Course", available: true },
      { name: "Masala Dosa", price: 80, category: "Breakfast", available: true },
      { name: "Gulab Jamun", price: 40, category: "Dessert", available: false },
      { name: "Veg Thali", price: 120, category: "Combo", available: true },
    ];
    return (
      <div>
        <h3>Q8: Restaurant (Class Components)</h3>
        <p><b>Name:</b> Spice Hub</p>
        <p><b>Location:</b> Block B, First Floor</p>
        <p><b>Open Hours:</b> 10:00 AM - 10:00 PM</p>
        <h4>Restaurant Menu</h4>
        <ul className="custom-list">
          {items.map((it, i) => <MenuItem key={i} {...it} />)}
        </ul>
      </div>
    );
  }
}

export default Restaurant;
