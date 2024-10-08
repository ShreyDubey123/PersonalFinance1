// src/components/Login.js
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import Axios_request from '../Axios_request';
import { useAuth } from '../Authentication/AuthContext';
// Set default withCredentials to true
axios.defaults.withCredentials = true;


const Login = ({toastRef}) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const { login } = useAuth();
  // const handleSubmit = async (e) => {
  //   e.preventDefault();
  //   console.log('Form submitted', { email, password });
  //   try {
  //     const response = await axios.post('http://localhost:8080/api/login', { email, password });
  //     console.log('Response received', response);
  //     if (response.status === 200) {
  //       console.log('Login successful:', response.data);
  //       //sessionStorage.setItem('token', response.data.token);
  //       navigate('/home');
  //     } else {
  //       console.error('Login failed', response);
  //     }
  //   } catch (error) {
  //     console.error('Error during login', error);
  //     alert('Invalid Credentials');
  //   }
  // };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    console.log('Form submitted', { email, password });
    try {
      const response = await Axios_request("post",
        "/login",
        {email, password}
      );
      console.log('Response received', response);
      if (response.status === 200) {
        //console.log('Login successful:', response.data);
        //sessionStorage.setItem('token', response.data.token);
        login();
        navigate('/loginHome');
        toastRef.current.showToast('Login successful..!');
      } else {
        console.error('Login failed', response);
      }
    } catch (error) {
      console.error('Error during login', error);
      alert('Invalid Credentials');
    }
  };

  return (
    <div className="container d-flex justify-content-center align-items-center" >
      <div className="card w-100" style={{ maxWidth: '300px', margin: '20px', padding: '50px 20px '}}>
      <form className="login-form"  onSubmit={handleSubmit}>
        <h3 className="text-center">Login</h3>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">Email Id</label>
          <input
            type="email"
            className="form-control"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="password" className="form-label">Password</label>
          <input
            type="password"
            className="form-control"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary w-100">Login</button>
      </form>
      </div>
    </div>
  );
};

export default Login;
