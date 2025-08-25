import React, { useMemo, useState } from "react"; // React core + hooks
import { Formik, Form, Field, ErrorMessage } from "formik"; // Formik for form handling
import * as Yup from "yup"; // Yup for form validation

function ChessTournamentForm() {
  const [players, setPlayers] = useState([]); // State to store registered players

  //  date limits (UI only)
  const { minDobStr, maxDobStr } = useMemo(() => {
    const today = new Date(); // current date
    const max = new Date(today.getFullYear() - 5, today.getMonth(), today.getDate());   // youngest allowed DOB
    const min = new Date(today.getFullYear() - 90, today.getMonth(), today.getDate());  // oldest allowed DOB
    const toStr = (d) =>
      `${d.getFullYear()}-${String(d.getMonth() + 1).padStart(2, "0")}-${String(
        d.getDate()
      ).padStart(2, "0")}`; // format date as YYYY-MM-DD
    return { minDobStr: toStr(min), maxDobStr: toStr(max) }; // return formatted min & max
  }, []);

  // ----- validation schema -----
  const schema = Yup.object({
    playerName: Yup.string().min(3, "Min 3 characters").required("Player Name is required"), // name validation
    dob: Yup.string()
      .required("Date of Birth is required") // required
      .test("age-range", "Age must be between 5 and 90 years", (value) => { // custom age check
        if (!value) return false;
        const birth = new Date(value);
        const today = new Date();
        let age = today.getFullYear() - birth.getFullYear();
        const m = today.getMonth() - birth.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < birth.getDate())) age--;
        return age >= 5 && age <= 90;
      }),
    gender: Yup.string().required("Gender is required"), // required
    fideId: Yup.string()
      .matches(/^\d{8}$/, "FIDE ID must be exactly 8 digits") // 8-digit number
      .required("FIDE ID is required"),
    rating: Yup.number()
      .typeError("Rating must be a number") // numeric validation
      .min(100, "Minimum rating is 100")
      .max(3000, "Maximum rating is 3000")
      .required("Rating is required"),
    email: Yup.string().email("Invalid email").required("Email is required"), // email validation
    mobile: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Mobile must be 10 digits starting with 6-9") // Indian mobile pattern
      .required("Mobile is required"),
    country: Yup.string().required("Country is required"), // required
    category: Yup.string()
      .oneOf(["Under 12", "Under 18", "Open"], "Choose a valid category") // allowed options
      .required("Category is required"),
    parentContact: Yup.string().when("category", { // conditional field for under 12
      is: "Under 12",
      then: (schema) =>
        schema
          .matches(/^[6-9]\d{9}$/, "Parent Contact must be a valid 10-digit number")
          .required("Parent Contact is required for Under 12"),
      otherwise: (schema) => schema.notRequired(),
    }),
    paid: Yup.boolean().oneOf([true], "Payment confirmation is required"), // must check payment
    terms: Yup.boolean().oneOf([true], "You must accept Terms & Conditions"), // must accept T&C
  });

  const initialValues = { // initial form values
    playerName: "",
    dob: "",
    gender: "",
    fideId: "",
    rating: "",
    email: "",
    mobile: "",
    country: "",
    category: "",
    parentContact: "",
    paid: false,
    terms: false,
  };

  const onSubmit = (values, { resetForm }) => { // form submission handler
    console.log("Submitted Player:", values); // log to console
    setPlayers((prev) => [...prev, values]);  // append new player to list
    resetForm();                              // reset form after submit
  };

  return (
    <div className="container my-4"> {/* main container */}
      <div className="row justify-content-center">
        <div className="col-lg-10">
          <div className="card shadow-sm">
            <div className="card-body">
              <h3 className="mb-3">♟️ Chess Tournament Registration</h3>

              <Formik initialValues={initialValues} validationSchema={schema} onSubmit={onSubmit}>
                {({ values }) => (
                  <Form noValidate>
                    <div className="row g-3">
                      {/* Player Name */}
                      <div className="col-md-6">
                        <label className="form-label">Player Name</label>
                        <Field name="playerName" className="form-control" />
                        <ErrorMessage name="playerName" component="div" className="text-danger" />
                      </div>

                      {/* Date of Birth */}
                      <div className="col-md-6">
                        <label className="form-label">Date of Birth</label>
                        <Field
                          name="dob"
                          type="date"
                          className="form-control"
                          min={minDobStr}
                          max={maxDobStr}
                        />
                        <ErrorMessage name="dob" component="div" className="text-danger" />
                      </div>

                      {/* Gender */}
                      <div className="col-md-4">
                        <label className="form-label">Gender</label>
                        <Field as="select" name="gender" className="form-select">
                          <option value="">-- Select --</option>
                          <option>Male</option>
                          <option>Female</option>
                          <option>Other</option>
                        </Field>
                        <ErrorMessage name="gender" component="div" className="text-danger" />
                      </div>

                      {/* FIDE ID */}
                      <div className="col-md-4">
                        <label className="form-label">FIDE ID</label>
                        <Field name="fideId" className="form-control" placeholder="8 digits" />
                        <ErrorMessage name="fideId" component="div" className="text-danger" />
                      </div>

                      {/* Rating */}
                      <div className="col-md-4">
                        <label className="form-label">Rating</label>
                        <Field name="rating" type="number" className="form-control" />
                        <ErrorMessage name="rating" component="div" className="text-danger" />
                      </div>

                      {/* Email */}
                      <div className="col-md-6">
                        <label className="form-label">Email</label>
                        <Field name="email" type="email" className="form-control" />
                        <ErrorMessage name="email" component="div" className="text-danger" />
                      </div>

                      {/* Mobile */}
                      <div className="col-md-6">
                        <label className="form-label">Mobile Number</label>
                        <Field name="mobile" className="form-control" placeholder="10 digits" />
                        <ErrorMessage name="mobile" component="div" className="text-danger" />
                      </div>

                      {/* Country */}
                      <div className="col-md-6">
                        <label className="form-label">Country</label>
                        <Field name="country" className="form-control" />
                        <ErrorMessage name="country" component="div" className="text-danger" />
                      </div>

                      {/* Category */}
                      <div className="col-md-6">
                        <label className="form-label">Category</label>
                        <Field as="select" name="category" className="form-select">
                          <option value="">-- Select --</option>
                          <option>Under 12</option>
                          <option>Under 18</option>
                          <option>Open</option>
                        </Field>
                        <ErrorMessage name="category" component="div" className="text-danger" />
                      </div>

                      {/* Conditional Parent Contact */}
                      {values.category === "Under 12" && (
                        <div className="col-md-6">
                          <label className="form-label">Parent Contact</label>
                          <Field
                            name="parentContact"
                            className="form-control"
                            placeholder="10-digit number"
                          />
                          <ErrorMessage
                            name="parentContact"
                            component="div"
                            className="text-danger"
                          />
                        </div>
                      )}

                      {/* Checkboxes */}
                      <div className="col-md-6 d-flex align-items-center">
                        <div className="form-check me-4">
                          <Field type="checkbox" name="paid" className="form-check-input" id="paid" />
                          <label className="form-check-label" htmlFor="paid">
                            Payment Confirmed
                          </label>
                          <ErrorMessage name="paid" component="div" className="text-danger" />
                        </div>

                        <div className="form-check">
                          <Field type="checkbox" name="terms" className="form-check-input" id="terms" />
                          <label className="form-check-label" htmlFor="terms">
                            I accept Terms &amp; Conditions
                          </label>
                          <ErrorMessage name="terms" component="div" className="text-danger" />
                        </div>
                      </div>

                      {/* Submit Button */}
                      <div className="col-12">
                        <button type="submit" className="btn btn-primary">
                          Register Player
                        </button>
                      </div>
                    </div>
                  </Form>
                )}
              </Formik>
            </div>
          </div>

          {/* Table of submissions */}
          <div className="card mt-4">
            <div className="card-body">
              <h5 className="mb-3">Registered Players</h5>
              {players.length === 0 ? (
                <div className="text-muted">No entries yet.</div> // show when no data
              ) : (
                <div className="table-responsive">
                  <table className="table table-bordered table-striped align-middle">
                    <thead className="table-light">
                      <tr>
                        <th>#</th>
                        <th>Player Name</th>
                        <th>DOB</th>
                        <th>Gender</th>
                        <th>FIDE ID</th>
                        <th>Rating</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>Country</th>
                        <th>Category</th>
                        <th>Parent Contact</th>
                        <th>Paid</th>
                        <th>Accepted T&amp;C</th>
                      </tr>
                    </thead>
                    <tbody>
                      {players.map((p, i) => (
                        <tr key={i}>
                          <td>{i + 1}</td>
                          <td>{p.playerName}</td>
                          <td>{p.dob}</td>
                          <td>{p.gender}</td>
                          <td>{p.fideId}</td>
                          <td>{p.rating}</td>
                          <td>{p.email}</td>
                          <td>{p.mobile}</td>
                          <td>{p.country}</td>
                          <td>{p.category}</td>
                          <td>{p.parentContact || "-"}</td> {/* show '-' if empty */}
                          <td>{p.paid ? "Yes" : "No"}</td>
                          <td>{p.terms ? "Yes" : "No"}</td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ChessTournamentForm; 
