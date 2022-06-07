import React, { useEffect } from "react";
// Falta React-router-dom
import "../assets/css/style.components.css";
import "../assets/css/style.complaint.css";

import Sidenav from "../components/Sidenav";
import Divider from "../components/Divider";
import ModalNavbarMobile from "../components/ModalNavbarMobile";
import Navbar from "../components/Navbar";
import NavbarMobile from "../components/NavbarMobile";
import CalendarMobile from "../components/AdminComplaint/CalendarMobile";
import Calendar from "../components/AdminComplaint/Calendar";
import TabContest from "../components/AdminComplaint/TabContest";

import apiContest from "../apiContest";

function DashboardComplaint() {
  useEffect(() => {
    buscarDados();
  }, []);

  function buscarDados() {
    apiContest
      .get(``)
      .then(() => {

      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <>
      {/*------------------ SIDEBAR -----------------------*/}
      <Sidenav />
      <div id="maindash">
        <Navbar />
        <main className="flex__box">
          <Divider titulo="Contestações" />
          <section className="">
            {/* <CalendarMobile /> */}
            <TabContest />
            {/* <Calendar /> */}
          </section>
          <ModalNavbarMobile />
        </main>
      </div>
      <NavbarMobile />
    </>
  );
}
export default DashboardComplaint;
