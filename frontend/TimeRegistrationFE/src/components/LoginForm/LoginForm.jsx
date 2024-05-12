// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';
import './LoginForm.css';

const LoginForm = () => { 
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    const handleSubmit = (e) => {
        e.preventDefault();
    }
        return (
            <div className={"wrapper"}>
                <form onSubmit={[handleSubmit]}>
                    <h1>Login</h1>
                    <div className={"input-box"}>
                        <input value={username} onChange={(e) => setUsername(e.target.value)} type={"username"} placeholder={"Brugernavn"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={password} onChange={(e) => setPassword(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>

                    <div className={"forgot"}>
                        <a href={"#"}>Glemt password</a>
                    </div>
                    <button type={"submit"}>Login</button>
                </form>
                <div className={"new-user"}>
                <a href={'./register'}>Ny bruger? Opret bruger</a>
                </div>
            </div>
        );
    }


export default LoginForm