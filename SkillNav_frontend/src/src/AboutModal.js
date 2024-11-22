// JavaScript (React)
import React from 'react';

function AboutModal({ isVisible, onClose, content }) {
  if (!isVisible) return null;

  return (
    <div style={modalStyles.overlay} onClick={onClose}>
      <div style={modalStyles.modal} onClick={(e) => e.stopPropagation()}>
        {content === 'about' ? (
          <>
            <h2>About Skill Navigator</h2>
            <p>
              Skill Navigator is a comprehensive platform designed to help users
              enhance their skills and knowledge across various domains.
            </p>
            <p>
              Our mission is to empower individuals by providing accessible and
              high-quality educational content.
            </p>
          </>
        ) : (
          <>
            <h2>Contact Us</h2>
            <p>Email: contact@skillnavigator.com</p>
            <p>Phone: +123 456 7890</p>
            <p>Address: 123 Skill Lane, Knowledge City</p>
          </>
        )}
        <button style={modalStyles.closeButton} onClick={onClose}>
          Close
        </button>
      </div>
    </div>
  );
}

const modalStyles = {
  overlay: {
    position: 'fixed',
    top: 0,
    left: 0,
    right: 0,
    bottom: 0,
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    zIndex: 1000,
  },
  modal: {
    backgroundColor: '#fff',
    padding: '20px',
    borderRadius: '5px',
    maxWidth: '500px',
    width: '100%',
  },
  closeButton: {
    marginTop: '20px',
    padding: '10px 20px',
    backgroundColor: '#61dafb',
    border: 'none',
    borderRadius: '5px',
    cursor: 'pointer',
    color: '#282c34',
    fontWeight: 'bold',
  },
};

export default AboutModal;
