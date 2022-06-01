import React, { useEffect, useState } from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';
import '../../assets/css/style.home.css';
import apiUser from "../../apiUser";


function Cards() {

  const [publicacoes, setPublicacoes] = useState("-");
  const [contestacoes, setContestacoes] = useState("-");
  const [buscas, setBuscas] = useState("-");

  useEffect(() => {
    buscarDados();
  })

  function buscarDados(){
    //requisição que irá pegar casos por categoria
    apiUser.get('')
    .then((resp) => {
      setPublicacoes(resp);
      setContestacoes(resp);
      setBuscas(resp);
    })
    .catch((error) => {
      console.log(error);
    })
  }

  return (
    <>
      {/*Cards*/}
      <div className="container__card">
          <div className="content__card">

            <div className="card__dash">
              <div className="info_card">
                <h4>Publicações</h4>
                <span className="flex data__tab">
                  <p>Denúncias Publicadas</p>
                </span>
              </div>


              <div className="num__card">
                <div className="num__card__progress">
                  <h1>{publicacoes}</h1>
                </div>
              </div>
            </div>


            <div className="card__dash">
              <div className="info_card">
                <h4>Contestações</h4>
                <span className="flex data__tab">
                  <p>Contestações feitas</p>
                </span>
              </div>


              <div className="num__card">
                <div className="num__card__progress">
                  <h1>{contestacoes}</h1>
                </div>
              </div>
            </div>

            <div className="card__dash">
              <div className="info_card">
                <h4>Buscas</h4>
                <span className="flex data__tab">
                  <p>Buscas feitas</p>
                </span>
              </div>

              <div className="num__card">
                <div className="num__card__progress">
                  <h1>{buscas}</h1>
                </div>
              </div>
            </div>

          </div>
        </div>
    </>
  )
}
export default Cards;