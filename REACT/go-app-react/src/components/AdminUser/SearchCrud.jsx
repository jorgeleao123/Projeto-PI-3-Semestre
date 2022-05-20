import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from '@fortawesome/free-solid-svg-icons';


function SearchCrud() {
  return (
    <>
      {/*Search crud*/}
      <section className="content__feed">
        <div className="flex__box">
        <table>
          <thead>
            <tr>
              <th scope="col">Nome</th>
              <th scope="col">Email</th>
              <th scope="col">Publicações</th>
              <th scope="col">Contestações</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td data-label="Nome">Rafaella Kimberlly</td>
              <td data-label="Email">rafa.kim@gmail.com</td>
              <td data-label="Publicações">20</td>
              <td data-label="Contestações">15</td>
              <td data-label=""><button className="remove__button">
              <FontAwesomeIcon icon={faTrash} /></button></td>
            </tr>
            
            <tr>
              <td data-label="Nome">Fulano de tal</td>
              <td data-label="Email">fulaninho@gmail.com</td>
              <td data-label="Publicações">5</td>
              <td data-label="Contestações">0</td>
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
export default SearchCrud;