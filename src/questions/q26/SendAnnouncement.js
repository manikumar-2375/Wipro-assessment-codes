// Component: SendAnnouncement
// Purpose: Provides a form for entering street + message to add a new power cut announcement

import React, { useState } from "react";
import { usePowerCut } from "./PowerCutContext";

export default function SendAnnouncement() {
  // Access context function to add new announcement
  const { addAnnouncement } = usePowerCut();

  // Form input states
  const [street, setStreet] = useState("");
  const [message, setMessage] = useState("");

  // Form validation error state
  const [errors, setErrors] = useState({});

  // Form submit handler
  const handleSubmit = e => {
    e.preventDefault();
    const errs = {};

    // Validate street name
    if (!street.trim()) errs.street = "Street name is required";

    // Validate message
    if (!message.trim()) errs.message = "Message is required";

    setErrors(errs);

    // Stop if errors exist
    if (Object.keys(errs).length) return;

    // Add announcement via context
    addAnnouncement(street, message);

    // Reset form fields
    setStreet("");
    setMessage("");
  };

  return (
    <div className="card shadow-sm mb-3">
      <div className="card-body">
        <h4 className="card-title mb-3">Street Power Cut Announcements</h4>

        {/* Form for entering announcement */}
        <form onSubmit={handleSubmit}>
          {/* Street Input */}
          <div className="mb-3">
            <label className="form-label">Street Name</label>
            <input
              className={`form-control ${errors.street ? "is-invalid" : ""}`}
              value={street}
              onChange={e => setStreet(e.target.value)}
              placeholder="e.g., Lakshmi Avenue"
            />
            {errors.street && <div className="invalid-feedback">{errors.street}</div>}
          </div>

          {/* Message Input */}
          <div className="mb-3">
            <label className="form-label">Message</label>
            <textarea
              rows="3"
              className={`form-control ${errors.message ? "is-invalid" : ""}`}
              value={message}
              onChange={e => setMessage(e.target.value)}
              placeholder="e.g., Power off today 2 PM–5 PM"
            />
            {errors.message && <div className="invalid-feedback">{errors.message}</div>}
          </div>

          {/* Submit Button */}
          <button type="submit" className="btn btn-primary">Send Announcement</button>
        </form>
      </div>
    </div>
  );
}
