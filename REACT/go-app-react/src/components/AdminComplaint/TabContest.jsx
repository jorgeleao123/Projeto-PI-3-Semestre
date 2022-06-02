import React, { useEffect } from "react";

import "../../assets/css/style.table.css";
import "../../assets/css/style.components.css";
import "../../assets/css/style.complaint.css";

function TabContest() {

  useEffect(() =>{
    document.getElementById('defaultOpen').click();
  })
  
  // tab
  function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
  }


  return (
    <>
      {/*Tab 1*/}
      <div className="tab">
        <button
          id="defaultOpen"
          className="tablinks"
          onClick={() => openCity(Event, "contest__tab")}
        >
          Contestação
        </button>
        <button
          className="tablinks"
          onClick={() => openCity(Event, "caso__tab")}
        >
          Caso
        </button>
      </div>

      <div id="contest__tab" className="tabcontent">
        <div className="info__tab">
          <div className="info">
            <h3>Nome:</h3>
            <h6>Maria</h6>
          </div>
          <div className="info">
            <h3>Placa:</h3>
            <h6>ABC1222</h6>
          </div>
          <div className="info">
            <h3>Boletim:</h3>
            <h6>Não possui</h6>
          </div>
          <div className="infos__complaint">
            <p className="desc__text">
              It is a long established fact that a reader will be distracted by
              the readable content of a page when looking at its layout. The
              point of using Lorem Ipsum is that it has a more-or-less normal
              distribution of letters, as opposed to using 'Content here,
              content here', making it look like readable English. Many desktop
              publishing packages and web page editors now use Lorem Ipsum as
              their default model text, and a search for 'lorem ipsum' will
              uncover many web sites still in their infancy. Various versions
              have evolved over the years, sometimes by accident, sometimes on
              purpose (injected humour and the like).
            </p>
          </div>
          <br />
          <div className="tab__botton">
            <span className="flex data__tab">
              <p>09/05/2022</p>
            </span>
            <div className="button__tab">
              <button className="but button">Manter</button>
              <button className="but__red button">Remover</button>
            </div>
          </div>
        </div>
      </div>

      {/*Casos*/}
      <div id="caso__tab" className="tabcontent">
        <div className="info__tab">
          <div className="info">
            <div className="flex">
              <div className="icon__complaint icon__user icon__user__initial">
                <span className="initial__user" id="initialPublication">
                  J
                </span>
              </div>
              <span className="infos__user__complaint">
                <h4 id="nameUser">J**** L****</h4>
                <p id="gender">Mulher</p>
              </span>
            </div>
          </div>
          <span className="check__complaint">
            <h6>Possui boletim de ocorrência</h6>
            <i className="fa-solid fa-certificate"></i>
          </span>

          <br />
          <div className="infos__complaint">
            <p id="textComplaint">
              It is a long established fact that a reader will be distracted by
              the readable content of a page when looking at its layout. The
              point of using Lorem Ipsum is that it has a more-or-less normal
              distribution of letters, as opposed to using 'Content here,
              content here', making it look like readable English. Many desktop
              publishing packages and web page editors now use Lorem Ipsum as
              their default model text, and a search for 'lorem ipsum' will
              uncover many web sites still in their infancy. Various versions
              have evolved over the years, sometimes by accident, sometimes on
              purpose (injected humour and the like).
            </p>
          </div>
          <br />
          <div className="tab__botton">
            <span className="flex data__tab">
              <p>09/05/2022</p>
            </span>
          </div>
        </div>
      </div>
    </>
  );
}
export default TabContest;
