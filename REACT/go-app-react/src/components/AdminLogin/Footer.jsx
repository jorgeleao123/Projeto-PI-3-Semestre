import React from "react";

import '../../assets/css/styles.css';

function Footer() {
  return (
    <>
      <footer className="footer section">
            <div className="footer__container container grid">
                <div className="footer__rights">
                    <p className="footer__copy">&#169; 2022 GO. Todos os direitos reservados.</p>
                    <div className="footer__terms">
                        <a href="#" className="footer__terms-link">Termos</a>
                        <a href="#" className="footer__terms-link">Politica de privacidade</a>
                    </div>
                </div>
            </div>
        </footer>
    </>
  )
}
export default Footer;