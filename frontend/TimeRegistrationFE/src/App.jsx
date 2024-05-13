import './App.css'
import {Routes, Route} from "react-router-dom"
import LoginForm from "./components/LoginForm/LoginForm.jsx";
import NewEmployeeForm from "./components/AddEmployeeForm/NewEmployeeForm.jsx";

function App() {
    return(
        <>
        <Routes>
                <Route path="/" element={<LoginForm />} />
                <Route path="/register" element={<NewEmployeeForm />} />
        </Routes>
        </>
    )
}

export default App
