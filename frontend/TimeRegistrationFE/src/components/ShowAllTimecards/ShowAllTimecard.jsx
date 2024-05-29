import { useEffect, useState } from "react";
import "./ShowAllTimecard.jsx"
import { API_URL } from "../../settings.jsx";

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


    /* return <div>
        <ul>
            {timecard.map((timecard =>
            <li key={timecard.timecardNumber}>{timecard.timecardNumber}</li>))}
        </ul>
    </div> */
}

export default ShowTimecard
