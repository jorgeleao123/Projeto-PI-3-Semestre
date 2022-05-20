import React from "react";
// Falta React-router-dom
import '../assets/css/style.components.css';
import "../assets/css/style.complaint.css";
import '../assets/css/style.home.css';
import '../assets/css/style.table.css';


import Sidenav from '../components/Sidenav';
import Divider from '../components/Divider';
import ModalNavbarMobile from '../components/ModalNavbarMobile';
import Navbar from '../components/Navbar';
import NavbarMobile from '../components/NavbarMobile';
import TableComplaint from '../components/Home/TableComplaint';
import Cards from '../components/Home/Cards'

function Index(){


    return (
        <>
            {/*------------------ SIDEBAR -----------------------*/}
            <Sidenav />
            <div id="maindash">
                <Navbar />
                <main className="flex__box">
                    <Divider titulo="Dados" />
                    <section className="">
                    <Cards />
                    <Divider titulo="Casos por Categoria" />
                    <TableComplaint />
                    </section>
                    <ModalNavbarMobile />
                </main>
            </div>
            <NavbarMobile />
        </>
    )
}
export default Index;