import { createContext, useState } from "react";
import { User, UserContextState } from "../types/User";
import { axiosInstance } from "../../utils/axiosInstance";

interface ProviderProps {
    children: React.ReactNode;
}

export const UserContext = createContext<UserContextState | null>(null);

const UserProvider: React.FC<ProviderProps> = ({ children }) => {

    const [loggedInUser, setloggedInUser] = useState<User | null>();

    async function userLogin(email: string, password: string): Promise<User | undefined | void> {
        try {
            const user = await axiosInstance.post("/users/login", { email, password });

            setloggedInUser(user.data);

            console.log(user.data, " returned from api")

        } catch (e) {
            console.log(e);
        }
    }

    return (
        <UserContext.Provider value={{ userLogin }}>
            {children}
        </UserContext.Provider>
    )
}

export default UserProvider
