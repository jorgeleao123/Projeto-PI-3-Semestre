import '../css/style.css';
import Menu from "./Menu.js";
import UserData from './UserData';

function App() {
  return (
    <div className="App">
      <Menu />
      <hr />
      <div class="content">
        <UserData />
      </div>
    </div>
  );
}

export default App;
