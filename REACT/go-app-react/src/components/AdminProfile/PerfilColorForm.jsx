import React, { useEffect, useState } from "react";

import "../../assets/css/style.table.css";
import "../../assets/css/style.components.css";
import "../../assets/css/style.profile.css";
import Divider from "../Divider";
import apiUser from "../../apiUser";

function PerfilColorForm() {
  const [nameInput, setNameInput] = useState("");
  const [emailInput, setEmailInput] = useState("");
  const [senhaInput, setSenhaInput] = useState("");
  const [confirmarSenhaInput, setConfirmarSenhaInput] = useState("");
  const [colorProfileInput, setColorProfileInput] = useState("");
  const [colorMenuInput, setColorMenuInput] = useState("");

  useEffect(() => {
    buscarDados();
  });

  function buscarDados() {
    apiUser
      .get(``)
      .then((resp) => {
        setNameInput(resp.name);
        setEmailInput(resp.email);
        setColorProfileInput(resp.colorProfile);
        setColorMenuInput(resp.colorMenu);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function atualizarPerfil(id) {
    const data = {
      name: nameInput,
      email: emailInput,
      password: senhaInput,
      colorProfile: colorProfileInput,
      colorMenu: colorMenuInput,
    };

    api.post(``, data)
      .then((resp) => {
        alert("Atualizado com sucesso!");
        buscarDados();
        console(resp);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <>
      <div className="profille__card">
        <div className="profille__capa">
          <input
            type="color"
            value={colorProfileInput}
            onInput={(e) => setColorProfileInput(e.target.value)}
          />
        </div>
        <div className="profile__icon">
          <input
            type="color"
            value={colorMenuInput}
            onInput={(e) => setColorMenuInput(e.target.value)}
          />
        </div>
        <div className="ipts__dash">
          <label htmlFor="Alterar Nome">Alterar Nome</label>
          <input
            value={nameInput}
            type="text"
            name=""
            id="name"
            onInput={(e) => setNameInput(e.target.value)}
          />
        </div>
      </div>
      <Divider titulo="Mais informações" />
      <div>
        <div className="style__ipt flex__inp">
          <label htmlFor="Alterar Email">Alterar Email</label>
          <input
            value={emailInput}
            type="email"
            name=""
            id="email"
            onInput={(e) => setEmailInput(e.target.value)}
          />
        </div>
        <div className="flex__gap">
          <div className="style__ipt">
            <label htmlFor="Alterar senha">Alterar senha</label>
            <input
              type="password"
              name=""
              id="password"
              onInput={(e) => setSenhaInput(e.target.value)}
            />
          </div>
          <div className="style__ipt">
            <label htmlFor="Confirmar senha">Confirmar senha</label>
            <input
              type="password"
              name=""
              id="confirmPassword"
              onInput={(e) => setConfirmarSenhaInput(e.target.value)}
            />
          </div>
        </div>
        <button onClick={() => atualizarPerfil(sessionStorage.getItem("id_adm"))} className="edit__profile">Salvar Alterações</button>
      </div>
    </>
  );
}
export default PerfilColorForm;
