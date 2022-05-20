import React from "react";
import Logo from "../assets/img/icon-admin.svg";
import '../assets/css/style.sidenav.css';
import {useNavigate} from "react-router-dom";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRightFromBracket, faHouse, faMagnifyingGlass, faUser, faUserMinus, faUserPlus } from '@fortawesome/free-solid-svg-icons';

function Sidenav() {

    const navigate = useNavigate();

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("maindash").style.marginLeft = "0";
    }

    var navItems = document.querySelectorAll(".mobile-bottom-nav__item");
    navItems.forEach(function (e, i) {
        e.addEventListener("click", function (e) {
            navItems.forEach(function (e2, i2) {
                e2.classList.remove("mobile-bottom-nav__item--active");
            })
            this.classList.add("mobile-bottom-nav__item--active");
        });
    });

    return (
        <>
            <section className="sidenav__desktop">
                <div className="sidenav__desktop__top">
                    <div id="mySidenav" className="sidenav__top">
                        <a className="closebtn" onClick={() => closeNav()}>&times;</a>
                        <img className="logo__sidebar" src={Logo} alt="logo-go-white" />
                        <div className="links__nav">
                            <a onClick={() =>{navigate("/")}}>
                                <FontAwesomeIcon icon={faHouse} /> Home
                            </a>
                            <a onClick={() =>{navigate("/")}}>
                                <FontAwesomeIcon icon={faMagnifyingGlass} /> Contestações
                            </a>
                            <a onClick={() =>{navigate("/user")}}>
                                <FontAwesomeIcon icon={faUserMinus} /> Usuários
                            </a>
                            <a onClick={() =>{navigate("/profile")}}>
                                <FontAwesomeIcon icon={faUser} /> Perfil
                            </a>
                            <a onClick={() =>{navigate("/admin")}} id="active">
                                <FontAwesomeIcon icon={faUserPlus} /> Administrador
                            </a>
                        </div>
                        <a onClick={() =>{navigate("/")}}><FontAwesomeIcon icon={faArrowRightFromBracket} />
                         Sair
                         </a>
                    </div>
                </div>
            </section>
        </>
    )
}
export default Sidenav;