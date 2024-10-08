import React, { useRef } from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import LogoutHome from './components/LogOut/LogoutHome';
import MainNavBar from './components/NavigationBars/MainNavBar';
import NotFound from './components/LogOut/NotFound';
import EmailForm from './components/EmailForm';
import UserRegistration from './components/LogOut/UserRegistration';
import LoginHome from './components/Login/LoginHome';
import Login from './components/LogOut/LoginPage';
import ProtectedRoute from './components/Authentication/ProtectedRoute';
import ToastManager from './components/LogOut/ToastManager';

function App() {
  const toastRef =useRef(); //reference to pass to toastManager
  return (
    <div>
      <MainNavBar toastRef={toastRef}/>
      <Routes>
        <Route path='/home' element={<LogoutHome/>}/>
        <Route path="/loginHome" element={<ProtectedRoute element={LoginHome} />} />
        <Route path="/register" element={<UserRegistration />} />
        <Route path="/email" element={<EmailForm/>} />
        <Route path="/login" element={<Login toastRef={toastRef}/>} />
        <Route path="/" element={<Navigate to="/home" replace />} />
        <Route path="*" element={<NotFound/>} /> {/* Default route */}
      </Routes>
      <ToastManager ref={toastRef} />
    </div>
  );
}

export default App;
