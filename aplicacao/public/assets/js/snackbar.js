function snackbarFunction() {
    var x = document.getElementById("snackbar")

    x.className = "show";

    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
  
}

function snackbarFunctionError() {
    var y = document.getElementById("snackbarError")

    y.className = "showError";
    setTimeout(function(){ y.className = y.className.replace("showError", ""); }, 3000);
}