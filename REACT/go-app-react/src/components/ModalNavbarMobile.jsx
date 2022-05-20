import React from "react";
// import { useNavigate } from "react-router-dom";


function ModalNavbarMobile() {

    // const navegator = useNavigate();

    return (
        <>
            {/*modal navbar / mains opções de link*/}
            <input className="modal-state" id="modal-1" type="checkbox" />
            <div className="modal">
                <label className="modal__bg" for="modal-1"></label>
                <div className="modal__inner">
                    <a className="options__modal__user"> Perfil</a>
                    <a id="active" className="options__modal__user"> Administrador</a>
                    <hr />
                    <span className="flex justify">
                        <a className="options__modal__user">Sair</a>
                        <i className="fa-solid fa-arrow-right-from-bracket"></i>
                    </span>
                </div>
            </div>
        </>
    )
}
export default ModalNavbarMobile;