import React, { useEffect } from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faCertificate,
} from "@fortawesome/free-solid-svg-icons";

import "../../assets/css/style.table.css";
import "../../assets/css/style.components.css";
import "../../assets/css/style.complaint.css";

function TabContest(props) {

  const descricao = props.descricao;
  const nome_usuario = props.nome_usuario;
  const placa = props.placa;
  const boletim = props.boletim;
  const data = props.data;
  const nome_usuario_denuncia = props.nome_usuario_denuncia;
  const sexo_usuario_denuncia = props.sexo_usuario_denuncia;
  const descricao_denuncia = props.descricao_denuncia;
  const data_denuncia = props.data_denuncia;

  useEffect(() =>{
    document.getElementById('defaultOpen').click();
    verificaBoletim();
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

  function verificaBoletim(){
    if(boletim !== ''){
      document.getElementById('boletim_check').style.display = 'block';
    }
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
            <h6>{nome_usuario}</h6>
          </div>
          <div className="info">
            <h3>Placa:</h3>
            <h6>{placa}</h6>
          </div>
          <div className="info">
            <h3>Boletim:</h3>
            <h6>{boletim === '' ? 'Não possui' : boletim}</h6>
          </div>
          <div className="infos__complaint">
            <p className="desc__text">
              {descricao}
            </p>
          </div>
          <br />
          <div className="tab__botton">
            <span className="flex data__tab">
              <p>{data}</p>
            </span>
            <div className="button__tab">
              <button onClick={() => {
                props.manter(props.id)
              }} className="but button">Manter</button>
              <button onClick={() => {
                props.descartar(props.id)
              }} className="but__red button">Remover</button>
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
                  {nome_usuario_denuncia[0]}
                </span>
              </div>
              <span className="infos__user__complaint">
                <h4 id="nameUser">{nome_usuario_denuncia[0] + '******'}</h4>
                <p id="gender">{sexo_usuario_denuncia === 'F' ? 'Mulher' : 'Homem'}</p>
              </span>
            </div>
          </div>
          <span id='boletim_check' className="check__complaint" style={{display: 'none'}}>
            <h6>Possui boletim de ocorrência</h6>
            <FontAwesomeIcon icon={faCertificate} />
          </span>

          <br />
          <div className="infos__complaint">
            <p id="textComplaint">
              {descricao_denuncia}
            </p>
          </div>
          <br />
          <div className="tab__botton">
            <span className="flex data__tab">
              <p>{data_denuncia}</p>
            </span>
          </div>
        </div>
      </div>
    </>
  );
}
export default TabContest;
