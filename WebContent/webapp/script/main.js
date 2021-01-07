
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


let urlHash = window.location.hash.split("#")[1];
// console.log('ir: '+ urlHash);
if( urlHash != null){
	let nav3 = document.getElementById(urlHash);
	// for (var index = 0; index < nav2.length; index++) {
 //    	console.log(nav2[index]);
	// }
	let activ = document.querySelectorAll(".active")
    activ.forEach(i => i.classList.remove("active"));
    nav3.className += 'active';

}