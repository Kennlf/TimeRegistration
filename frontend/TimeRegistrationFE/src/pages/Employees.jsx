import { API_URL } from "../settings.jsx"
const URL = API_URL + "/user"
import { setStatusMsg } from "../components/Status/Status.jsx"

function initEmployee(){
    document.getElementById("submit").onclick = () => {
        createNewEmployee()
        clearFields()
    }
    setStatusMsg("", false)
}

function createNewEmployee(){
    const newEmployee = {}
    newEmployee.firstName = document.getElementById("first-name").value
    newEmployee.lastName = document.getElementById("last-name").value
    newEmployee.employeeNumber = document.getElementById("employee-number").value
    newEmployee.password = document.getElementById("password").value

    const option = {}
    option.method = 'POST'
    option.headers = { 'Accept':'application/json', 'Content-type':'application/json'}
    option.body = JSON.stringify(newEmployee)
    fetch(URL, option)
        .then(r => r.json())

}

function clearFields(){
    document.getElementById("firstname").value = ""
    document.getElementById("lastname").value = ""
    document.getElementById("employeeNumber").value = ""
    document.getElementById("password").value = ""
    setStatusMsg('Brugeren er tilføjet')
}

export {initEmployee, createNewEmployee, clearFields};