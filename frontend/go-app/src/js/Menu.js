import "../css/menu-style.css";
import logo from "../img/LogoGO.svg";

function SearchBar() {
  return (
    <div class="searchBar">
      <input type="text" id="input-menu" placeholder="Search"></input>
      <button class="button-input-menu">
        <i class="fa fa-search"></i>
      </button>
    </div>
  );
}

function Options() {
  return (
    <div class="icons">
      <a href="">
        <i class="fa fa-house" />
      </a>
      <hr />
      <a href="">
        <i class="fa fa-user" />
      </a>
      <hr />
      <a href="">
        <i class="fa fa-newspaper" />
      </a>
      <hr />
      <a href="">
        <i class="fa fa-bell" />
      </a>
    </div>
  );
}

function UserIcon() {
  return (
    <div class="user-icon">
      <i class="fa fa-circle-user fa-xl" />
      <i class="fa fa-angle-down" />
    </div>
  );
}

function Menu() {
  return (
    <nav class="menu">
      <img src={logo}></img>
      <SearchBar />
      <Options />
      <UserIcon />
    </nav>
  );
}

export default Menu;
