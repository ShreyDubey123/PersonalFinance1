import React from 'react'
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../Authentication/AuthContext';
import Axios_request from '../Axios_request';

const LogoutButton = ({toastRef}) => {
  const { logout } = useAuth();
  const navigate = useNavigate();
    const handleClick = (e) =>{
        
        e.preventDefault();
        Axios_request("get",
          "/logout",
          {}
        ).then(response => {
          console.log(response.data);
          logout();
          // alert('User logout successfully!');
          navigate('/login');
          toastRef.current.showToast('Logout successful..!');
        })
        .catch(error => {
          // console.log(error.data);
          //console.error('Error registering user:', error);
          alert('Error logging out user!');
        });
      };
  return (
    <a type='button' onClick={handleClick}>Logout</a>
  )
}

export default LogoutButton
