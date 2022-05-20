import React from "react";
import '../assets/css/style.complaint.css';
import '../assets/css/style.components.css';
import {useNavigate} from "react-router-dom";


import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleUp, faHouse, faMagnifyingGlass, faUserMinus } from "@fortawesome/free-solid-svg-icons";


function NavbarMobile() {

    const navigate = useNavigate();

    return (
        <>
            {/*menu mobile*/}
            <section className="nav__mobile">
                <nav className="mobile-bottom-nav">
                    <div className="mobile-bottom-nav__item">
                        <div className="mobile-bottom-nav__item-content">
                            <a onClick={() => {navigate('/')}}>
                                <FontAwesomeIcon icon={faHouse} />
                            </a>
                        </div>
                    </div>

                    <div className="mobile-bottom-nav__item">
                        <div className="mobile-bottom-nav__item-content">
                            <a onClick={() => {navigate('/')}}>
                                <FontAwesomeIcon icon={faMagnifyingGlass} />
                            </a>
                        </div>
                    </div>

                    <div className="mobile-bottom-nav__item">
                        <div className="mobile-bottom-nav__item-content">
                            <a onClick={() => {navigate('/user')}}>
                                <FontAwesomeIcon icon={faUserMinus} />
                            </a>
                        </div>
                    </div>


                    <div className="nav__itens__links">
                        <div className="mobile-bottom-nav__item-content">
                            <label htmlFor="modal-1">
                                <FontAwesomeIcon icon={faAngleUp} className="icon__mobile" />
                            </label>
                        </div>
                    </div>
                </nav>
            </section>
        </>
    )
}
export default NavbarMobile;