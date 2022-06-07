import React, { useEffect, useState } from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons";

function TableLineCrud(props) {
  const nome = props.nome;
  const email = props.email;
  const publicacoes = props.publicacoes;
  const buscas = props.buscas;

  return (
    <>
      <tr>
        <td data-label="Nome">{nome}</td>
        <td data-label="Email">{email}</td>
        <td data-label="Publicações">{publicacoes}</td>
        <td data-label="Buscas">{buscas}</td>
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
