import React from "react";
import Icon__admin from "../assets/img/icon-admin-carbon.svg";
import '../assets/css/style.complaint.css';
import '../assets/css/style.components.css';
import '../assets/css/style.sidenav.css';


function Navbar() {

  function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("maindash").style.marginLeft = "250px";

}

// não chamar a função aqui diretamente

  return (
    <>
      <div className="menu__dash flex justify">
        <div className="flex">
          <img src={Icon__admin} alt="" className="logo__mob" />
          <span className="hamburger" onClick={() => openNav()}>&#9776;</span>
          <button className="adc__admin"><a>Adicionar Administrador</a></button>
        </div>
        <h4 className="title__page">Dashboard</h4>
        <div className="flex">
          <div className="icon__user__initial"></div>
          <span>
            <h4 className="nameAdmin" id="name">Jorge Ricardo</h4>
            <h6 className="function__admin" id="function">Lider Técnico</h6>
          </span>
        </div>
      </div>
    </>
  )
}
export default Navbar;