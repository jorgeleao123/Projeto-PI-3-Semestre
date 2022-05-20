import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';

function FormAddAdmin() {
    return (
        <>
        <div className="content__form">
          <div>
            <div className="flex__gap">
              <div className="style__ipt">
                <label for="Nome">Nome</label>
                <input type="text" name="" id="" />
              </div>
              <div className="style__ipt">
                <label for="Cargo">Cargo</label>
                <input type="text" name="" id="" />
              </div>
            </div>
            <div>
              <div className="flex__gap">
                <div className="style__ipt">
                  <label for="Alterar senha">Senha</label>
                  <input type="password" name="" id="" />
                </div>
                <div className="style__ipt">
                  <label for="Confirmar senha">Confirmar senha</label>
                  <input type="password" name="" id="" />
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