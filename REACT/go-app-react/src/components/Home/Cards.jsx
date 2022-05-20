import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';
import '../../assets/css/style.home.css';

function Cards() {
  return (
    <>
      {/*Cards*/}
      <div className="container__card">
          <div className="content__card">

            <div className="card__dash">
              <div className="info_card">
                <h4>publicações</h4>
                <span className="flex data__tab">
                  <p>Denuncias Publicadas</p>
                </span>
              </div>


              <div className="num__card">
                <div className="num__card__progress">
                  <h1>75</h1>
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
                  <h1>75</h1>
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
                  <h1>75</h1>
                </div>
              </div>
            </div>

          </div>
        </div>
    </>
  )
}
export default Cards;