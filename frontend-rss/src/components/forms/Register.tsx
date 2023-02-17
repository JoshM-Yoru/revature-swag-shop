import { useContext, useRef } from "react"
import { axiosInstance } from "../../utils/axiosInstance"
import { UserContext } from "../context/UserProvider";
import { User, UserContextState } from "../types/User";

const Register = () => {


    const firstName = useRef<HTMLInputElement>(null);
    const lastName = useRef<HTMLInputElement>(null);
    const email = useRef<HTMLInputElement>(null);
    const password = useRef<HTMLInputElement>(null);

    async function handleRegister(): Promise<User | undefined | void> {
        const registerData = {
            firstName: firstName.current?.value,
            lastName: lastName.current?.value,
            email: email.current?.value,
            password: password.current?.value
        };
        console.log(registerData);

        try {
            await axiosInstance.post("/users/register", registerData);
            alert("New User Registered.");
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <div className="">
            <h2>Register</h2>
            <div className="">
                <label>FIRST NAME</label>
                <div className="">
                    <input ref={firstName} type="text" />
                </div>
                <label>LAST NAME</label>
                <div className="">
                    <input ref={lastName} type="email" />
                </div>
                <label>EMAIL ADDRESS</label>
                <div className="">
                    <input ref={email} type="email" />
                </div>
                <label>PASSWORD</label>
                <div className="">
                    <input ref={password} type='password' />
                </div>
                <button type='button' onClick={handleRegister}>REGISTER</button>
            </div>
        </div>
    )
}

export default Register
