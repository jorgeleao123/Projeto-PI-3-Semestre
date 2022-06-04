import React, { useEffect, useState } from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';
import '../../assets/css/style.home.css';
import apiUser from "../../apiUser";
import apiReport from "../../apiReport";

function TableComplaint() {

  useEffect(() => {
    buscarDados();
  }, []);

  const [obj, setObj] = useState();

  function buscarDados(){

    //requisição que irá pegar casos por categoria
    apiReport.get(`/countsByType`)
    .then((resp) => {
      setObj(resp.data);
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
                <td data-label="Homens">{obj?.assedioHomem}</td>
                <td data-label="Mulheres">{obj?.assedioMulher}</td>
                <td data-label="Total">{obj?.assedioHomem + obj?.assedioMulher}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__assedio__moral circle"></div></span></td>
                <td data-label="Categoria">Assédio Moral</td>
                <td data-label="Homens">{obj?.assedioMoralHomem}</td>
                <td data-label="Mulheres">{obj?.assedioMoralMulher}</td>
                <td data-label="Total">{obj?.assedioMoralHomem + obj?.assedioMoralMulher}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__agressao__fisica circle"></div></span></td>
                <td data-label="Categoria">Racismo</td>
                <td data-label="Homens">{obj?.racismoHomem}</td>
                <td data-label="Mulheres">{obj?.racismoMulher}</td>
                <td data-label="Contestações">{obj?.racismoHomem + obj?.racismoMulher}</td>
              </tr>
              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__agressao__verbal circle"></div></span></td>
                <td data-label="Categoria">Agressão Física</td>
                <td data-label="Homens">{obj?.agressaoFisicaHomem}</td>
                <td data-label="Mulheres">{obj?.agressaoFisicaMulher}</td>
                <td data-label="Total">{obj?.agressaoFisicaHomem + obj?.agressaoFisicaMulher}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__homofobia circle"></div></span></td>
                <td data-label="Categoria">Agressão Verbal</td>
                <td data-label="Homens">{obj?.agressaoVerbalHomem}</td>
                <td data-label="Mulheres">{obj?.agressaoVerbalMulher}</td>
                <td data-label="Total">{obj?.agressaoVerbalHomem + obj?.agressaoVerbalMulher}</td>
              </tr>

              <tr>
                <td data-label="Cor"><span className="td__circle"><div className="circle__racism circle"></div></span></td>
                <td data-label="Categoria">Homofobia</td>
                <td data-label="Homens">{obj?.homofobiaHomem}</td>
                <td data-label="Mulheres">{obj?.homofobiaMulher}</td>
                <td data-label="Total">{obj?.homofobiaHomem + obj?.homofobiaMulher}</td>
              </tr>
            </tbody>
          </table>
        </div>
    </>
  )
}
export default TableComplaint;