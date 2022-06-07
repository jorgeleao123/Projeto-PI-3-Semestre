import React, { useEffect, useState } from "react";

import "../../assets/css/style.table.css";
import "../../assets/css/style.components.css";
import "../../assets/css/style.complaint.css";

import TableLineCrud from "./TableLineCrud";
import apiUser from "../../apiUser";

function SearchCrud() {
  const [usuarios, setUsuarios] = useState(new Array());

  useEffect(() => {
    buscarDados();
  }, []);

  function buscarDados() {
    apiUser
      .get(``)
      .then((resp) => {
        setUsuarios(resp.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function deleteUser(id) {
    apiUser
      .delete(`/${id}`)
      .then(() => {
        alert("Usuário excluido com sucesso!");
        buscarDados();
      })
      .catch((error) => {
        alert("Não foi possível excluir o usuário");
        console.log(error);
      });
  }

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
                <th scope="col">buscas</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
              {usuarios.map((i) => {
                console.log(i);
                if(i.status === 'ativo'){
                  return (
                    <TableLineCrud
                      key={i.id}
                      id={i.id}
                      nome={i.name}
                      email={i.email}
                      publicacoes={i.postCounter}
                      buscas={i.searchCounter}
                      deleteUser={deleteUser}
                    />
                  );
                }
              })}
            </tbody>
          </table>
        </div>
      </section>
    </>
  );
}
export default SearchCrud;
