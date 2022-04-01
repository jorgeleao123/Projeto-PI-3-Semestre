function limparFormulario(endereco) {
    document.getElementById('endereco').value = '';
    document.getElementById('bairro').value = '';
    document.getElementById('cidade').value = '';
    document.getElementById('estado').value = '';
}


function preencherFormulario(endereco) {
    document.getElementById('endereco').value = endereco.logradouro;
    document.getElementById('bairro').value = endereco.bairro;
    document.getElementById('cidade').value = endereco.localidade;
    document.getElementById('estado').value = endereco.uf;
}


function eNumero(numero) {
    return /^[0-9]+$/.test(numero);
} 

function cepValido (cep) {
    return cep.length == 8 && eNumero(cep); 
}

const pesquisarCep = async() => {
    limparFormulario();
    
    const cep = document.getElementById('cep').value.replace("-","");
    const url = `https://viacep.com.br/ws/${cep}/json/`;
    if (cepValido(cep)){
        const dados = await fetch(url);
        const endereco = await dados.json();
        if (endereco.hasOwnProperty('erro')){
            document.getElementById('endereco').value = 'CEP não encontrado!';
        }else {
            preencherFormulario(endereco);
        }
    }else{
        document.getElementById('endereco').value = 'CEP incorreto!';
    }
     
}

document.getElementById('cep')
        .addEventListener('focusout',pesquisarCep);
  function cadastrar() {
    const data = {
      nomeUsuario: document.getElementById('nome').value,
      loginUsuario: document.getElementById('login').value,
      senhaUsuario: document.getElementById('senha').value,
      sexoUsuario: document.getElementById('sexo').value,
      emailUsuario: document.getElementById('email').value,
      endereco: {
        cep: document.getElementById('cep').value.replace("-",""),
        estado: document.getElementById('estado').value,
        cidade: document.getElementById('cidade').value,
        bairro: document.getElementById('bairro').value
      }
    };

    fetch('http://localhost:8080/usuarios2', {
      method: 'POST', // or 'PUT'
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
      .then(data => {
        console.log('Success:', data);
        alert("Usuario cadastrado com sucesso")
      })
      .catch((error) => {
        alert("Erro ao realizar login")
        console.error('Error:', error);
      });

  }