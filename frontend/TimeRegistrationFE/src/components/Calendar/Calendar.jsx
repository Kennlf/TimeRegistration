import { Calendar, momentLocalizer} from 'react-big-calendar';
import moment from 'moment'
import 'moment/locale/da'
import "react-big-calendar/lib/css/react-big-calendar.css"
import './Calendar.css'

//With inspiration from Usman Abdur Rehman from https://www.youtube.com/watch?v=Opjbv-TOb14&t=1309s
//and from https://medium.com/@sajclarke/how-to-populate-react-big-calendar-with-data-from-api-b89dc7362d8

moment.locale('da')

const localizer = momentLocalizer(moment)

const EventList = [
    {
        start: new Date(), end: new Date(), title: "special event"
    }
]

const BasicCalendar = () => {
    return (
    <div className='Calendar'>
        <Calendar localizer={localizer}
        events={EventList}
        startAccessor="start"
        endAccessor="end"

        defaultView='week'
        views={["month", "week", "day", "agenda"]}
        max={moment("2024-06-03T18:00:00").toDate()}
        min={moment("2024-06-03T06:00:00").toDate()}

        formats={{dayHeaderFormat: (date, culture, localizer) =>
            localizer.format(date, 'dddd DD', culture),
            dayRangeHeaderFormat: ({ start, end}, culture, localizer) =>
                `${localizer.format(start, 'MMMM DD', culture)} - ${localizer.format(end, 'MMMM DD', culture)}`}}
        />
    </div>
)
}
export default BasicCalendar
