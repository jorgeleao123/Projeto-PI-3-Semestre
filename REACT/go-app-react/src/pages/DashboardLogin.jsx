import React from "react";

import '../assets/css/style.sidenav.css';
import '../assets/css/style.components.css';
import '../assets/css/style.modais.css';
import '../assets/css/styles.css';

import Sidenav from '../components/Sidenav';
import ModalNavbarMobile from '../components/ModalNavbarMobile';
import Navbar from '../components/Navbar';
import NavbarMobile from '../components/NavbarMobile';
import FormLogin from '../components/AdminLogin/FormLogin';
import Footer from '../components/AdminLogin/Footer';

function DashboardLogin(){

    return (
        <>
            {/*------------------ SIDEBAR -----------------------*/}
            <Sidenav />
                <main>
                    <FormLogin />
                    <Footer />
                    <ModalNavbarMobile />
                </main>
            <NavbarMobile />
        </>
    )
}

export default DashboardLogin;