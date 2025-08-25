// Component: AnnouncementList
// Purpose: Displays all announcements from context in a styled list

import React from "react";
import { usePowerCut } from "./PowerCutContext";

export default function AnnouncementList() {
  // Get announcements from context
  const { announcements } = usePowerCut();

  return (
    <div className="card shadow-sm">
      <div className="card-body">
        <h5 className="card-title">Power Cut Announcements</h5>

        {/* Scrollable list area */}
        <div style={{ maxHeight: 300, overflowY: "auto" }}>
          {/* If no announcements */}
          {announcements.length === 0 && (
            <div className="text-muted">No announcements yet.</div>
          )}

          {/* Loop announcements */}
          {announcements.map(a => {
            // Highlight based on keywords
            const bg =
              /urgent|immediate|emergency/i.test(a.message) ? "bg-warning" :
              /maintenance/i.test(a.message) ? "bg-info" : "bg-light";

            return (
              <div key={a.id} className={`border rounded p-2 mb-2 ${bg}`}>
                <div><strong>Street:</strong> {a.street}</div>
                <div><strong>Message:</strong> {a.message}</div>
                <div><strong>Time:</strong> {a.time}</div>
              </div>
            );
          })}
        </div>
      </div>
    </div>
  );
}
