import React from "react";

function TableSearch() {
  return (
    <>
      <div className="search__crud">
        <input type="search" name="" id="" />
        <i className="fa-solid fa-magnifying-glass"></i>
      </div>
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
                <td data-label=""><button className="remove__button"><i className="fa-solid fa-trash"></i></button></td>
              </tr>

              <tr>
                <td data-label="Nome">Rafaella Kimberlly</td>
                <td data-label="Email">rafa.kim@gmail.com</td>
                <td data-label="Cargo">20</td>
                <td data-label=""><button className="remove__button"><i className="fa-solid fa-trash"></i></button></td>
              </tr>

              <tr>
                <td data-label="Nome">Rafaella Kimberlly</td>
                <td data-label="Email">rafa.kim@gmail.com</td>
                <td data-label="Cargo">20</td>
                <td data-label=""><button className="remove__button"><i className="fa-solid fa-trash"></i></button></td>
              </tr>

              <tr>
                <td data-label="Nome">Rafaella Kimberlly</td>
                <td data-label="Email">rafa.kim@gmail.com</td>
                <td data-label="Cargo">20</td>
                <td data-label=""><button className="remove__button"><i className="fa-solid fa-trash"></i></button></td>
              </tr>
            </tbody>
          </table>
        </div>
      </section>
    </>
  )
}
export default TableSearch;