import { useState } from 'react';
import './LoginForm.css';

const LoginForm = () => { 
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const handleSubmit = (e) => {
        e.preventDefault();
    }
        return (
            <div className={"wrapper"}>
                <form onSubmit={[handleSubmit]}>
                    <h1>Login</h1>
                    <div className={"input-box"}>
                        <input value={email} onChange={(e) => setEmail(e.target.value)} type={"email"} placeholder={"Email"} required/>
                    </div>
                    <div className={"input-box"}>
                        <input value={password} onChange={(e) => setPassword(e.target.value)} type={"password"} placeholder={"Password"} required/>
                    </div>

                    <div className={"forgot"}>
                        <a href={"#"}>Glemt password</a>
                    </div>
                    <button type={"submit"}>Login</button>
                </form>
            </div>
        );
    }


export default LoginForm