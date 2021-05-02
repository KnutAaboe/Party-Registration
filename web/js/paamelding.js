let navn = document.getElementById("fornavn");
let en = document.getElementById("etternavn");
let mobil = document.getElementById("mobil");
let passord = document.getElementById("passord");
let passord2 = document.getElementById("passordRepetert");
let kjonn = document.getElementsByName("kjonn");
let sub = document.getElementById("sub");
let url = new URL(window.location.href);
let err = url.searchParams.get("err");

if(err==='err'){
document.getElementById('err').textContent = "Feil ved oppretting av bruker."
}
navn.addEventListener("keyup", () => {
  if (navn.value.length > 20 || navn.value.length < 2) {
    navn.style.backgroundColor = "lightcoral";
    document.getElementById("fornavnErr").innerHTML = "Ugyldig fornavn";
  } else {
    navn.style.backgroundColor = "lightcyan";
    document.getElementById("fornavnErr").innerHTML = "";
  }
});

en.addEventListener("keyup", () => {
  if (en.value.length > 20 || en.value.length < 2) {
    en.style.backgroundColor = "lightcoral";
    document.getElementById("etternavnErr").innerHTML = "Ugyldig etternavn";
  } else {
    en.style.backgroundColor = "lightcyan";
    document.getElementById("etternavnErr").innerHTML = "";
  }
});

mobil.addEventListener("keyup", () => {
  if (mobil.value.length != 8 || isNaN(mobil.value)) {
    mobil.style.backgroundColor = "lightcoral";
    document.getElementById("mobilErr").innerHTML =
      "Mobilnummer kan kun ha 8 siffer og kan bare inneholde tall";
  } else {
    mobil.style.backgroundColor = "lightcyan";
    document.getElementById("mobilErr").innerHTML = "";
  }
});

passord.addEventListener("keyup", () => {
    passord.style.backgroundColor = "lightcoral";
  if (passord.value.length < 6) {
    document.getElementById("passordErr").innerHTML =
      "Passord skal ha minst 6 tegn";
  } else if(passord.value.length < 8){
    passord.style.backgroundColor = "yellow";
    document.getElementById("passordErr").innerHTML =
        "svakt passord";
  }else {
    passord.style.backgroundColor = "lightcyan";
    document.getElementById("passordErr").innerHTML = "";
  }
});

passord2.addEventListener("keyup", () => {
  if (passord2.value !== passord.value) {
    passord2.style.backgroundColor = "lightcoral";
    document.getElementById("passordRepetertErr").innerHTML =
      "Passordene er ikke like";
  } else {
    passord2.style.backgroundColor = "lightcyan";
    document.getElementById("passordRepetertErr").innerHTML = "";
  }
});

kjonn[0].addEventListener("click", () => {
  document.getElementById("kjonnErr").innerHTML = "";
});
kjonn[1].addEventListener("click", () => {
  document.getElementById("kjonnErr").innerHTML = "";
});

sub.addEventListener("click", () => {
  let redir = true;
  if (navn.value.length < 1) {
    navn.style.backgroundColor = "lightcoral";
    document.getElementById("fornavnErr").innerHTML = "Ugyldig fornavn";
    redir = false;
  }
  if (en.value.length > 15 || en.value.length < 1) {
    en.style.backgroundColor = "lightcoral";
    document.getElementById("etternavnErr").innerHTML = "Ugyldig etternavn";
    redir = false;
  }
  if (mobil.value.length !== 8) {
    mobil.style.backgroundColor = "lightcoral";
    document.getElementById("mobilErr").innerHTML =
      "Mobilnummer kan kun ha 8 siffer kan bare inneholde tall";
    redir = false;
  }
  if (passord.value.length < 6) {
    passord.style.backgroundColor = "lightcoral";
    document.getElementById("passordErr").innerHTML =
      "Passord skal ha minst 6 tegn";
    redir = false;
  }
  if (passord2.value !== passord.value) {
    passord2.style.backgroundColor = "lightcoral";
    document.getElementById("passordRepetertErr").innerHTML =
      "Passordene er ikke like";
    redir = false;
  }
  if (!kjonn[0].checked && !kjonn[1].checked) {
    document.getElementById("kjonnErr").innerHTML = "Velg et kjonn";
    redir = false;
    console.log("VELG KJØNN");
  }

  if (redir) {
    document.getElementById("paameldingForm").submit();
  }
});
