import React, { Component } from "react";

class MovieForm extends Component {
  constructor(props) {
    super(props);
    console.log("constructor executed");

    this.state = {
      title: "",
      director: "",
      year: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: {
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
      movies: [],
    };
  }

  // 1. static lifecycle
  static getDerivedStateFromProps(props, state) {
    console.log("getDerivedStateFromProps executed");
    return null; // no state change here
  }

  // 2. mount lifecycle
  componentDidMount() {
    console.log("componentDidMount executed");
  }

  // 3. update lifecycle
  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate executed");
    return true;
  }

  getSnapshotBeforeUpdate(prevProps, prevState) {
    console.log("getSnapshotBeforeUpdate executed");
    return null;
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log("componentDidUpdate executed");
  }

  // 4. unmount lifecycle
  componentWillUnmount() {
    console.log("componentWillUnmount executed");
  }

  handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    if (type === "checkbox") {
      this.setState((prevState) => ({
        platforms: {
          ...prevState.platforms,
          [name]: checked,
        },
      }));
    } else {
      this.setState({ [name]: value });
    }
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const { title, director, year, genre, rating, description, platforms } = this.state;

    const selectedPlatforms = Object.keys(platforms).filter(
      (platform) => platforms[platform]
    );

    const newMovie = {
      title,
      director,
      year,
      genre,
      rating,
      description,
      platforms: selectedPlatforms.join(", "),
    };

    this.setState((prevState) => ({
      movies: [...prevState.movies, newMovie],
      // reset form
      title: "",
      director: "",
      year: "",
      genre: "Action",
      rating: "",
      description: "",
      platforms: {
        Netflix: false,
        "Amazon Prime": false,
        "Disney+": false,
        Others: false,
      },
    }));
  };

  render() {
    console.log("render executed");

    return (
      <div className="container mt-4">
        <h2>Movie Form (Q16)</h2>

        <div className="card p-3">
          <h3>Add Movie</h3>
          <form onSubmit={this.handleSubmit}>
            {/* Title */}
            <div className="mb-2">
              <label>Movie Title</label>
              <input
                type="text"
                name="title"
                value={this.state.title}
                onChange={this.handleChange}
                className="form-control"
              />
            </div>

            {/* Director */}
            <div className="mb-2">
              <label>Director</label>
              <input
                type="text"
                name="director"
                value={this.state.director}
                onChange={this.handleChange}
                className="form-control"
              />
            </div>

            {/* Year */}
            <div className="mb-2">
              <label>Release Year</label>
              <input
                type="number"
                name="year"
                value={this.state.year}
                onChange={this.handleChange}
                className="form-control"
              />
            </div>

            {/* Genre */}
            <div className="mb-2">
              <label>Genre</label>
              <select
                name="genre"
                value={this.state.genre}
                onChange={this.handleChange}
                className="form-control"
              >
                <option>Action</option>
                <option>Comedy</option>
                <option>Drama</option>
                <option>Sci-Fi</option>
                <option>Horror</option>
              </select>
            </div>

            {/* Rating */}
            <div className="mb-2">
              <label>Rating</label><br />
              {[1, 2, 3, 4, 5].map((num) => (
                <label key={num} className="me-2">
                  <input
                    type="radio"
                    name="rating"
                    value={num}
                    checked={this.state.rating === String(num)}
                    onChange={this.handleChange}
                  />{" "}
                  {num}
                </label>
              ))}
            </div>

            {/* Description */}
            <div className="mb-2">
              <label>Description</label>
              <textarea
                name="description"
                value={this.state.description}
                onChange={this.handleChange}
                className="form-control"
              />
            </div>

            {/* Platforms */}
            <div className="mb-2">
              <label>Available on Streaming Platforms</label><br />
              {Object.keys(this.state.platforms).map((platform) => (
                <label key={platform} className="me-3">
                  <input
                    type="checkbox"
                    name={platform}
                    checked={this.state.platforms[platform]}
                    onChange={this.handleChange}
                  />{" "}
                  {platform}
                </label>
              ))}
            </div>

            {/* Submit */}
            <button type="submit" className="btn btn-primary">
              Add Movie
            </button>
          </form>
        </div>

        {/* Movie List */}
        {this.state.movies.length > 0 && (
          <table className="table table-bordered mt-3">
            <thead>
              <tr>
                <th>Title</th>
                <th>Director</th>
                <th>Release Year</th>
                <th>Genre</th>
                <th>Rating</th>
                <th>Description</th>
                <th>Available on Platforms</th>
              </tr>
            </thead>
            <tbody>
              {this.state.movies.map((movie, index) => (
                <tr key={index}>
                  <td>{movie.title}</td>
                  <td>{movie.director}</td>
                  <td>{movie.year}</td>
                  <td>{movie.genre}</td>
                  <td>{movie.rating}</td>
                  <td>{movie.description}</td>
                  <td>{movie.platforms}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

export default MovieForm;
