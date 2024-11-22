// JavaScript (React)
import React from 'react';

function CourseDetails() {
  return (
    <div>
      <div style={styles.courseContainer}>
        <div style={styles.courseCard}>
          <img src="/java.jpg" alt="Java Course" style={styles.courseImage} />
          <h3>Java Programming</h3>
          <p>Learn the fundamentals of Java programming and object-oriented concepts.</p>
        </div>
        <div style={styles.courseCard}>
          <img src="/net.jpg" alt=".NET Course" style={styles.courseImage} />
          <h3>.NET Development</h3>
          <p>Master .NET framework and build robust applications.</p>
        </div>
        <div style={styles.courseCard}>
          <img src="/python.jpg" alt="Python" style={styles.courseImage} />
          <h3>Python</h3>
          <p>Explore the world of generative AI and its applications.</p>
        </div>
      </div>
      
    </div>
  );
}

const styles = {
  courseContainer: {
    display: 'flex',
    justifyContent: 'space-around',
    padding: '20px',
    backgroundColor: '#f0f0f0',
  },
  courseCard: {
    width: '30%',
    backgroundColor: '#fff',
    padding: '20px',
    borderRadius: '10px',
    boxShadow: '0 4px 8px rgba(0,0,0,0.1)',
    textAlign: 'center',
  },
  courseImage: {
    width: '100%',
    height: '200px', // Set a fixed height for images
    objectFit: 'cover', // Ensures the aspect ratio is maintained
    borderRadius: '10px',
  },
  footer: {
    textAlign: 'center',
    padding: '10px',
    backgroundColor: '#282c34',
    color: 'white',
    marginTop: '20px',
  },
};

export default CourseDetails;
