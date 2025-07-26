import "./App.css";
import React, { useState, useEffect } from "react";
import Chatbot from "./Chatbot";



function App() {
  return (
    <div className="App">
      <h1 style={{ textAlign: 'center' }}>E-commerce Chat Assistant</h1>
      <Chatbot />
    </div>
  );
}

export default App;
