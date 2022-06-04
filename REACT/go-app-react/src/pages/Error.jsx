import React from "react";
import '../assets/css/error.css'

function Error() {

  return (
    <>
      <section className="container__farol">
        <div className="container__farol">
          <div className="farol__collum"></div>
          <div className="farol__numbers">
            <div className="circle__red">4</div>
            <div className="circle__yellow">0</div>
            <div className="circle__green">4</div>
          </div>
        </div>

        <div className="desc__error">
          <h4>Não foi possivel encontar a página.</h4>
          <p>
            Nos desculpe, infelizmente nós não encontramos a página que você
            queria :(
          </p>
        </div>
      </section>
    </>
  );
}

export default Error;
