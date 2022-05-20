import React from "react";

import '../assets/css/style.table.css';
import '../assets/css/style.components.css';
import '../assets/css/style.complaint.css';

function TableSearch() {
  return (
    <>
      {/*Input de pesquisa*/}
      <div className="search__crud">
        <input type="search" name="" id="" />
        <i className="fa-solid fa-magnifying-glass"></i>
      </div>
    </>
  )
}
export default TableSearch;