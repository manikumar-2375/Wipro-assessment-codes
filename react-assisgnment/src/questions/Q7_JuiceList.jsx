import React from "react";

const Juice = ({ id, name, price }) => (
  <tr>
    <td>{id}</td>
    <td>{name}</td>
    <td>₹{price}</td>
  </tr>
);

function JuiceList() {
  const juices = [
    { id: 1, name: "Orange Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 },
  ];
  return (
    <div>
      <h3>Q7: Juice Menu (Table + Child)</h3>
      <table border="1" cellPadding="8" style={{ margin: "auto" }}>
        <thead>
          <tr><th>ID</th><th>Juice Name</th><th>Price</th></tr>
        </thead>
        <tbody>
          {juices.map((j) => <Juice key={j.id} {...j} />)}
        </tbody>
      </table>
    </div>
  );
}

export default JuiceList;
