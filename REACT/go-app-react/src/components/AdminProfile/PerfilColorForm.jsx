import React, { useEffect, useState } from "react";

import "../../assets/css/style.table.css";
import "../../assets/css/style.components.css";
import "../../assets/css/style.profile.css";
import Divider from "../Divider";
import apiUser from "../../apiUser";

function PerfilColorForm() {
  const id = sessionStorage.getItem("user_id");

  const [nameInput, setNameInput] = useState();
  const [emailInput, setEmailInput] = useState();
  const [senhaInput, setSenhaInput] = useState();
  const [confirmarSenhaInput, setConfirmarSenhaInput] = useState();
  const [colorProfileInput, setColorProfileInput] = useState();
  const [colorMenuInput, setColorMenuInput] = useState();

  useEffect(() => {
    buscarDados();
  }, []);

  function buscarDados() {
    apiUser
      .get(`/${id}`)
      .then((resp) => {
        console.log(resp.data)
        setNameInput(resp.data.name);
        setEmailInput(resp.data.email);
        setColorProfileInput(resp.data.colorProfile);
        setColorMenuInput(resp.data.colorMenu);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function atualizarPerfil() {
    const data = {
      name: nameInput,
      email: emailInput,
      password: senhaInput,
      colorProfile: colorProfileInput,
      colorMenu: colorMenuInput,
    };

    console.log(data);

    apiUser
      .put(`/${id}`, data)
      .then((resp) => {
        console.log(resp);
        alert("Atualizado com sucesso!");
        sessionStorage.setItem("user_nome", data.name);
        sessionStorage.setItem("user_email", data.email);
        sessionStorage.setItem("user_colorProfile", data.colorProfile);
        sessionStorage.setItem("user_colorMenu", data.colorMenu);
        window.location.reload(false);
        console.log(resp);
      })
      .catch((error) => {
        alert("Verifique os campos!");
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
            onChange={(e) => setColorProfileInput(e.target.value)}
          />
        </div>
        <div className="profile__icon">
          <input
            type="color"
            value={colorMenuInput}
            onChange={(e) => setColorMenuInput(e.target.value)}
          />
        </div>
        <div className="ipts__dash">
          <label htmlFor="Alterar Nome">Alterar Nome</label>
          <input
            value={nameInput}
            type="text"
            id="name"
            onInput={(e) => setNameInput(e.target.value)}
          />
          <span
            className="link__pass"
            id="name_error"
            style={{ display: "none", color: "red" }}
          >
            Nome não pode ser nulo
          </span>
        </div>
      </div>
      <Divider titulo="Mais informações" />
      <div>
        <div className="style__ipt flex__inp">
          <label htmlFor="Alterar Email">Alterar Email</label>
          <input
            value={emailInput}
            type="email"
            id="email"
            onInput={(e) => setEmailInput(e.target.value)}
          />
          <span
            className="link__pass"
            id="email_error"
            style={{ display: "none", color: "red" }}
          >
            Email não pode ser nulo
          </span>
        </div>
        <div className="flex__gap">
          <div className="style__ipt">
            <label htmlFor="Alterar senha">Alterar senha</label>
            <input
              type="password"
              id="password"
              onInput={(e) => setSenhaInput(e.target.value)}
            />
            <span
            className="link__pass"
            id="name_error"
            style={{ display: "none", color: "red" }}
          >
            Senha não pode ser nulo
          </span>
          </div>
          <div className="style__ipt">
            <label htmlFor="Confirmar senha">Confirmar senha</label>
            <input
              type="password"
              id="confirmPassword"
              onInput={(e) => setConfirmarSenhaInput(e.target.value)}
            />
            <span
              className="link__pass"
              id="password_error2"
              style={{ display: "none", color: "red" }}
            >
              As senhas devem ser iguais
            </span>
          </div>
        </div>
        <button onClick={() => atualizarPerfil()} className="edit__profile">
          Salvar Alterações
        </button>
      </div>
    </>
  );
}
export default PerfilColorForm;
