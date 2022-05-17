import React from "react";
import '../assets/js/script.sidenav.js';


function NavbarMobile() {
    return (
        <>
            {/*menu mobile*/}
            <section className="nav__mobile">
                <nav className="mobile-bottom-nav">
                    <div className="mobile-bottom-nav__item">
                        <div className="mobile-bottom-nav__item-content">
                            <a><i className="fa-solid fa-house"></i></a>
                        </div>
                    </div>

                    <div className="mobile-bottom-nav__item">
                        <div className="mobile-bottom-nav__item-content">
                            <a><i className="fa-solid fa-magnifying-glass-chart"></i></a>
                        </div>
                    </div>

                    <div className="mobile-bottom-nav__item">
                        <div className="mobile-bottom-nav__item-content">
                            <a><i className="fa-solid fa-user-minus"></i></a>
                        </div>
                    </div>


                    <div className="nav__itens__links">
                        <div className="mobile-bottom-nav__item-content">
                            <label for="modal-1">
                                <i className="fa-solid fa-angle-up icon__mobile"></i>
                            </label>
                        </div>
                    </div>
                </nav>
            </section>
        </>
    )
}
export default NavbarMobile;