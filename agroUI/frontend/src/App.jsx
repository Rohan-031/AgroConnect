import { useState } from 'react'
import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Landing from './components/Landing'
import SellerDashboard from './components/SellerDashboard'
import AddProduct from './components/AddProduct'
import SignUp from './components/SignUp'
import SignInPage from './components/SignIn'
function App() {

  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route path="/seller" element={<SellerDashboard />} />
          <Route path="/AddProduct" element={<AddProduct />} />
          <Route path="/SignIn" element={<SignInPage/>} />
          <Route path="/SignUp" element={<SignUp />} />
          {/* <Route path="/about" element={<About />} /> */}
        </Routes>
      </Router>
    </>
  )
}

export default App
