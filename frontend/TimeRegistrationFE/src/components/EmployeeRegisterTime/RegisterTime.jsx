import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { API_URL }  from '../../settings';


const RegisterTimeForm = () => {
    //const [timecardNumber, setTimecardNumber] = useState("")
    const [date, setDate] = useState("")
    const [startTime, setStartTime] = useState("")
    const [endTime, setEndTime] = useState("")
    const [dailyHour, setDailyHour] = useState("")
    const [employeeNumber, setEmployeeNumber] = useState("")

    const navigate = useNavigate()

    useEffect(() => {
        const calculateDailyHour = () => {
            const start = new Date(`2000-01-01T${startTime}`)
            const end = new Date(`2000-01-01T${endTime}`)
            const differenceMilsec = end -start
            const differenceHours = differenceMilsec / (1000*60*60)
            setDailyHour(differenceHours.toFixed(2))
        }
        calculateDailyHour()
    }
    , [startTime, endTime])

    const handleStartTimeChange = (e) => {
        setStartTime(e.target.value)
    }
    const handleEndTimeChange = (e) => {
        setEndTime(e.target.value)
    }
 
    const handleSubmit = (e) => {
        e.preventDefault();

        const timecard = {date, startTime, endTime, dailyHours:dailyHour, employeeNumber}

        fetch(`${API_URL}timecard/add/${employeeNumber}`, {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(timecard)
        }).then(response => {
            if (response.ok){
                navigate("/show")
            } else {
                console.error("Registering af timeseddel fejlede", response.statusText)
            }
        })
    }

    return (
        <div className={"wrapper"}>
            <form onSubmit={handleSubmit}>
                <h1>Indtast tider</h1>
                <div className={"input-box"}>
                    <input value={date} onChange={(e) => setDate(e.target.value)} type={"date"} placeholder={"Dato"} />
                </div>
                <div className={"input-box"}>
                    <input value={startTime} onChange={(handleStartTimeChange)} type={"time"} placeholder={'Start tid'} />
                </div>
                <div className={"input-box"}>
                    <input value={endTime} onChange={handleEndTimeChange} type={"time"} placeholder={'Slut tid'} />
                </div>
                <div className={"input-box"}>
                    <input value={dailyHour} type={"number"} placeholder={'Samlet tid'} readOnly />
                </div>
                <div className={"input-box"}>
                    <input value={employeeNumber} onChange={(e) => setEmployeeNumber(e.target.value)} type={"number"} placeholder={'Medarbejdernr.'} />
                </div>
                <button type={"submit"}>Registrer</button>
            </form>
        </div>
    )
} 
export default RegisterTimeForm