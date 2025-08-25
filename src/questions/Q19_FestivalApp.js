// src/questions/FestivalApp.js
import React, { useEffect, useState } from "react";

function FestivalApp() {
  const [festival, setFestival] = useState("Diwali");
  const [countdown, setCountdown] = useState(5);

  // Q1. Festival Greeting (Every Render)
  useEffect(() => {
    console.log("Festival App Rendered");
  }); // no dependency array → runs on every render

  // Q2. Welcome Message (Run Once)
  useEffect(() => {
    console.log("Welcome to Diwali Festival App");
    alert("Welcome to Diwali Festival App");
  }, []); // empty dependency → runs only once

  // Q3. Festival Change Tracker (only when festival changes)
  useEffect(() => {
    console.log(`Festival changed to ${festival}`);
  }, [festival]);

  // Q4. Countdown Timer (Cleanup Example)
  useEffect(() => {
    const timer = setInterval(() => {
      setCountdown((prev) => (prev > 0 ? prev - 1 : 0));
    }, 1000);

    return () => {
      clearInterval(timer); // cleanup on unmount
    };
  }, []);

  // Q5. Multiple Dependencies (festival or countdown changes)
  useEffect(() => {
    console.log(
      `Festival or Countdown changed → Festival: ${festival}, Countdown: ${countdown}`
    );
  }, [festival, countdown]);

  // Handler to change festivals
  const changeFestival = () => {
    if (festival === "Diwali") {
      setFestival("Holi");
      setCountdown(1);
    } else if (festival === "Holi") {
      setFestival("Pongal");
      setCountdown(0);
    } else {
      setFestival("Diwali");
      setCountdown(5);
    }
  };

  return (
    <div>
      <h2>Festival: {festival}</h2>
      <h3>Countdown: {countdown}</h3>
      <button onClick={changeFestival}>Change Festival</button>
    </div>
  );
}

export default FestivalApp;
