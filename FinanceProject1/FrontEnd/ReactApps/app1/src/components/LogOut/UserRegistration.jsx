import React, { useState } from 'react';
//import axios from 'axios';
import Axios_request from '../Axios_request';
import { useNavigate } from 'react-router-dom';


const UserRegistration = () => {
  const [formData, setFormData] = useState({
    email: '',
    firstName: '',
    lastName: '',
    gender: 'm',
    dob: '',
    password: '',
    isActive: true
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  // const handleSubmit = (e) => {
  //   //const navigate = useNavigate();
  //   e.preventDefault();
  //   axios.post('http://localhost:8080/api/users', formData)
  //     .then(response => {
  //       // console.log(response.data);
  //       alert('User registered successfully!');
  //       //navigate('/login');
  //     })
  //     .catch(error => {
  //       // console.log(error.data);
  //       console.error('Error registering user:', error);
  //       alert('Error registering user!');
  //     });
  // };
  const navigate = useNavigate();
  const handleSubmit = (e) =>{
    
    e.preventDefault();
    Axios_request("post",
      "/register",
      formData
    ).then(response => {
      console.log(response.data);
      if (response.data == 1) {
        alert('User registered successfully!');
        navigate('/login');
      }else{
        alert('Already registered User');
        navigate('/login');
      }
      
    })
    .catch(error => {
      // console.log(error.data);
      // console.error('Error registering user:', error);
      alert('Error registering user!');
    });
  };

  return (
    <div className="container d-flex justify-content-center align-items-center vh-100">
      <div className="card w-100" style={{ maxWidth: '500px' }}>
        <div className="card-body">
          <h2 className="card-title text-center">User Registration</h2>
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">Email Id</label>
              <input
                type="email"
                className="form-control"
                id="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="firstName" className="form-label">First Name</label>
              <input
                type="text"
                className="form-control"
                id="firstName"
                name="firstName"
                value={formData.firstName}
                onChange={handleChange}
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="lastName" className="form-label">Last Name</label>
              <input
                type="text"
                className="form-control"
                id="lastName"
                name="lastName"
                value={formData.lastName}
                onChange={handleChange}
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="gender" className="form-label">Gender</label>
              <select
                className="form-select"
                id="gender"
                name="gender"
                value={formData.gender}
                onChange={handleChange}
                required
              >
                <option value="m">Male</option>
                <option value="f">Female</option>
                <option value="o">Other</option>
              </select>
            </div>
            <div className="mb-3">
              <label htmlFor="dob" className="form-label">Date of Birth</label>
              <input
                type="date"
                className="form-control"
                id="dob"
                name="dob"
                value={formData.dob}
                onChange={handleChange}
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password" className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                id="password"
                name="password"
                value={formData.password}
                onChange={handleChange}
                required
                pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
                title="Password must be minimum eight characters, at least one letter and one number"
              />
            </div>
            <button type="submit" className="btn btn-primary w-100">Register</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default UserRegistration;
