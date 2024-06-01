import { useEffect, useMemo, useState } from "react";
import "./ShowAllTimecard.css"
import { API_URL } from "../../settings.jsx";
import Table from "../Table/Table.jsx";
import { Container } from "react-bootstrap";


const URL = API_URL + "timecard/getAll"

const ShowTimecard = () => {
    const [timecard, setTimecard] = useState([])
    const [fetchError, setFetchError] = useState(null);

    useEffect(() => {

    const fetchTimecard = async () => {
        try{
            const fetchData = await fetch(URL);
            if(!fetchData.ok) throw Error ("Modtog ikke ventede data");
            const employeeTimeCards = await fetchData.json();
            console.log(employeeTimeCards);
            setTimecard(employeeTimeCards);
            setFetchError(null);
        } catch (error){
            setFetchError(error);
        }
    }
    fetchTimecard()
}, [])

const columns = useMemo(() => [
    {
      Header: "Timeseddelsnr",
      accessor: "timecardNumber"  
    },
    {
        Header: "Dato",
        accessor: "date",
    },
    {
        Header: "Starttid",
        accessor: "startTime",
    },
    {
        Header: "Sluttid",
        accessor: "endTime",
    },
    {
        Header: "Total arbejdstid",
        accessor: "dailyHour",
    },
    {
        Header: "Medarbejdernr.",
        accessor: "employeeNumber"
    }
],
[]
)

return (
    <Container>
        <Table columns={columns} data={timecard}/>
    </Container>
)

};

export default ShowTimecard
