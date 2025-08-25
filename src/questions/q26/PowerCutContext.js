// Context: PowerCutContext
// Purpose: Centralized store for announcements so all components can share data

import React, { createContext, useContext, useState } from "react";

// Create context object
const PowerCutContext = createContext();

export function PowerCutProvider({ children }) {
  // Announcements state (seeded with sample data)
  const [announcements, setAnnouncements] = useState([
    { id: 3, street: "Abi Avenue",      message: "Maintenance work, power off 3 hrs", time: "09:30:45 AM" },
    { id: 2, street: "Thananya Avenue", message: "Power cut from 1 PM to 4 PM",        time: "10:45:00 AM" },
    { id: 1, street: "Lakshmi Avenue",  message: "Power cut from 2 PM",                time: "11:05:23 AM" },
  ]);

  // Function to add a new announcement
  const addAnnouncement = (street, message) => {
    // Format current time
    const time = new Date().toLocaleTimeString("en-US", {
      hour: "2-digit",
      minute: "2-digit",
      second: "2-digit",
      hour12: true,
    });

    // New announcement object
    const newItem = {
      id: Date.now(),       // Unique ID based on timestamp
      street: street.trim(),
      message: message.trim(),
      time,
    };

    // Add to state (newest first)
    setAnnouncements(prev => [newItem, ...prev]);
  };

  // Provide announcements and addAnnouncement to children
  return (
    <PowerCutContext.Provider value={{ announcements, addAnnouncement }}>
      {children}
    </PowerCutContext.Provider>
  );
}

// Custom hook to use context
export const usePowerCut = () => {
  const ctx = useContext(PowerCutContext);
  if (!ctx) throw new Error("usePowerCut must be used inside PowerCutProvider");
  return ctx;
};
