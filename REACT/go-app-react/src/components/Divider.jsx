import React from "react";

import '../assets/css/style.table.css';
import '../assets/css/style.components.css';
import '../assets/css/style.complaint.css';

function Divider(props) {
  return (
    <>
      {/*Topic*/}
      <div className="topic__complaint flex justify">
        <span className="flex">
          <p style={{ width: 240 + 'px'}}><b>{props.titulo}</b></p>
        </span>
        <div className="hr"></div>
      </div>
    </>
  )
}
export default Divider;