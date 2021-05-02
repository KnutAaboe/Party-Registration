let mobInput = document.getElementById('mob');
let passInput = document.getElementById('pass');
let url = new URL(window.location.href);
let err = url.searchParams.get("err");

if(err === 'err'){
    document.getElementById('error').textContent = 'Ugyldig brukernavn og/eller passord';
    mobInput.style.backgroundColor = "lightcoral";
    passInput.style.backgroundColor = "lightcoral";
}

mobInput.addEventListener("keyup", () => {
        mobInput.style.backgroundColor = "lightcyan";
        passInput.style.backgroundColor = "lightcyan";
    });
passInput.addEventListener("keyup", () => {
    mobInput.style.backgroundColor = "lightcyan";
    passInput.style.backgroundColor = "lightcyan";
});
