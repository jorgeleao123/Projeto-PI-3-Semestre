import React, { useEffect, useState } from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons";

function TableLineCrud(props) {
  const nome = props.nome;
  const email = props.email;
  const publicacoes = props.publicacoes;
  const contestacoes = props.contestacoes;

  return (
    <>
      <tr>
        <td data-label="Nome">{nome}</td>
        <td data-label="Email">{email}</td>
        <td data-label="Publicações">{publicacoes}</td>
        <td data-label="Contestações">{contestacoes}</td>
        <td data-label="">
          <button
            onClick={() => props.deleteUser(props.id)}
            className="remove__button"
          >
            <FontAwesomeIcon icon={faTrash} />
          </button>
        </td>
      </tr>
    </>
  );
}

export default TableLineCrud;
