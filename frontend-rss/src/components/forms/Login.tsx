import { useContext, useRef, useState } from "react"
import { UserContext } from "../context/UserProvider";
import { UserContextState } from "../types/User";

const Login = () => {

    const [error, setError] = useState<boolean>(false);

    const { userLogin } = useContext(UserContext) as UserContextState;

    const email = useRef<HTMLInputElement>(null);
    const password = useRef<HTMLInputElement>(null);

    function handleLogin(): void {
        let loginEmail = email.current?.value;
        let loginPassword = password.current?.value;

        console.log(loginEmail, loginPassword);

        loginEmail && loginPassword && userLogin(loginEmail, loginPassword);

    }

    return (
        <div className="">
            <h2>Login</h2>
            {error ? <h4>Please try again.</h4> : <></>}
            <div className="">
                <label>EMAIL ADDRESS</label>
                <div className="">
                    <input ref={email} type="email" />
                </div>
                <label>PASSWORD</label>
                <div className="">
                    <input ref={password} type='password' />
                </div>
                <button type='button' onClick={handleLogin}>LOGIN</button>
            </div>
        </div>
    )
}

export default Login
