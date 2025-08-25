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
import Fruits11 from './questions/Q11_Fruits';
import TelevisionManager12 from './questions/Q12_Television';
import MarriageForm13 from './questions/Q13_MarriageForm';
import AccessoriesForm from './questions/Q14_AccessoriesForm';
import BakingItemsForm from './questions/Q14_BakingItemsForm';
import FlightBooking from './questions/Q15_FlightBooking';
import MovieForm from './questions/Q16_MovieForm';
import Electronics17 from './questions/Q17_Electronics';
import FurnitureStore18 from './questions/Q18_Furniture';
import FestivalApp from "./questions/Q19_FestivalApp";
import RestaurantForm20 from "./questions/Q20_RestaurantForm";
import FruitCommunicationApp from "./questions/Q21_FruitCommunication";
import ChessTournamentForm from "./questions/Q22_ChessTournamentForm";
import Q24TailoringInventory from './questions/Q24_TailoringInventory';
import Q25FootballPlayerManagement from "./questions/Q25_FootballPlayerManagement";
import { PowerCutProvider } from "./questions/q26/PowerCutContext";
import SendAnnouncement from "./questions/q26/SendAnnouncement";
import AnnouncementList from "./questions/q26/AnnouncementList";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./questions/q27/Navbar";
import Home from "./questions/q27/Home";
import AddTaxpayer from "./questions/q27/AddTaxpayer";
import TaxpayerList from "./questions/q27/TaxpayerList";
import CalculateTax from "./questions/q27/CalculateTax";
import TaxRates from "./questions/q27/TaxRates";
import Contact from "./questions/q27/Contact";
import About from "./questions/q27/About";
import FAQ from "./questions/q27/FAQ";
import NotFound from "./questions/q27/NotFound";

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
      <div className="section"><Phone /></div>
      <hr />
      <div className="section"><SweetsList /></div>
      <hr />
      <div className="section"><Electronics /></div>
      <hr />

      <div className="section">
        <CanteenMenu
          canteenName="Campus Food Court"
          location="Block A, Ground Floor"
          openHours="8:00 AM - 8:00 PM"
        />
      </div>

      <hr /><div className="section"><JuiceList /></div>
      <hr /><div className="section"><Restaurant /></div>
      <hr /><div className="section"><TempleList /></div>
      <hr /><div className="section section-wide"><TailorShop /></div>
      <hr /><div className="section"><Fruits11 /></div>
      <hr /><div className="section"><TelevisionManager12 /></div>
      <hr /><div className="section"><MarriageForm13 /></div>
      <div><AccessoriesForm /></div>
      <div><BakingItemsForm /></div>
      <hr /><div className="section"><FlightBooking /></div>
      <div className="section"><MovieForm /></div>
      <hr /><div className="section"><Electronics17 /></div>
      <hr /><div className="section"><FurnitureStore18 /></div>
      <hr /><div className="section"><FestivalApp /></div>
      <hr /><div className="section"><RestaurantForm20 /></div>
      <hr /><div className="section"><FruitCommunicationApp /></div>
      <hr /><div className="section"><ChessTournamentForm /></div>

      <hr />
      <div className="section section-wide">
        <Q24TailoringInventory />
      </div>

      <div className="App">
        <Q25FootballPlayerManagement />
      </div>
      <hr />
      <div className="section">
        <PowerCutProvider>
          <SendAnnouncement />
          <AnnouncementList />
        </PowerCutProvider>
      </div>

      <BrowserRouter>
      <Navbar />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/add-taxpayer" element={<AddTaxpayer />} />
          <Route path="/taxpayer-list" element={<TaxpayerList />} />
          <Route path="/calculate-tax" element={<CalculateTax />} />
          <Route path="/tax-rates" element={<TaxRates />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/about" element={<About />} />
          <Route path="/faq" element={<FAQ />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </BrowserRouter>

    </div>
  );
}

export default App;
