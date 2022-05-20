import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.profile.css';

function PerfilFormInfo() {
  return (
    <>
      <div>
          <div className="style__ipt flex__inp">
            <label htmlFor="Alterar Email">Alterar Email</label>
            <input type="email" name="" id="" />
          </div>
          <div className="flex__gap">
            <div className="style__ipt">
              <label htmlFor="Alterar senha">Alterar senha</label>
              <input type="password" name="" id="" />
            </div>
            <div className="style__ipt">
              <label htmlFor="Confirmar senha">Confirmar senha</label>
              <input type="password" name="" id="" />
            </div>
          </div>
          <button className="edit__profile">Salvar Alterações</button>
        </div>
      
    </>
  )
}
export default PerfilFormInfo;