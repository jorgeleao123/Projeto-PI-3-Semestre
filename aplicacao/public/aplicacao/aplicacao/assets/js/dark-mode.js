const html = document.querySelector("html")
const checkbox = document.querySelector("input[name=theme]")

const getStyle = (element, style) => 
    window
        .getComputedStyle(element)
        .getPropertyValue(style)


const initialColors = {
    backgroundCard: getStyle(html, "--background-card"),
    bodyColor: getStyle(html, "--body-color"),
    menuColor: getStyle(html, "--menu-color"),
    textColor: getStyle(html, " --text-color"),
    titleColor: getStyle(html, "--title-color"),
    firstColor: getStyle(html, "--first-color"),
    inputColor: getStyle(html, "--input-color"),
    modalColor: getStyle(html, "--modal-color"),
    inputsColor: getStyle(html,"--inputs-color"),
    backgroundLit: getStyle(html, "--background-lit")
}

const darkMode = {
    bodyColor: "#1C2128",
    menuColor: "#1C2128",
    textColor: "#FFFFFF",
    titleColor: "#FFFFFF",
    firstColor: "#6EB7ED",
    backgroundCard: "#2D333B",
    inputColor: "#1C2128",
    modalColor: "#2D333B",
    inputsColor: "#2E3135",
    backgroundLit: "#FEFFB9"
}

const transformKey = key => 
    "--" + key.replace(/([A-Z])/g, "-$1").toLowerCase()


const changeColors = (colors) => {
    Object.keys(colors).map(key => 
        html.style.setProperty(transformKey(key), colors[key]) 
    )
}


checkbox.addEventListener("change", ({target}) => {
    target.checked ? changeColors(darkMode) : changeColors(initialColors)
    
})

const isExistLocalStorage = (key) => 
  localStorage.getItem(key) != null

const createOrEditLocalStorage = (key, value) => 
  localStorage.setItem(key, JSON.stringify(value))

const getValeuLocalStorage = (key) =>
  JSON.parse(localStorage.getItem(key))

checkbox.addEventListener("change", ({target}) => {
  if (target.checked) {
    changeColors(darkMode) 
    createOrEditLocalStorage('modo','darkMode')
    logo.innerHTML = '<img src=".//assets/img/logo-go-white.svg">';
    logoMobile.innerHTML = '<img src=".//assets/img/logo-go-white.svg">';
  } else {
    changeColors(initialColors)
    createOrEditLocalStorage('modo','initialColors')
    logo.innerHTML = '<img src=".//assets/img/logo-go-carbon.svg">';
    logoMobile.innerHTML = '<img src=".//assets/img/logo-go-carbon.svg">';
  }
})

if(!isExistLocalStorage('modo'))
  createOrEditLocalStorage('modo', 'initialColors')


if (getValeuLocalStorage('modo') === "initialColors") {
  checkbox.removeAttribute('checked')
  changeColors(initialColors);
  logo.innerHTML = '<a href="./index.html"><img src=".//assets/img/logo-go-carbon.svg"></a>';
  logoMobile.innerHTML = '<a href="./index.html"><img src=".//assets/img/logo-go-carbon.svg"></a>';
} else {
  checkbox.setAttribute('checked', "")
  changeColors(darkMode);
  logo.innerHTML = '<a href="./index.html"><img src=".//assets/img/logo-go-white.svg"></a>';
  logoMobile.innerHTML = '<a href="./index.html"><img src=".//assets/img/logo-go-white.svg"></a>';
}