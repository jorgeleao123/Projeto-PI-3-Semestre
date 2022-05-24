import React from "react";
// Falta React-router-dom
import '../assets/css/style.components.css';
import "../assets/css/style.complaint.css";


import Sidenav from '../components/Sidenav';
import Divider from '../components/Divider';
import ModalNavbarMobile from '../components/ModalNavbarMobile';
import Navbar from '../components/Navbar';
import NavbarMobile from '../components/NavbarMobile';
import PerfilColorForm from '../components/AdminProfile/PerfilColorForm';

function DashboardProfile(){
    return (
        <>
            {/*------------------ SIDEBAR -----------------------*/}
            <Sidenav />
            <div id="maindash">
                <Navbar />
                <main className="flex__box">
                    <Divider titulo="Perfil" />
                    <section className="flex__box">
                    <PerfilColorForm />
                    </section>
                    <ModalNavbarMobile />
                </main>
            </div>
            <NavbarMobile />
        </>
    )
}

export default DashboardProfile;