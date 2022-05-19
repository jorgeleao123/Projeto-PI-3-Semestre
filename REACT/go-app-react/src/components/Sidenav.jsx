import React from "react";
import Logo from "../assets/img/icon-admin.svg"
import '../assets/css/style.sidenav.css'
// import { faHome } from "@fortawesome/free-solid-svg-icons";
// import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function Sidenav() {

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
                        <a href={{ javascript: void (0) }} className="closebtn" onClick={() => closeNav()}>&times;</a>
                        <img className="logo__sidebar" src={Logo} alt="logo-go-white" />
                        <div className="links__nav">
                            <a><i className="fa-solid fa-house"></i> Home</a>
                            <a><i className="fa-solid fa-magnifying-glass-chart"></i> Contestações</a>
                            <a><i className="fa-solid fa-user-minus"></i> Usuarios</a>
                            <a><i className="fa-solid fa-user"></i> Perfil</a>
                            <a id="active"><i className="fa-solid fa-user-plus"></i> Administrador</a>
                        </div>
                        <a><i className="fa-solid fa-arrow-right-from-bracket"></i> Sair</a>
                    </div>
                </div>
            </section>
        </>
    )
}
export default Sidenav;