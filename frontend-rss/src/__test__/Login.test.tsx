import Login from "../components/forms/Login";
import { render } from "@testing-library/react";

test('Renders component correctly', () => {
    render(<Login />)
    expect(true).toBeTruthy();
})
