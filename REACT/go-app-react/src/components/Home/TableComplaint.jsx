import React, { useEffect, useState } from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';
import '../../assets/css/style.home.css';
import apiUser from "../../apiUser";

function TableComplaint() {

  useEffect(() => {
    buscarDados();
  })

  const [assedioH, setAssedioH] = useState("-");
  const [assedioM, setAssedioM] = useState("-");
  const [assedioMoralH, setAssedioMoralH] = useState("-");
  const [assedioMoralM, setAssedioMoralM] = useState("-");
  const [racismoH, setRacismoH] = useState("-");
  const [racismoM, setRacismoM] = useState("-");
  const [agressaoFisicaH, setAgressaoFisicaH] = useState("-");
  const [agressaoFisicaM, setAgressaoFisicaM] = useState("-");
  const [agressaoVerbalH, setAgressaoVerbalH] = useState("-");
  const [agressaoVerbalM, setAgressaoVerbalM] = useState("-");
  const [homofobiaH, setHomofobiaH] = useState("-");
  const [homofobiaM, setHomofobiaM] = useState("-");

  function buscarDados(){
    //requisição que irá pegar casos por categoria
    apiUser.get()
    .then((resp) => {
      setAssedioH(resp);
      setAssedioM(resp);
      setAssedioMoralH(resp);
      setAssedioMoralM(resp);
      setRacismoH(resp);
      setRacismoM(resp);
      setAgressaoFisicaH(resp);
      setAgressaoFisicaM(resp);
      setAgressaoVerbalH(resp);
      setAgressaoVerbalM(resp);
      setHomofobiaH(resp);
      setHomofobiaM(resp);
    })
    .catch((error) => {
      console.error(error);
    })
  }


  return (
    <>
      {/*Table home*/}
      <div className="flex__box">
          <table>
            <thead>
              <tr>
                <th scope="col">Cor</th>
                <th scope="col">Categoria</th>
                <th scope="col">Homens</th>
                <th scope="col">Mulheres</th>
                <th scope="col">Total</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__assedio circle"></div></span></td>
                <td data-label="Categoria">Assédio</td>
                <td data-label="Homens">{assedioH}</td>
                <td data-label="Mulheres">{assedioM}</td>
                <td data-label="Total">{assedioH + assedioM}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__assedio__moral circle"></div></span></td>
                <td data-label="Categoria">Assédio Moral</td>
                <td data-label="Homens">{assedioMoralH}</td>
                <td data-label="Mulheres">{assedioMoralM}</td>
                <td data-label="Total">{assedioMoralH + assedioMoralM}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__agressao__fisica circle"></div></span></td>
                <td data-label="Categoria">Racismo</td>
                <td data-label="Homens">{racismoH}</td>
                <td data-label="Mulheres">{racismoM}</td>
                <td data-label="Contestações">{racismoH + racismoM}</td>
              </tr>
              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__agressao__verbal circle"></div></span></td>
                <td data-label="Categoria">Agressão Física</td>
                <td data-label="Homens">{agressaoFisicaH}</td>
                <td data-label="Mulheres">{agressaoFisicaM}</td>
                <td data-label="Total">{agressaoFisicaH + agressaoFisicaM}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__homofobia circle"></div></span></td>
                <td data-label="Categoria">Agressão Verbal</td>
                <td data-label="Homens">{agressaoVerbalH}</td>
                <td data-label="Mulheres">{agressaoVerbalM}</td>
                <td data-label="Total">{agressaoVerbalH + agressaoVerbalM}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__racism circle"></div></span></td>
                <td data-label="Categoria">Homofobia</td>
                <td data-label="Homens">{homofobiaH}</td>
                <td data-label="Mulheres">{homofobiaM}</td>
                <td data-label="Total">{homofobiaH + homofobiaM}</td>
              </tr>
            </tbody>
          </table>
        </div>
    </>
  )
}
export default TableComplaint;