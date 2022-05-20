import React from "react";
// Falta React-router-dom
import '../assets/css/style.components.css';
import '../assets/css/style.complaint.css';
import '../assets/css/style.modais.css';


import Sidenav from '../components/Sidenav';
import Divider from '../components/Divider';
import ModalNavbarMobile from '../components/ModalNavbarMobile';
import Navbar from '../components/Navbar';
import NavbarMobile from '../components/NavbarMobile';
import SearchCrud from '../components/AdminUser/SearchCrud';
import SearchInput from '../components/SearchInput';

function DashboardUser(){
    return (
        <>
            {/*------------------ SIDEBAR -----------------------*/}
            <Sidenav />
            <div id="maindash">
                <Navbar />
                <main className="flex__box">
                    <Divider titulo="Perfil" />
                    <SearchInput />
                    <SearchCrud />
                    <ModalNavbarMobile />
                </main>
            </div>
            <NavbarMobile />
        </>
    )
}

export default DashboardUser;



