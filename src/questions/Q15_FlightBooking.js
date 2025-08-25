import React, { Component, createRef } from "react";

// ---------------- Controlled Component ----------------
class FlightBookingControlled extends Component {
  constructor(props) {
    super(props);
    // State stores form input values (Controlled Component)
    this.state = {
      passengerName: "",
      email: "",
      gender: "",
      meal: "Veg",      // default value
      request: "",
      submittedData: null, // stores submitted data
    };
  }

  // Updates state whenever input changes
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  // On submit, prevent refresh and save form data to submittedData
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      submittedData: {
        passengerName: this.state.passengerName,
        email: this.state.email,
        gender: this.state.gender,
        meal: this.state.meal,
        request: this.state.request,
      },
    });
  };

  render() {
    return (
      <div className="col-md-6">
        <h3>Controlled Flight Booking Form</h3>

        {/* Controlled form with state */}
        <form onSubmit={this.handleSubmit} className="mb-3">

          {/* Passenger Name input */}
          <div className="mb-2">
            <label>Passenger Name</label>
            <input
              type="text"
              name="passengerName"
              value={this.state.passengerName}   // value comes from state
              onChange={this.handleChange}       // updates state on typing
              className="form-control"
            />
          </div>

          {/* Email input */}
          <div className="mb-2">
            <label>Email</label>
            <input
              type="email"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
              className="form-control"
            />
          </div>

          {/* Gender radio buttons */}
          <div className="mb-2">
            <label>Gender</label><br />
            <input
              type="radio"
              name="gender"
              value="Male"
              onChange={this.handleChange}
            /> Male
            <input
              type="radio"
              name="gender"
              value="Female"
              onChange={this.handleChange}
              className="ms-2"
            /> Female
          </div>

          {/* Meal preference dropdown */}
          <div className="mb-2">
            <label>Meal Preference</label>
            <select
              name="meal"
              value={this.state.meal}
              onChange={this.handleChange}
              className="form-control"
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          {/* Special request textarea */}
          <div className="mb-2">
            <label>Special Request</label>
            <textarea
              name="request"
              value={this.state.request}
              onChange={this.handleChange}
              className="form-control"
            />
          </div>

          {/* Submit button */}
          <button type="submit" className="btn btn-primary">Submit</button>
        </form>

        {/* Display submitted data in a table */}
        {this.state.submittedData && (
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>Passenger Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Meal</th>
                <th>Request</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{this.state.submittedData.passengerName}</td>
                <td>{this.state.submittedData.email}</td>
                <td>{this.state.submittedData.gender}</td>
                <td>{this.state.submittedData.meal}</td>
                <td>{this.state.submittedData.request}</td>
              </tr>
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

// ---------------- Uncontrolled Component ----------------
class FlightBookingUncontrolled extends Component {
  constructor(props) {
    super(props);
    // Create refs for each input (Uncontrolled Component)
    this.flightNoRef = createRef();
    this.sourceRef = createRef();
    this.destinationRef = createRef();
    this.dateRef = createRef();
    this.termsRef = createRef();
    this.state = { details: null }; // stores submitted data
  }

  // On submit, read values directly from refs
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({
      details: {
        flightNo: this.flightNoRef.current.value,
        source: this.sourceRef.current.value,
        destination: this.destinationRef.current.value,
        date: this.dateRef.current.value,
        terms: this.termsRef.current.checked, // checkbox value
      },
    });
  };

  render() {
    return (
      <div className="col-md-6">
        <h3>Uncontrolled Flight Booking Form</h3>

        {/* Uncontrolled form using refs */}
        <form onSubmit={this.handleSubmit} className="mb-3">

          <div className="mb-2">
            <label>Flight Number</label>
            <input type="text" ref={this.flightNoRef} className="form-control" />
          </div>

          <div className="mb-2">
            <label>Source</label>
            <input type="text" ref={this.sourceRef} className="form-control" />
          </div>

          <div className="mb-2">
            <label>Destination</label>
            <input type="text" ref={this.destinationRef} className="form-control" />
          </div>

          <div className="mb-2">
            <label>Travel Date</label>
            <input type="date" ref={this.dateRef} className="form-control" />
          </div>

          <div className="mb-2">
            <input type="checkbox" ref={this.termsRef} /> Terms Accepted
          </div>

          <button type="submit" className="btn btn-success">Submit</button>
        </form>

        {/* Display submitted data in card format */}
        {this.state.details && (
          <div className="card p-3">
            <h5>Flight Details</h5>
            <p><strong>Flight Number:</strong> {this.state.details.flightNo}</p>
            <p><strong>Source:</strong> {this.state.details.source}</p>
            <p><strong>Destination:</strong> {this.state.details.destination}</p>
            <p><strong>Date:</strong> {this.state.details.date}</p>
            <p><strong>Terms Accepted:</strong> {this.state.details.terms ? "Yes" : "No"}</p>
          </div>
        )}
      </div>
    );
  }
}

// ---------------- Parent Component ----------------
class FlightBooking extends Component {
  render() {
    return (
      <div className="container mt-4">
        <div className="row">
          {/* Showing both Controlled and Uncontrolled forms side by side */}
          <FlightBookingControlled />
          <FlightBookingUncontrolled />
        </div>
      </div>
    );
  }
}

export default FlightBooking;
