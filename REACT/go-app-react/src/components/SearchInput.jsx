import React from "react";

import '../assets/css/style.table.css';
import '../assets/css/style.components.css';
import '../assets/css/style.complaint.css';

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMagnifyingGlass } from "@fortawesome/free-solid-svg-icons";

function TableSearch() {
  return (
    <>
      {/*Input de pesquisa*/}
      <div className="search__crud">
        <input type="search" name="" id="" />
        <FontAwesomeIcon icon={faMagnifyingGlass} />
      </div>
    </>
  )
}
export default TableSearch;