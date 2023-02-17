export interface User {
    userId: number;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    address: string;
    password: string;
}

export interface UserContextState {
    userLogin: (email: string, password: string) => Promise<User | undefined | void>;
}
