// JavaScript (React)
import React, { useState } from 'react';


function SignupPage() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [education, setEducation] = useState('');
  const [certificates, setCertificates] = useState(null);

  const handleSignup = (event) => {
    event.preventDefault();
    // Handle signup logic here
    console.log('Signing up with:', { name, email, phone, education, certificates });
  };

  const handleFileChange = (event) => {
    setCertificates(event.target.files[0]);
  };

  return (
    <div className="signup-container">
      <h2>Signup</h2>
      <form onSubmit={handleSignup}>
        <div className="input-group">
          <label>
            Name:
            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Email:
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Phone:
            <input
              type="tel"
              value={phone}
              onChange={(e) => setPhone(e.target.value)}
              required
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Education:
            <input
              type="text"
              value={education}
              onChange={(e) => setEducation(e.target.value)}
              required
            />
          </label>
        </div>
        <div className="input-group">
          <label>
            Certificates:
            <input
              type="file"
              onChange={handleFileChange}
              required
            />
          </label>
        </div>
        <button type="submit" className="signup-button">Signup</button>
      </form>
    </div>
  );
}

export default SignupPage;
