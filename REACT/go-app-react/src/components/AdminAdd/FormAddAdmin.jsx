import React, { useState } from "react";

import "../../assets/css/style.table.css";
import "../../assets/css/style.components.css";
import apiUser from "../../apiUser";

function FormAddAdmin() {
  const [nomeInput, setNomeInput] = useState("");
  const [dataNascimentoInput, setDataNascimentoInput] = useState("");
  const [emailInput, setEmailInput] = useState("");
  const [sexoInput, setSexoInput] = useState("");
  const [senhaInput, setSenhaInput] = useState("");
  const [senhaConfirmInput, setSenhaConfirmInput] = useState("");

  function cadastrar() {
    const data = {
      name: nomeInput,
      email: emailInput,
      password: senhaInput,
      role: "adm",
      genre: sexoInput,
      birthDate: dataNascimentoInput,
      state: "Estado",
      city: "Cidade",
      district: "Bairro",
    };

    apiUser
      .post(`/users`, data)
      .then(() => {
        alert("Cadastrado!");
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function validarSenha() {
    if (senhaInput != senhaConfirmInput) {
      alert("As senhas devem ser iguais")
    }
  }

  return (
    <>
      <div className="content__htmlForm">
        <div>
          <div className="flex__gap">
            <div className="style__ipt">
              <label htmlFor="Nome">Nome</label>
              <input
                type="text"
                name=""
                id=""
                onInput={(e) => setNomeInput(e.target.value)}
              />
            </div>
            <div className="style__ipt">
              <label htmlFor="DataNascimento">Data de nascimento</label>
              <input
                type="date"
                name=""
                id="data"
                onInput={(e) => setDataNascimentoInput(e.target.value)}
              />
            </div>
          </div>
          <div className="flex__gap">
            <div className="style__ipt">
              <label htmlFor="Email">Email</label>
              <input
                type="text"
                name=""
                id=""
                onInput={(e) => setEmailInput(e.target.value)}
              />
            </div>
            <div className="style__ipt">
              <label htmlFor="Sexo">Sexo</label>
              <input
                type="text"
                name=""
                id=""
                onInput={(e) => setSexoInput(e.target.value)}
              />
            </div>
          </div>
          <div>
            <div className="flex__gap">
              <div className="style__ipt">
                <label htmlFor="Alterar senha">Senha</label>
                <input
                  type="password"
                  name=""
                  id=""
                  onInput={(e) => setSenhaInput(e.target.value)}
                />
              </div>
              <div className="style__ipt">
                <label htmlFor="Confirmar senha">Confirmar senha</label>
                <input
                  type="password"
                  name=""
                  id="senha"
                  onInput={(e) => {
                    setSenhaConfirmInput(e.target.value);
                    validarSenha();
                  }}
                />
              </div>
            </div>
            <button
              onClick={() => {
                cadastrar();
              }}
              className="cad__adm"
            >
              Cadastrar Administrador
            </button>
          </div>
        </div>
      </div>
    </>
  );
}
export default FormAddAdmin;
