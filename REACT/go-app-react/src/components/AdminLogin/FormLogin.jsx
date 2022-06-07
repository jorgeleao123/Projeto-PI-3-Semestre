import React, { useState } from "react";

import "../../assets/css/styles.css";
import apiUser from "../../apiUser";

import ImageContact from "../../assets/img/login.png";
import ImageEye from "../../assets/img/eye.png";
import { useNavigate } from "react-router-dom";

function FormLogin() {

  const navigate = useNavigate();

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();

  function viewPassword() {
    var x = document.getElementById("password");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

  function logar(evento) {

    evento.preventDefault();

    apiUser
      .post(`/login/${email}/${password}`, {})
      .then((resp) => {
        if (resp.data.status == "ativo") {
          console.log(resp.data);
          sessionStorage.user_email = resp.data.email;
          sessionStorage.user_nome = resp.data.name;
          sessionStorage.user_id = resp.data.id;
          if (resp.data.colorMenu == "default") {
            sessionStorage.user_colorMenu = "#7D63A9";
          } else {
            sessionStorage.user_colorMenu = resp.data.colorMenu;
          }
          if (resp.data["colorProfile"] == "default") {
            sessionStorage.user_colorProfile = "#7D63A9";
          } else {
            sessionStorage.user_colorProfile = resp.data["colorProfile"];
          }
          navigate("/home");
          window.location.href = "../aplicacao/index.html";
        } else {
          document.getElementById("login_error").style.display = "block";
        }
      })
      .catch((error) => {
        console.error(error);
        document.getElementById("login_error").style.display = "block";
      });
  }

  return (
    <>
      <section className="place section" id="place">
        <div className="about__container container grid">
          <div className="about__img contact__img">
            <img className="img-contact" src={ImageContact} alt="" />
          </div>

          <div className="about__data">
            <h2 className="section__title about__title">Faça Login</h2>
            <p className="about__description">
              Acesse a nossa plataforma e tenha acesso a denuncias e noticias
              sobre aplicativos de transporte urbano.
            </p>
            <form onSubmit={logar}>
              <div className="inputs__form">
                <label htmlFor="Email">Email</label> <br />
                <input type="email" id="email" placeholder="Insira seu email"
                    onInput={(e) => setEmail(e.target.value)}
                />
              </div>
              <div className="inputs__form">
                <label htmlFor="Assunto">Senha</label> <br />
                <input
                  type="password"
                  name=""
                  id="password"
                  placeholder="Insira sua senha"
                  onInput={(e) => setPassword(e.target.value)}
                />
                <img
                  className="icon__pass"
                  src={ImageEye}
                  onClick={() => viewPassword()}
                  alt=""
                />
              </div>
              <span
                className="link__pass"
                id="login_error"
                style={{ display: 'none', color: 'red' }}
              >
                Email e/ou senha incorretos
              </span>
              <button
                className="button__log button btn-ctt"
                type="submit"
              >
                <a className="link__btn__log">Entrar</a>
              </button>
            </form>
          </div>
        </div>
      </section>
    </>
  );
}
export default FormLogin;
