
import React, { useState } from 'react';
import CustomToast from './CustomToast';

const ToastManager = React.forwardRef((props, ref) => {
  const [toasts, setToasts] = useState([]);

  const showToast = (message) => {
    setToasts([...toasts, { message, id: Date.now() }]);
  };

  const removeToast = (id) => {
    setToasts(toasts.filter(toast => toast.id !== id));
  };

  // Expose showToast method to parent component via ref
  React.useImperativeHandle(ref, () => ({
    showToast,
  }));

  return (
    <div className="toast-container position-fixed bottom-0 end-0 p-3">
      {toasts.map((toast) => (
        <CustomToast
          key={toast.id}
          message={toast.message}
          onClose={() => removeToast(toast.id)}
        />
      ))}
    </div>
  );
});

export default ToastManager;
