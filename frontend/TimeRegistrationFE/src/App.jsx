import './App.css'
import {Routes, Route} from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css';
import LoginForm from "./components/LoginForm/LoginForm.jsx";
import NewEmployeeForm from "./components/AddEmployeeForm/NewEmployeeForm.jsx";
import NaviBar from './components/NavBar/Navibar.jsx';
import ShowTimecard from './components/ShowAllTimecards/ShowAllTimecard.jsx';
import RegisterTime from './components/EmployeeRegisterTime/RegisterTime.jsx'
import BasicCalendar from './components/Calendar/Calendar.jsx';
import ShowAllEmployees from './components/ShowAllEmployees/ShowAllEmployees.jsx';




function App() {
    return(
        <>
        <NaviBar/>
        <Routes>
                <Route path='calendar' element={<BasicCalendar />} />
                <Route path="/" element={<LoginForm />} />
                <Route path="/register" element={<NewEmployeeForm />} />
                <Route path='/show' element={<ShowTimecard />} />
                <Route path='/registerTime' element={<RegisterTime />} />
                <Route path='/showAllEmployees' element={<ShowAllEmployees />} />
        </Routes>
        </>
    )
}

export default App
