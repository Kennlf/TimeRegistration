import { useEffect, useState } from "react";
import "./ShowTimecard.jsx"
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

}

export default ShowTimecard
