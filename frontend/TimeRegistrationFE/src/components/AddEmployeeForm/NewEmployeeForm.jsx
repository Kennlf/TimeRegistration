import { useState } from 'react';
import './NewEmployeeForm.css';

const NewEmployeeForm = () => {
    const [firstname, setFirstname] = useState("")
    const [lastName, setLastName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const handleSubmit = (e) => {
        e.preventDefault();
    }

        return (
            <div className={"wrapper"}>
                <form onSubmit={[handleSubmit]}>
                    <h1>Ny medarbejder</h1>
                    <div className={"input-box"}>
                        <input value={firstname} onChange={(e) => setFirstname(e.target.value)}  type={"text"} placeholder={"Fornavn"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={lastName} onChange={(e) => setLastName(e.target.value)} type={"text"} placeholder={"Efternavn"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={email} onChange={(e) => setEmail(e.target.value)} type={"email"} placeholder={"Email"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={password} onChange={(e) => setPassword(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={password} onChange={(e) => setPassword(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>

                    <button type={"submit"}>Opret</button>
                </form>
            </div>
        );
      
}

export default NewEmployeeForm