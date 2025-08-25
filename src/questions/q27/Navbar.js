
import React from "react";
import { NavLink } from "react-router-dom";

export default function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
      <div className="container-fluid">
        <NavLink className="navbar-brand fw-bold" to="/">
          Income Tax Department
        </NavLink>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <NavLink end to="/" className="nav-link">Home</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/add-taxpayer" className="nav-link">Add Taxpayer</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/taxpayer-list" className="nav-link">Taxpayer List</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/calculate-tax" className="nav-link">Calculate Tax</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/tax-rates" className="nav-link">Tax Rates</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/contact" className="nav-link">Contact</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/about" className="nav-link">About</NavLink>
            </li>
            <li className="nav-item">
              <NavLink to="/faq" className="nav-link">FAQ</NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}
