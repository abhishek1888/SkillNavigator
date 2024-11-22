// JavaScript (React)
import React, { useState } from 'react';
import './LoginPage.css';

function LoginPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (event) => {
    event.preventDefault();
    // Handle login logic here
    console.log('Logging in with:', username, password);
  };
  
  return (
    <div className="login-container">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <div className="input-group">
          <label>
            Username:
            <input
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Password:
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </label>
        </div>
        <button type="submit" className="login-button">Login</button>
      </form>
      <div className="alternative-login">
        <p>Or login with:</p>
        <button className="social-button google">Google</button>
        <button className="social-button facebook">Facebook</button>
      </div>
    </div>
  );
}

export default LoginPage;
  