import './App.css';
import Footer from './Components/Footer/Footer';
import Home from './Components/Home/Home';
import LoginPage from './Components/LoginPage';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"
import Main from './Components/Main/Main';
import Navbar from './Components/Navbar/Navbar';

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path='/' element={<LoginPage />} />
          <Route path='/home' element={[<Navbar />, <Home />, <Main />, <Footer />]} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
