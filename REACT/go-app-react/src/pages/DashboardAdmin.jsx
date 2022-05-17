import React from "react";
import '../assets/css/style.components.css';
import '../assets/css/style.modais.css';
import "../assets/css/style.complaint.css";
import '../assets/css/style.profile.css';
import '../assets/css/style.table.css';
import '../assets/js/script.sidenav.js';

import Sidenav from '../components/Sidenav';
import Divider from '../components/Divider';
import FormAddAdmin from '../components/FormAddAdmin';
import ModalNavbarMobile from '../components/ModalNavbarMobile';
import Navbar from '../components/Navbar';
import NavbarMobile from '../components/NavbarMobile';
import TableSearch from '../components/TableSearch';

function DashboardAdmin(){
    return (
        <>
            {/*------------------ SIDEBAR -----------------------*/}
            <Sidenav />
            <div id="maindash">
                <Navbar />
                <main class="flex__box">
                    <Divider titulo="Adicionar Administrador" />
                    <FormAddAdmin />
                    <Divider titulo="Buscar Admin" />
                    <TableSearch />
                    <ModalNavbarMobile />
                </main>
            </div>
            <NavbarMobile />
        </>
    )
}

export default DashboardAdmin;