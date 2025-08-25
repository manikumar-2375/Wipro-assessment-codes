import React from "react";

class Car extends React.Component {
  render() {
    const { brand, model, color, year } = this.props;
    return (
      <div>
        <h3>Q2: Car (Class Component)</h3>
        <p>Brand: {brand}</p>
        <p>Model: {model}</p>
        <p>Color: {color}</p>
        <p>Year: {year}</p>
      </div>
    );
  }
}

export default Car;
