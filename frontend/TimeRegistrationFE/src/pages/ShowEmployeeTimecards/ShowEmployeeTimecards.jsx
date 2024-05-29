import ShowEmployeeTimecard from "../../components/EmployeeShowTime/ShowTimecard"
import './ShowEmployeeTimecards.css';

const ShowEmployeeTimecards = () => {
    return (
    <div>
        <h1 className="text-center" >Vis medarbejders arbejdstider</h1>
        <table className="table">
            <thead >
                <tr>
                    <th >
                        <a className="text-color" id="sortTimecardNumber" href="#"
                            >Timeseddelsnummer</a>
                    </th>
                    <th>
                        <a className="text-color" id="sortEmail" href="#" >Email</a>
                    </th>
                    <th>
                        <a className="text-color" id="sortDate" href="#" >Dato</a>
                    </th>
                    <th>
                        <a className="text-color" id="sortStartTime" href="#" >Start tid</a>
                    </th>
                    <th>
                        <a className="text-color" id="sortEndTime" href="#" >Slut tid</a>
                    </th>
                    <th>
                        <a className="text-color" id="sortDailyHours" href="#" >Samlet arbejdstid</a>
                    </th>
                </tr>
            </thead>
            <tbody id="tbl-body" className="text-white"></tbody>
        </table>

    </div>
    )

} 
export default ShowEmployeeTimecards