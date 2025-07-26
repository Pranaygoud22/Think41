import React, { useState } from 'react';
import axios from 'axios';
import './App.css'; 

const Chatbot = () => {
  const [messages, setMessages] = useState([
    { sender: 'bot', text: 'Hi! I am your E-commerce assistant. How can I help you today?' }
  ]);
  const [input, setInput] = useState('');

  const handleSend = async () => {
    if (input.trim() === '') return;

    const newMessages = [...messages, { sender: 'user', text: input }];
    setMessages(newMessages);

    try {
      const response = await axios.post('http://localhost:8080/api/chat', { question: input }); // Adjust endpoint accordingly
      const botMessage = response.data.response || 'Sorry, I could not understand.';

      setMessages([...newMessages, { sender: 'bot', text: botMessage }]);
    } catch (error) {
      console.error(error);
      setMessages([...newMessages, { sender: 'bot', text: 'Error communicating with server.' }]);
    }

    setInput('');
  };

  const handleKeyDown = (e) => {
    if (e.key === 'Enter') handleSend();
  };

  return (
    <div className="chatbot-container">
      <div className="chat-window">
        {messages.map((msg, idx) => (
          <div key={idx} className={`message ${msg.sender}`}>
            {msg.text}
          </div>
        ))}
      </div>
      <div className="input-area">
        <input
          type="text"
          placeholder="Ask me about orders, stock..."
          value={input}
          onChange={(e) => setInput(e.target.value)}
          onKeyDown={handleKeyDown}
        />
        <button onClick={handleSend}>Send</button>
      </div>
    </div>
  );
};

export default Chatbot;
