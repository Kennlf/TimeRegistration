import { useState } from 'react';
import './NewEmployeeForm.css';
import { API_URL }  from '../../settings';
import { useNavigate } from 'react-router-dom';
const URL = API_URL + "user/register"

const NewEmployeeForm = () => {
    const [firstname, setFirstname] = useState("")
    const [lastName, setLastName] = useState("")
    const [mail, setMail] = useState("")
    const [password, setPassword] = useState("")
    const [confirmPassword, setconfirmPassword] = useState("") 

    const navigate = useNavigate()
    

    const handleSubmit = (e) => {
        e.preventDefault();

        if(password !== confirmPassword){
            alert("Password matched ikke");
            return;
        }
        

        const employee = {mail, password};

        fetch(URL,{
            method: 'POST',
            headers: {"content-Type": "application/json"},
            body: JSON.stringify(employee)
        }).then(response =>{
            if (response.ok){
                navigate("/registerTime")
            console.log('new employee added')
            console.log(employee)
            } else {
                console.error("medarbejderen blev ikke oprettet ordentlig", response.statusText)
            }
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
                        <input value={mail} onChange={(e) => setMail(e.target.value)} type={"email"} placeholder={"Email"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={password} onChange={(e) => setPassword(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={confirmPassword} onChange={(e) => setconfirmPassword(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>

                    <button type={"submit"}>Opret</button>
                </form>
            </div>
        );
      
}


export default NewEmployeeForm