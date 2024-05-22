import './App.css'
import {Routes, Route} from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css';
import LoginForm from "./components/LoginForm/LoginForm.jsx";
import NewEmployeeForm from "./components/AddEmployeeForm/NewEmployeeForm.jsx";
import NaviBar from './components/NavBar/Navibar.jsx';


function App() {
    return(
        <>
        <NaviBar/>
        <Routes>
                <Route path="/" element={<LoginForm />} />
                <Route path="/register" element={<NewEmployeeForm />} />
        </Routes>
        </>
    )
}

export default App
