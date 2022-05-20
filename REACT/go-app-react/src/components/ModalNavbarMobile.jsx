import React from "react";
// import { useNavigate } from "react-router-dom";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRightFromBracket } from "@fortawesome/free-solid-svg-icons";

function ModalNavbarMobile() {

    // const navegator = useNavigate();

    return (
        <>
            {/*modal navbar / mains opções de link*/}
            <input className="modal-state" id="modal-1" type="checkbox" />
            <div className="modal">
                <label className="modal__bg" htmlFor="modal-1"></label>
                <div className="modal__inner">
                    <a className="options__modal__user"> Perfil</a>
                    <a id="active" className="options__modal__user"> Administrador</a>
                    <hr />
                    <span className="flex justify">
                        <a className="options__modal__user">Sair</a>
                        <FontAwesomeIcon icon={faArrowRightFromBracket} />
                    </span>
                </div>
            </div>
        </>
    )
}
export default ModalNavbarMobile;