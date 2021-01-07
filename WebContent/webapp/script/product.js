let cantMaxProduct = 0;

function getProduct(url) {
	const div = document.querySelector("#mostrarProductos");
	let urlParametros = formatUrlGetProduct(lote, cantAMostrar);
	
	// request
	fetch(url + urlParametros).then(function(response) {
		if(response.ok) { // promesa
		  return response.json(); 
		}
		console.log("dio error");
		throw new Error(response.statusText);
	})
	.then((data) => {
		// Recorro la lista y muestro en la pantalla.
		data.forEach((producto) => {
	        div.innerHTML +=
				`<div class="element-product col-3">
					<h2>${producto.nombre}</h2>
					<p>${producto.descripcion}</p>
					<h3>$ ${producto.precio}</h3>
				</div>
				`;
				// Si el codigo se pone en java, anteponer \${}
		})
		// Modifico la url del navegador, para que si el usuario quiere volver
		// a buscar la misma busqueda, pueda pasarle los parametros al servlet.
        history.pushState(null, "", "productosJson.jsp" + urlParametros);					
	})
	.catch(function(error) { // en caso de q no sea existosa pasa al catch
		console.log("error en catch");
		console.log(error.message);
	});
		
}

function getMaxProduct(url) {
	urlFormat = formatUrlGetLot(url);
		// request
	fetch(urlFormat).then(function(response) {
		console.log(response);
		if(response.ok) { // promesa
			return response.json(); 
		}
		//console.log("dio error");
		throw new Error(response.statusText);
	})
	.then((data) => {
		cantMaxProduct = data.cantidadProductos;
		console.log("La cantidad es: " + cantMaxProduct);
		
	})
	.catch(function(error) { // en caso de q no sea existosa pasa al catch
		console.log("error en catch");
		console.log(error.message);
	});
}

function formatUrlGetProduct( lote, cantMostrar = 9) { 
	return "?lote=" + lote + "&cantMostrar=" + cantMostrar ;
}
  
function formatUrlGetLot(urlBase) { 
	return urlBase + "?cantidadProductos=1";
}

const body = document.querySelector("body");
body.addEventListener("load", getProduct('../ListaProductos'));