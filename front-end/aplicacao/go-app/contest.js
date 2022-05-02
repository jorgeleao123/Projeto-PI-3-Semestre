
function registerContestation(url, body){
    let request = new XMLHttpRequest()
    request.open("POST",url,true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))

    request.onload = function(){
        console.log(this.responseText)
    }

    return request.responseText;
}

function contestation(){
    event.preventDefault()
    let userId = sessionStorage.userId;
    let complaintId = sessionStorage.complaintId;
    let url = `http://localhost:8080/contestations/${complaintId}/${userId}`
    let description = document.getElementById("description").value;
    let title = document.getElementById("title").value;
    let archive = document.getElementById("archive").value;

    body = {
        "description":description,
        "title":title,
        "archive": archive
    }


    registerContestation(url,body)
}