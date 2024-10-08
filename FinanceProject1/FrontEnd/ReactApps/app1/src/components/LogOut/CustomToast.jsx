
import React, { useState, useEffect } from 'react';

const CustomToast = ({ message, onClose }) => {
  const [show, setShow] = useState(true);
  const [timeElapsed, setTimeElapsed] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setTimeElapsed(prev => prev + 1);
    }, 1000);

    return () => clearInterval(interval);
  }, []);

  return (
    <div className={`toast show position-fixed bottom-0 end-0 m-2 bg-light text-dark`} style={{ opacity: 0.8 }}>
      <div className="toast-header">
        <strong className="me-auto">Notification</strong>
        <small>{timeElapsed}s ago</small>
        <button type="button" className="btn-close" aria-label="Close" onClick={() => {
          setShow(false);
          onClose();
        }}></button>
      </div>
      <div className="toast-body">
        {message}
      </div>
    </div>
  );
};

export default CustomToast;
