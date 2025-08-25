import React, { Component } from "react"; 
import "bootstrap/dist/css/bootstrap.min.css";    // Import Bootstrap CSS

class MarriageForm13 extends Component {
  constructor(props) {
    super(props);   // Call parent constructor
    this.state = {   // Initial state values
      brideName: "", 
      groomName: "", 
      date: "",
      venue: "", 
      submitted: false // check if form submitted
    };
  }

  
  handleChange = (e) => {
    const { name, value } = e.target; // get name and value from input
    this.setState({ [name]: value }); // update that field in state
  };

  
  handleSubmit = (e) => {
    e.preventDefault(); // stop page refresh
    this.setState({ submitted: true }); // mark form as submitted
  };

  render() {
    return (
      <div className="container mt-4"> 
        <div className="card p-4 shadow-sm">  {/* Card for form */}
          <h2 className="text-center mb-4">Marriage Form</h2>

          <form onSubmit={this.handleSubmit}> {/* Form start */}

            {/* Bride Name */}
            <div className="mb-3">
              <label className="form-label">Bride Name</label>
              <input
                type="text"
                className="form-control"
                name="brideName" // same as state key
                value={this.state.brideName} // controlled input
                onChange={this.handleChange} // update state
                required
              />
            </div>

            {/* Groom Name */}
            <div className="mb-3">
              <label className="form-label">Groom Name</label>
              <input
                type="text"
                className="form-control"
                name="groomName"
                value={this.state.groomName}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Date*/}
            <div className="mb-3">
              <label className="form-label">Marriage Date</label>
              <input
                type="date"
                className="form-control"
                name="date"
                value={this.state.date}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Venue */}
            <div className="mb-3">
              <label className="form-label">Venue</label>
              <input
                type="text"
                className="form-control"
                name="venue"
                value={this.state.venue}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show details only if submitted */}
        {this.state.submitted && (
          <div className="card p-4 mt-4 shadow-sm">
            <h3 className="text-center mb-3">Marriage Details</h3>
            <p><strong>Bride Name:</strong> {this.state.brideName}</p>
            <p><strong>Groom Name:</strong> {this.state.groomName}</p>
            <p><strong>Date:</strong> {this.state.date}</p>
            <p><strong>Venue:</strong> {this.state.venue}</p>
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm13;
