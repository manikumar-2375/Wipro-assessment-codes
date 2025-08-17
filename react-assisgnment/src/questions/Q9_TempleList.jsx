import React from "react";

function TempleList() {
  const temples = [
    { id: 1, name: "Meenakshi Amman Temple", location: "Madurai, Tamil Nadu", deities: ["Meenakshi", "Sundareswarar"] },
    { id: 2, name: "Sri Venkateswara Temple", location: "Tirupati, Andhra Pradesh", deities: ["Venkateswara", "Lakshmi"] },
    { id: 3, name: "Jagannath Temple", location: "Puri, Odisha", deities: ["Jagannath", "Balabhadra", "Subhadra"] },
  ];
  return (
    <div>
      <h3>Q9: Temple List (Nested map)</h3>
      <table border="1" cellPadding="8" style={{ margin: "auto", width: "90%" }}>
        <thead>
          <tr><th>ID</th><th>Temple Name</th><th>Location</th><th>Deities</th></tr>
        </thead>
        <tbody>
          {temples.map((t) => (
            <tr key={t.id}>
              <td>{t.id}</td>
              <td>{t.name}</td>
              <td>{t.location}</td>
              <td>
                <ul style={{ margin: 0, paddingLeft: 20 }}>
                  {t.deities.map((d, i) => <li key={i}>{d}</li>)}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TempleList;
