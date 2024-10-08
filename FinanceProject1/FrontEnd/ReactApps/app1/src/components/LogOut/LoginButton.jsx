import React from 'react'
import { Link } from 'react-router-dom';

const LoginButton = () => {
  return (
    <span className="nav-underline">
    <Link to="/login" className="nav-link">Login</Link>
    </span>
  )
}

export default LoginButton
