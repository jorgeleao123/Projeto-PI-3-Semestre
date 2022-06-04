import React from "react";

// Falta React Router dom
import '../assets/css/style.components.css';
import '../assets/css/style.modais.css';
import "../assets/css/style.complaint.css";
import '../assets/css/style.profile.css';
import '../assets/css/style.table.css';
import '../assets/css/style.sidenav.css';

import Sidenav from '../components/Sidenav';
import Divider from '../components/Divider';
import FormAddAdmin from '../components/AdminAdd/FormAddAdmin';
import ModalNavbarMobile from '../components/ModalNavbarMobile';
import Navbar from '../components/Navbar';
import NavbarMobile from '../components/NavbarMobile';
import TableSearch from '../components/AdminAdd/TableSearch';
import SearchInput from '../components/SearchInput';

function DashboardAdmin(){

    return (
        <>
            {/*------------------ SIDEBAR -----------------------*/}
            <Sidenav />
            <div id="maindash">
                <Navbar />
                <main className="flex__box">
                    <Divider titulo="Adicionar Administrador" />
                    <FormAddAdmin />
                    <Divider titulo="Buscar Admin" />
                    <SearchInput />
                    <TableSearch />
                    <ModalNavbarMobile />
                </main>
            </div>
            <NavbarMobile />
        </>
    )
}

export default DashboardAdmin;