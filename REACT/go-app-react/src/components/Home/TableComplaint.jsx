import React from "react";

import '../../assets/css/style.table.css';
import '../../assets/css/style.components.css';
import '../../assets/css/style.complaint.css';
import '../../assets/css/style.home.css';

function TableComplaint() {
  return (
    <>
      {/*Table home*/}
      <div ClassName="flex__box">
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
                <td data-label="Cor"><span ClassName="td__circle"><div ClassName="circle__assedio circle"></div></span></td>
                <td data-label="Categoria">Assédio</td>
                <td data-label="Homens">20</td>
                <td data-label="Mulheres">20</td>
                <td data-label="Total">15</td>
              </tr>

              <tr>
                <td data-label="Cor"><span ClassName="td__circle"><div ClassName="circle__assedio__moral circle"></div></span></td>
                <td data-label="Categoria">Assédio Moral</td>
                <td data-label="Homens">20</td>
                <td data-label="Mulheres">5</td>
                <td data-label="Total">0</td>
              </tr>

              <tr>
                <td data-label="Cor"><span ClassName="td__circle"><div ClassName="circle__agressao__fisica circle"></div></span></td>
                <td data-label="Categoria">Racismo</td>
                <td data-label="Email">20</td>
                <td data-label="Mulheres">20</td>
                <td data-label="Contestações">15</td>
              </tr>
              <tr>
                <td data-label="Cor"><span ClassName="td__circle"><div ClassName="circle__agressao__verbal circle"></div></span></td>
                <td data-label="Categoria">Agressão Física</td>
                <td data-label="Homens">20</td>
                <td data-label="Mulheres">20</td>
                <td data-label="Total">15</td>
              </tr>

              <tr>
                <td data-label="Cor"><span ClassName="td__circle"><div ClassName="circle__homofobia circle"></div></span></td>
                <td data-label="Categoria">Agressão Verbal</td>
                <td data-label="Homens">20</td>
                <td data-label="Mulheres">20</td>
                <td data-label="Total">15</td>
              </tr>

              <tr>
                <td data-label="Cor"><span ClassName="td__circle"><div ClassName="circle__racism circle"></div></span></td>
                <td data-label="Categoria">Homofobia</td>
                <td data-label="Homens">20</td>
                <td data-label="Mulheres">20</td>
                <td data-label="Total">15</td>
              </tr>
            </tbody>
          </table>
        </div>
    </>
  )
}
export default TableComplaint;