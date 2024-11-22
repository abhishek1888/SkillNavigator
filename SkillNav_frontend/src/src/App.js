// JavaScript (React)
import React, { useState } from 'react';
import { Route, Routes, Link, useNavigate, useLocation } from 'react-router-dom';
import './App.css';
import AboutModal from './AboutModal';
import CourseDetails from './CourseDetails';
import LoginPage from './login/signup/LoginPage';
import SignupPage from './login/signup/SingupPage';


function App() {
  const [dropdownVisible, setDropdownVisible] = useState(false);
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [modalContent, setModalContent] = useState('about');
  const navigate = useNavigate();
  const location = useLocation();

  const toggleDropdown = () => {
    setDropdownVisible(!dropdownVisible);
  };

  const openAboutModal = () => {
    setModalContent('about');
    setIsModalVisible(true);
  };

  const openContactModal = () => {
    setModalContent('contact');
    setIsModalVisible(true);
  };

  const closeModal = () => {
    setIsModalVisible(false);
    navigate('/');
  };

  return (
    <div style={styles.appContainer}>
      <nav style={styles.navbar}>
        <div style={styles.navbarContent}>
          <div style={styles.navbarLeft}>
            <h1>Skill Navigator</h1>
          </div>
          <div style={styles.navbarRight}>
            <button style={styles.navButton} onClick={openAboutModal}>About</button>
            <button style={styles.navButton} onClick={openContactModal}>Contact</button>
            <div style={styles.dropdown}>
              <button style={styles.navButton} onClick={toggleDropdown}>
                Login/Signup ▼
              </button>
              {dropdownVisible && (
                <div style={styles.dropdownContent}>
                  <Link to="/login" style={styles.dropdownItem} onClick={() => setDropdownVisible(false)}>
                    Login
                  </Link>
                  <Link to="/signup" style={styles.dropdownItem} onClick={() => setDropdownVisible(false)}>
                    Signup
                  </Link>
                </div>
              )}
            </div>
          </div>
        </div>
      </nav>
      <div style={styles.content}>
        <main>
          <Routes>
            <Route path="/" element={<CourseDetails />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/signup" element={<SignupPage />} />
          </Routes>
        </main>
      </div>
      <footer style={styles.footer}>
        <h1>Developed By CodeX</h1>
      </footer>
      <AboutModal isVisible={isModalVisible} onClose={closeModal} content={modalContent} />
    </div>
  );
}

const styles = {
  appContainer: {
    display: 'flex',
    flexDirection: 'column',
    minHeight: '100vh',
  },
  navbar: {
    backgroundColor: '#282c34',
    padding: '10px 20px',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  navbarContent: {
    width: '100%',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  navbarLeft: {
    color: 'white',
  },
  navbarRight: {
    display: 'flex',
    gap: '10px',
    position: 'relative',
  },
  navButton: {
    backgroundColor: '#61dafb',
    border: 'none',
    padding: '10px 20px',
    cursor: 'pointer',
    borderRadius: '5px',
    color: '#282c34',
    fontWeight: 'bold',
  },
  dropdown: {
    position: 'relative',
  },
  dropdownContent: {
    position: 'absolute',
    top: '40px',
    right: '0',
    backgroundColor: '#f9f9f9',
    boxShadow: '0 8px 16px rgba(0,0,0,0.2)',
    zIndex: 1,
    borderRadius: '5px',
    display: 'flex',
    flexDirection: 'column',
  },
  dropdownItem: {
    padding: '10px 20px',
    cursor: 'pointer',
    backgroundColor: '#fff',
    border: 'none',
    width: '100%',
    textAlign: 'left',
    textDecoration: 'none',
    color: '#282c34',
  },
  content: {
    flex: 1,
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
  footer: {
    textAlign: 'center',
    padding: '10px',
    backgroundColor: '#282c34',
    color: 'white',
  },
};

export default App;
