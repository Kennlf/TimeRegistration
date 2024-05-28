import { useState } from 'react';
import './NewEmployeeForm.css';
import { API_URL }  from '../../settings';
const URL = API_URL + "user/register"

const NewEmployeeForm = () => {
    const [firstname, setFirstname] = useState("")
    const [lastName, setLastName] = useState("")
    const [username, setUserName] = useState("")
    const [password, setPassword] = useState("")
    // Det ikke sikkert denne er lavet rigtigt men før skrev man i begge password felter på en gang
    // Der bør også laves en sammenligning af de 2 felter.
    const [password2, setPassword2] = useState("") 
    const [employeeNumber, setEmployeeNumber] = useState(444444) 

    
    

    const handleSubmit = (e) => {
        e.preventDefault();

        const employee = {employeeNumber, username, password};

        fetch(URL,{
            method: 'POST',
            headers: {"content-Type": "application/json"},
            body: JSON.stringify(employee)
        }).then(() =>{
            console.log('new employee added')
            console.log(employee)
        })
        

    }

        return (
            <div className={"wrapper"}>
                <form onSubmit={handleSubmit}>
                    <h1>Ny medarbejder</h1>
                    <div className={"input-box"}>
                        <input value={firstname} onChange={(e) => setFirstname(e.target.value)}  type={"text"} placeholder={"Fornavn"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={lastName} onChange={(e) => setLastName(e.target.value)} type={"text"} placeholder={"Efternavn"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={username} onChange={(e) => setUserName(e.target.value)} type={"email"} placeholder={"Email"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={password} onChange={(e) => setPassword(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={password2} onChange={(e) => setPassword2(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>

                    <button type={"submit"}>Opret</button>
                </form>
            </div>
        );
      
}

/* function newEmployee(){

    const employee = {employeeNumber, username, password};

        fetch(URL,{
            method: 'POST',
            headers: {"content-Type": "application/json"},
            body: JSON.stringify(employee)
        }).then(() =>{
            console.log('new employee added')
            console.log(employee)
        })
} */


export default NewEmployeeForm