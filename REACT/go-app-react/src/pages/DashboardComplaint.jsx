import React, { useEffect, useState } from "react";
// Falta React-router-dom
import "../assets/css/style.components.css";
import "../assets/css/style.complaint.css";

import Sidenav from "../components/Sidenav";
import Divider from "../components/Divider";
import ModalNavbarMobile from "../components/ModalNavbarMobile";
import Navbar from "../components/Navbar";
import NavbarMobile from "../components/NavbarMobile";
import TabContest from "../components/AdminComplaint/TabContest";

import apiContest from "../apiContest";

function DashboardComplaint() {
  const [contestations, setContestations] = useState(new Array());

  useEffect(() => {
    buscarDados();
  }, []);

  function buscarDados() {
    apiContest
      .get(``)
      .then((resp) => {
        console.log(resp.data);
        setContestations(resp.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function manter(contestationId){
    apiContest
      .patch(`/reprove/${contestationId}`)
      .then((resp) => {
        alert("Sucesso!");
        console.log(resp);
      })
      .catch((error) => {
        console.log(error);
      })
      .then(() => {
        window.location.reload(false);
      })
  }

  function descartar(contestationId){
    apiContest
    .patch(`/aprove/${contestationId}`)
    .then((resp) => {
      alert("Sucesso!");
      console.log(resp);
      window.location.reload(false);

    })
    .catch((error) => {
      console.log(error);
    })
    .then(() => {
      window.location.reload(false);
    })
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
            {contestations.map((i) => {
              console.log(i);
              if(i.status === 'em analise'){
                return (
                  <TabContest
                    key={i.id}
                    id={i.id}
                    descricao={i.description}
                    nome_usuario={i.user.name}
                    placa={i.complaint.driver.licensePlate}
                    boletim={i.complaint.bo}
                    data={i.dateTimeContestation}
                    nome_usuario_denuncia={i.complaint.user.name}
                    sexo_usuario_denuncia={i.complaint.user.genre}
                    descricao_denuncia={i.complaint.description}
                    data_denuncia={i.complaint.dateTimeContestation}
                    manter={manter}
                    descartar={descartar}
                  />
                );
              }
            })}
          </section>
          <ModalNavbarMobile />
        </main>
      </div>
      <NavbarMobile />
    </>
  );
}
export default DashboardComplaint;
