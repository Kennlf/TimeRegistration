import { useEffect, useMemo, useState } from "react";
import { API_URL } from "../../settings.jsx";
import Table from "../Table/Table.jsx";
import { Container } from "react-bootstrap";

const URL = API_URL + "user/getAllEmployee"

const ShowAllEmployees = () => {
    const [employee, setEmployee] = useState([])
    const [fetchError, setFetchError] = useState(null);
    
    useEffect(()=>{

        const fetchEmployees = async () => {
            try{
                const fetchEmployeesData = await fetch(URL);
                if(!fetchEmployeesData) throw Error ("Modtog ikke den ønskede data");
                const allEmployees = await fetchEmployeesData.json();
                console.log(allEmployees);
                setEmployee(allEmployees);
                setFetchError(null);
            } catch (error){
                setFetchError(error);
            }
        }
        fetchEmployees()
    }, [])

    const columns = useMemo(() => [
        {
          Header: "Medarbjeder nummer",
          accessor: "employeeNumber"  
        },
        {
            Header: "Email",
            accessor: "email"
        }
    ],
    []
    )

    return (
        <Container>
        <Table columns={columns} data={employee}/>
    </Container>
    )

};

export default ShowAllEmployees

