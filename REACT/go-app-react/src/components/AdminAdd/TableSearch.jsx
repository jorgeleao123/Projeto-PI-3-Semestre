import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons";

function TableSearch() {

  

  return (
    <>
      <section className="content__feed">
        <div className="flex__box">
          <table>
            <thead>
              <tr>
                <th scope="col">Nome</th>
                <th scope="col">Email</th>
                <th scope="col">Cargo</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td data-label="Nome">Rafaella Kimberlly</td>
                <td data-label="Email">rafa.kim@gmail.com</td>
                <td data-label="Cargo">20</td>
                <td data-label=""><button className="remove__button">
                <FontAwesomeIcon icon={faTrash} /></button></td>
              </tr>

              <tr>
                <td data-label="Nome">Rafaella Kimberlly</td>
                <td data-label="Email">rafa.kim@gmail.com</td>
                <td data-label="Cargo">20</td>
                <td data-label=""><button className="remove__button">
                <FontAwesomeIcon icon={faTrash} /></button></td>
              </tr>

            </tbody>
          </table>
        </div>
      </section>
    </>
  )
}
export default TableSearch;