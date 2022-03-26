
import '../css/style.css';
import logo from '../img/LogoGO.svg';
import homeImage from '../img/home.svg';
import userImage from '../img/user.svg';
import newsImage from '../img/news.svg';
import notificationImage from '../img/notification.svg';
function SearchBar(){
    return(
        <input type="text"></input>
    );
}

function Menu(){
    return(
        <div class="class-menu">
            <img src={logo}></img>
            <SearchBar />
            <img src={homeImage}></img>
            <img src={userImage}></img>
            <img src={newsImage}></img>
            <img src={notificationImage}></img>
        </div>
    );
}

export default Menu;