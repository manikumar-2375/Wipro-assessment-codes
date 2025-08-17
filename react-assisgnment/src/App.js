import './App.css';
import React from 'react';


import GroceryList from './questions/Q1_GroceryList';
import Car from './questions/Q2_Car';
import Phone from './questions/Q3_Phone';
import SweetsList from './questions/Q4_SweetsList';
import Electronics from './questions/Q5_Electronics';
import CanteenMenu from './questions/Q6_CanteenMenu';
import JuiceList from './questions/Q7_JuiceList';
import Restaurant from './questions/Q8_Restaurant';
import TempleList from './questions/Q9_TempleList';
import TailorShop from './questions/Q10_TailorShop';

function App() {
  const groceryItems = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

  return (
    <div className="App">

      <div className="section">
        <GroceryList items={groceryItems} />
      </div>

      <hr />

      <div className="section">
        <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />
      </div>

      <hr />

      <div className="section">
        <Phone />
      </div>

      <hr />

      <div className="section">
        <SweetsList />
      </div>

      <hr />

      <div className="section">
        <Electronics />
      </div>

      <hr />

      <div className="section">
        <CanteenMenu
          canteenName="Campus Food Court"
          location="Block A, Ground Floor"
          openHours="8:00 AM - 8:00 PM"
        />
      </div>

      <hr />

      <div className="section">
        <JuiceList />
      </div>

      <hr />

      <div className="section">
        <Restaurant />
      </div>

      <hr />

      <div className="section">
        <TempleList />
      </div>

      <hr />

      <div className="section section-wide">
        <TailorShop />
      </div>

    </div>
  );
}

export default App;
