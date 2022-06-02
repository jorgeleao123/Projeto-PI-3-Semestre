import React, { useState } from "react";
import Icon__admin from "../assets/img/icon-admin-carbon.svg";
import '../assets/css/style.complaint.css';
import '../assets/css/style.components.css';
import '../assets/css/style.sidenav.css';
import { useNavigate } from "react-router-dom";


function Navbar() {

  function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("maindash").style.marginLeft = "250px";
  }

  const nameAdm = sessionStorage.getItem("id_user");
  const roleAdm = sessionStorage.getItem("id_user");

  const navigate = useNavigate();

  return (
    <>
      <div className="menu__dash flex justify">
        <div className="flex">
          <img src={Icon__admin} alt="" className="logo__mob" />
          <span className="hamburger" onClick={() => openNav()}>&#9776;</span>
          <button className="adc__admin">
            <a onClick={() => {navigate("/admin")}}>Adicionar Administrador</a>
          </button>
        </div>
        <h4 className="title__page">Dashboard</h4>
        <div className="flex">
          <div className="icon__user__initial"></div>
          <span>
            <h4 className="nameAdmin" id="name">{nameAdm}</h4>
            <h6 className="function__admin" id="function">{roleAdm}</h6>
          </span>
        </div>
      </div>
    </>
  )

  openNav();

}
export default Navbar;