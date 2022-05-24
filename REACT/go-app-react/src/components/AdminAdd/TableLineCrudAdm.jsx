import React from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons";

function TableLineCrudAdm(props) {

  const nome = props.nome;
  const email = props.email;
  const cargo = props.cargo;

  return (
    <>
      <tr>
        <td data-label="Nome">{nome}</td>
        <td data-label="Email">{email}</td>
        <td data-label="Cargo">{cargo}</td>
        <td data-label="">
          <button
          onClick={() => props.deleteAdm(props.id)} 
          className="remove__button">
            <FontAwesomeIcon icon={faTrash} />
          </button>
        </td>
      </tr>
    </>
  );
}

export default TableLineCrudAdm;
