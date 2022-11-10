const nombre1 = document.getElementById("inputNombre")
const password = document.getElementById("inputpassword")

function ingresar() {

      fetch('http://localhost:8080/usuario/login', {
            method: 'POST',
            headers: {
                  'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                  username: nombre1.value,
                  password: password.value,
                  
            }),
      })
            .then(response => response.json())
            .then(data => {
                  console.log('Success:', data);
                  location.href = "./menuPokemon.html";
            })
            .catch((error) => {
                  console.error('Error:', error);
            });
}