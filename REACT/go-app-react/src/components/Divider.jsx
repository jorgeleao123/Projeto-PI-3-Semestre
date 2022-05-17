import React from "react";

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