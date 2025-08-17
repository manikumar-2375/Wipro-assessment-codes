import React from "react";

const ServiceCard = ({ service }) => (
  <div className="col-12 col-md-4 mb-4">
    <div className="card h-100 shadow-sm">
      <div className="card-body">
        <h5 className="card-title">{service.serviceName}</h5>
        <p className="card-text"><b>Price:</b> ${service.price}</p>
        <p className="mb-1"><b>Fabrics:</b></p>
        <ul className="mb-0">
          {service.fabricsAvailable.map((fab, i) => <li key={i}>{fab}</li>)}
        </ul>
      </div>
    </div>
  </div>
);

function TailorShop() {
  const services = [
    { serviceName: "Shirt",   price: 20,  fabricsAvailable: ["Cotton", "Linen", "Polyester"] },
    { serviceName: "Pants",   price: 30,  fabricsAvailable: ["Denim", "Wool", "Chino"] },
    { serviceName: "Lehenga", price: 150, fabricsAvailable: ["Silk", "Georgette", "Chiffon"] },
    { serviceName: "Blouse",  price: 40,  fabricsAvailable: ["Cotton", "Silk", "Satin"] },
  ];

  return (
    <div>
      <h3>Q10: Tailoring Shop (Bootstrap + Component Injection)</h3>
      <div className="container">
        <div className="row">
          {services.map((s, i) => <ServiceCard key={i} service={s} />)}
        </div>
      </div>
    </div>
  );
}

export default TailorShop;
