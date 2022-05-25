import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';

function CalendarMobile() {
  return (
    <>
      {/*Calendar Mobile*/}
      <div className="container__calendar__mobile">
              <span className="content__calendar_mobile">
                <input type="date" name="calendar__mobile" id="calendar__mobile" />
              </span>
            </div>
    </>
  )
}
export default CalendarMobile;