import React from "react";
import { useNavigate } from "react-router-dom";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRightFromBracket } from "@fortawesome/free-solid-svg-icons";

function ModalNavbarMobile() {

    const navigate = useNavigate();

    return (
        <>
            {/*modal navbar / mains opções de link*/}
            <input className="modal-state" id="modal-1" type="checkbox" />
            <div className="modal">
                <label className="modal__bg" htmlFor="modal-1"></label>
                <div className="modal__inner">
                    <a onClick={() => navigate("/profile")} className="options__modal__user"> 
                        Perfil
                    </a>
                    <a onClick={() => navigate("/admin")} id="active" className="options__modal__user"> 
                        Administrador
                    </a>
                    <hr />
                    <span className="flex justify">
                        {/* Não sei onde vai quando sai */}
                        <a onClick={() => navigate("/")} className="options__modal__user">Sair</a>
                        <FontAwesomeIcon icon={faArrowRightFromBracket} />
                    </span>
                </div>
            </div>
        </>
    )
}
export default ModalNavbarMobile;