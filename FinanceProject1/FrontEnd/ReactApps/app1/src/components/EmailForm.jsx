import React, { useState } from 'react';
import Axios_request from './Axios_request';

const EmailForm = () => {
  // State variables to hold form data
  const [to, setTo] = useState('');
  const [subject, setSubject] = useState('');
  const [text, setText] = useState('');
  const [responseMessage, setResponseMessage] = useState('');

  // Handler for form submission
  const handleSubmit = async (event) => {
    event.preventDefault(); // Prevents the default form submission behavior

    try {
      const response = await Axios_request("post",
        "/send-email",
        {
            to,
            subject,
            text,
        }
      );
      setResponseMessage(`Email sent successfully! Server responded with: ${response.data}`);
    } catch (error) {
      setResponseMessage(`Error sending email: ${error.message}`);
    }
  };

  return (
    <div>
      <h1>Send Email</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="to">To:</label>
          <input
            type="email"
            id="to"
            name="to"
            value={to}
            onChange={(e) => setTo(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="subject">Subject:</label>
          <input
            type="text"
            id="subject"
            name="subject"
            value={subject}
            onChange={(e) => setSubject(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="text">Message:</label>
          <textarea
            id="text"
            name="text"
            rows="4"
            cols="50"
            value={text}
            onChange={(e) => setText(e.target.value)}
            required
          />
        </div>
        <button type="submit">Send Email</button>
      </form>
      {responseMessage && <p>{responseMessage}</p>}
    </div>
  );
};

export default EmailForm;
