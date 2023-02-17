import { BrowserRouter } from 'react-router-dom'
import './App.css'
import UserProvider from './components/context/UserProvider'
import LoginRegister from './components/forms/LoginRegister'

function App() {

    return (
        <BrowserRouter>
            <UserProvider>
                <div className="App">
                    <LoginRegister />
                </div>
            </UserProvider>
        </BrowserRouter>
    )
}

export default App
