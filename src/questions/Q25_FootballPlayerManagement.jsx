import React, { useEffect, useState } from "react";
import axios from "axios";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { Table, Button, Container, Row, Col, Alert } from "react-bootstrap";

// Football Player Management Component
const Q25FootballPlayerManagement = () => {
  const [players, setPlayers] = useState([]);
  const [editingPlayer, setEditingPlayer] = useState(null);
  const [message, setMessage] = useState("");

  // Load players when component mounts
  useEffect(() => {
    fetchPlayers();
  }, []);

  // Fetch all players from db25.json (json-server)
  const fetchPlayers = async () => {
    const res = await axios.get("http://localhost:5001/players");
    setPlayers(res.data);
  };

  // Validation Schema using Yup
  const playerSchema = Yup.object().shape({
    name: Yup.string().min(3).required("Name is required"),
    age: Yup.number().min(16).max(40).required("Age required"),
    position: Yup.string().required("Position required"),
    club: Yup.string().required("Club required"),
    nationality: Yup.string().required("Nationality required"),
    goals: Yup.number().min(0).required("Goals required"),
    matchesPlayed: Yup.number().min(0).required("Matches required"),
    jerseyNumber: Yup.number().min(1).max(99).required("Jersey number required"),
    email: Yup.string().email("Invalid email").required("Email required"),
    contactNumber: Yup.string()
      .matches(/^\d{10}$/, "Must be 10 digits")
      .required("Contact number required"),
  });

  // Handle Add / Update player
  const handleSubmit = async (values, { resetForm }) => {
    if (editingPlayer) {
      // Update player
      await axios.put(`http://localhost:5001/players/${editingPlayer.id}`, values);
      setMessage("Player updated successfully");
    } else {
      // Add new player
      await axios.post("http://localhost:5001/players", values);
      setMessage("Player added successfully");
    }
    resetForm();
    setEditingPlayer(null);
    fetchPlayers();
    setTimeout(() => setMessage(""), 3000);
  };

  // Edit player
  const handleEdit = (player) => {
    setEditingPlayer(player);
  };

  // Delete player
  const handleDelete = async (id) => {
    await axios.delete(`http://localhost:5001/players/${id}`);
    setMessage("Player deleted");
    fetchPlayers();
    setTimeout(() => setMessage(""), 3000);
  };

  return (
    <Container className="mt-4">
      <h2 className="mb-3">Football Player Management</h2>
      {message && <Alert variant="info">{message}</Alert>}

      {/* Form Section */}
      <Formik
        initialValues={
          editingPlayer || {
            name: "",
            age: "",
            position: "",
            club: "",
            nationality: "",
            goals: "",
            matchesPlayed: "",
            jerseyNumber: "",
            email: "",
            contactNumber: "",
          }
        }
        enableReinitialize
        validationSchema={playerSchema}
        onSubmit={handleSubmit}
      >
        {() => (
          <Form className="border p-3 rounded bg-light">
            <Row>
              <Col md={6}>
                <label>Name:</label>
                <Field name="name" className="form-control" />
                <ErrorMessage name="name" component="div" className="text-danger" />
              </Col>
              <Col md={3}>
                <label>Age:</label>
                <Field name="age" type="number" className="form-control" />
                <ErrorMessage name="age" component="div" className="text-danger" />
              </Col>
              <Col md={3}>
                <label>Position:</label>
                <Field as="select" name="position" className="form-control">
                  <option value="">Select</option>
                  <option value="Forward">Forward</option>
                  <option value="Midfielder">Midfielder</option>
                  <option value="Defender">Defender</option>
                  <option value="Goalkeeper">Goalkeeper</option>
                </Field>
                <ErrorMessage name="position" component="div" className="text-danger" />
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <label>Club:</label>
                <Field name="club" className="form-control" />
                <ErrorMessage name="club" component="div" className="text-danger" />
              </Col>
              <Col md={6}>
                <label>Nationality:</label>
                <Field name="nationality" className="form-control" />
                <ErrorMessage name="nationality" component="div" className="text-danger" />
              </Col>
            </Row>

            <Row>
              <Col md={4}>
                <label>Goals:</label>
                <Field name="goals" type="number" className="form-control" />
                <ErrorMessage name="goals" component="div" className="text-danger" />
              </Col>
              <Col md={4}>
                <label>Matches Played:</label>
                <Field name="matchesPlayed" type="number" className="form-control" />
                <ErrorMessage name="matchesPlayed" component="div" className="text-danger" />
              </Col>
              <Col md={4}>
                <label>Jersey Number:</label>
                <Field name="jerseyNumber" type="number" className="form-control" />
                <ErrorMessage name="jerseyNumber" component="div" className="text-danger" />
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <label>Email:</label>
                <Field name="email" className="form-control" />
                <ErrorMessage name="email" component="div" className="text-danger" />
              </Col>
              <Col md={6}>
                <label>Contact Number:</label>
                <Field name="contactNumber" className="form-control" />
                <ErrorMessage name="contactNumber" component="div" className="text-danger" />
              </Col>
            </Row>

            <div className="mt-3">
              <Button type="submit" variant="primary" className="me-2">
                {editingPlayer ? "Update Player" : "Add Player"}
              </Button>
              {editingPlayer && (
                <Button variant="secondary" onClick={() => setEditingPlayer(null)}>
                  Cancel
                </Button>
              )}
            </div>
          </Form>
        )}
      </Formik>

      {/* Player List */}
      <h3 className="mt-4">Player List</h3>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Name</th><th>Age</th><th>Position</th><th>Club</th>
            <th>Goals</th><th>Matches</th><th>Jersey</th><th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p) => (
            <tr key={p.id}>
              <td>{p.name}</td>
              <td>{p.age}</td>
              <td>{p.position}</td>
              <td>{p.club}</td>
              <td>{p.goals}</td>
              <td>{p.matchesPlayed}</td>
              <td>{p.jerseyNumber}</td>
              <td>
                <Button
                  variant="warning"
                  size="sm"
                  className="me-2"
                  onClick={() => handleEdit(p)}
                >
                  Edit
                </Button>
                <Button
                  variant="danger"
                  size="sm"
                  onClick={() => handleDelete(p.id)}
                >
                  Delete
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};

export default Q25FootballPlayerManagement;

// Run JSON Server: json-server --watch db25.json --port 5001
// API Endpoint: http://localhost:5001/players
