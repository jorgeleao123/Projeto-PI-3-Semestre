import React from "react";

function PerfilFormInfo() {
  return (
    <>
      <div>
          <div className="style__ipt flex__inp">
            <label for="Alterar Email">Alterar Email</label>
            <input type="email" name="" id="" />
          </div>
          <div className="flex__gap">
            <div className="style__ipt">
              <label for="Alterar senha">Alterar senha</label>
              <input type="password" name="" id="" />
            </div>
            <div className="style__ipt">
              <label for="Confirmar senha">Confirmar senha</label>
              <input type="password" name="" id="" />
            </div>
          </div>
          <button className="edit__profile">Salvar Alterações</button>
        </div>
      
    </>
  )
}
export default PerfilFormInfo;