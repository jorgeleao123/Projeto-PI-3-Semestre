import '../css/user-data.css';

function UserData(){
    return (
        <div class="user-data-card">
            <div class="user-information">
                <div class="user-image"></div>
                <div class="user-name">
                    <h3>Rafaela Kimberlly</h3>
                    <h6>São Paulo</h6>
                </div>
            </div>
            <hr />
            <div class="user-data">
                <div class="publication">
                    <span>Publicações</span>
                    <span>2</span>
                </div>
                <div class="search">
                    <span>Buscas</span>
                    <span>14</span>
                </div>
            </div>
        </div>
    );
}

export default UserData;