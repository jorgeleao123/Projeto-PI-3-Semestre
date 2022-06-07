import React, { useEffect, useState } from "react";

import "../../assets/css/style.table.css";
import "../../assets/css/style.components.css";
import TableLineCrudAdm from "./TableLineCrudAdm";
import apiUser from "../../apiUser";

function TableSearch() {
  const [admins, setAdmins] = useState(new Array());
  const [users, setUsers] = useState(new Array());

  useEffect(() => {
    buscarDados();
  }, []);

  function buscarDados() {
    apiUser
      .get(``)
      .then((resp) => {
        setUsers(resp.data);
        adicionarAdmins();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function adicionarAdmins() {
    users.map((user) => {
      if(user.role === 'admin') {
        //Como adiciona sem substituir?
        setAdmins(user);
      }
    })
  }

  function deleteAdm(id) {
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
              {admins.map((i) => {
                return(
                  <TableLineCrudAdm
                    id={i.id}
                    nome={i.name}
                    email={i.email}
                    cargo={i.role}
                    deleteAdm={deleteAdm}
                  />
                )
              })}
            </tbody>
          </table>
        </div>
      </section>
    </>
  );
}
export default TableSearch;
