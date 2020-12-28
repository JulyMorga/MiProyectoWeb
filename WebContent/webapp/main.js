
let nav = document.querySelectorAll('a[href^="#"]');
nav.forEach(i => i.addEventListener("click", cambiarPagina));
$('.navbar-collapse a').click(function(){
    $(".navbar-collapse").collapse('hide');
});
function cambiarPagina(evento) {
    evento.preventDefault()
    let to = evento.target.hash
    let activ = document.querySelectorAll(".active")
    activ.forEach(i => i.classList.remove("active"));
    document.querySelector(to).classList.add("active")
}