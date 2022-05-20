import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';
import '../../assets/css/style.home.css';

function Cards() {
  return (
    <>
      {/*Cards*/}
      <div ClassName="container__card">
          <div ClassName="content__card">

            <div ClassName="card__dash">
              <div ClassName="info_card">
                <h4>publicações</h4>
                <span ClassName="flex data__tab">
                  <p>Denuncias Publicadas</p>
                </span>
              </div>


              <div ClassName="num__card">
                <div ClassName="num__card__progress">
                  <h1>75</h1>
                </div>
              </div>
            </div>


            <div ClassName="card__dash">
              <div ClassName="info_card">
                <h4>Contestações</h4>
                <span ClassName="flex data__tab">
                  <p>Contestações feitas</p>
                </span>
              </div>


              <div ClassName="num__card">
                <div ClassName="num__card__progress">
                  <h1>75</h1>
                </div>
              </div>
            </div>

            <div ClassName="card__dash">
              <div ClassName="info_card">
                <h4>Buscas</h4>
                <span ClassName="flex data__tab">
                  <p>Buscas feitas</p>
                </span>
              </div>

              <div ClassName="num__card">
                <div ClassName="num__card__progress">
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