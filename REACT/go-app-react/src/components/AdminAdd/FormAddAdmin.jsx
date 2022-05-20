import React, { useState } from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import api from '../../api';

function FormAddAdmin() {

  const [nomeInput, setNomeInput] = useState("");
  const [cargoInput, setCargoInput] = useState("");
  const [senhaInput, setSenhaInput] = useState("");
  const [senhaConfirmInput, setSenhaConfirmInput] = useState("");

  function cadastrar(){
    
    const data = {
      //tem q ser o msm body da requisicao
      nome: nomeInput,
      role: cargoInput,
      password: senhaInput,
    }

    api.post('', data)
    .then(() => {
      alert('Cadastrado!')
    })
    .catch((error) => {
      console.log(error);
    })

  }

  function validarSenha(){
    if(senhaInput != senhaConfirmInput){
      //função para as senhas serem iguais
    }
  }

    return (
        <>
        <div className="content__htmlForm">
          <div>
            <div className="flex__gap">
              <div className="style__ipt">
                <label htmlFor="Nome">Nome</label>
                <input type="text" name="" id="" onInput={(e) => setNomeInput(e.target.value)}/>
              </div>
              <div className="style__ipt">
                <label htmlFor="Cargo">Cargo</label>
                <input type="text" name="" id="" onInput={(e) => setCargoInput(e.target.value)} />
              </div>
            </div>
            <div>
              <div className="flex__gap">
                <div className="style__ipt">
                  <label htmlFor="Alterar senha">Senha</label>
                  <input type="password" name="" id="" onInput={(e) => setSenhaInput(e.target.value)}/>
                </div>
                <div className="style__ipt">
                  <label htmlFor="Confirmar senha">Confirmar senha</label>
                  <input type="password" name="" id="" onInput={(e) => { setSenhaConfirmInput(e.target.value);
                    validarSenha()}}/>
                </div>
              </div>
              <button className="cad__adm">Cadastrar Administrador</button>
            </div>
        </div>
        </div>
        </>
    )
}
export default FormAddAdmin;