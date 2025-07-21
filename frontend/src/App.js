import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import './App.css';
import LoginPage from './components/LoginPage';
import SignupPage from './components/SignupPage';
import Dashboard from './components/Dashboard';
import JuniorAdminDashboard from './components/admin/JuniorAdminDashboard';
import SeniorAdminDashboard from './components/admin/SeniorAdminDashboard';

function App() {
  const [currentPage, setCurrentPage] = useState('login');
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [userRole, setUserRole] = useState(null);
  const [user, setUser] = useState(null);

  useEffect(() => {
    // Check if user is already logged in
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      setUser(userData);
      setIsAuthenticated(true);
      setUserRole(userData.role);
    }
  }, []);

  const switchToSignup = () => setCurrentPage('signup');
  const switchToLogin = () => setCurrentPage('login');
  
  const handleLogin = (userData) => {
    setUser(userData);
    setIsAuthenticated(true);
    setUserRole(userData.role);
  };
  
  const handleLogout = () => {
    localStorage.removeItem('user');
    setIsAuthenticated(false);
    setUserRole(null);
    setUser(null);
    setCurrentPage('login');
  };

  // If authenticated, show appropriate dashboard
  if (isAuthenticated) {
    if (userRole === 'JUNIOR_ADMIN') {
      return <JuniorAdminDashboard onLogout={handleLogout} user={user} />;
    } else if (userRole === 'SENIOR_ADMIN') {
      return <SeniorAdminDashboard onLogout={handleLogout} user={user} />;
    } else {
      return <Dashboard onLogout={handleLogout} user={user} />;
    }
  }

  // Show login/signup pages
  return (
    <div className="App">
      {currentPage === 'login' ? (
        <LoginPage onSwitchToSignup={switchToSignup} onLogin={handleLogin} />
      ) : (
        <SignupPage onSwitchToLogin={switchToLogin} onSignup={handleLogin} />
      )}
    </div>
  );
}

export default App;
