$(document).ready(function () {
  listarCategorias();

  // Puedes agregar aquí la lógica para manejar el clic en las pestañas
  // Por ejemplo, para cambiar la clase 'active' y filtrar productos
  $(document).on('click', '.hm-tab-link', function () {
    $('.hm-tab-link').removeClass('active');
    $(this).addClass('active');
    var tipoCategoria = $(this).data('tipo');
    var idCategoria = $(this).data('id'); // Obtener el ID de la categoría
    console.log("Categoría seleccionada:", tipoCategoria, "ID:", idCategoria);
    console.log("Categoría seleccionada:", tipoCategoria);
    // Aquí llamarías a una función para filtrar tus productos
    // cargarProductosPorCategoria(tipoCategoria);
  });
});

function listarCategorias() {
  $.ajax({
    url: "srvCategoria?accion=listCategory",
    type: 'GET',
    dataType: 'JSON',
    success: function (data) {
      var tpl = "";
      for (var i = 0; i < data.length; i++) {
        tpl += "<li class=\"hm-tab-link\" data-tipo=\"" + data[i].nombre + "\" data-id=\"" + data[i].idCategoria + "\">" + data[i].nombre + "</li>";
      }
      // Insertamos los <li> generados dentro del <ul> con id="categoryTabs"
      $("#categoryTabs").append(tpl); // Usamos append para añadir después del "Todas"
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.error("Error al cargar categorías: " + textStatus, errorThrown);
      // Si tu servlet devuelve un JSON de error con "msj", puedes mostrarlo:
      try {
        var errorResponse = JSON.parse(jqXHR.responseText);
        console.error("Mensaje de error del servidor: " + errorResponse.msj);
      } catch (e) {
        console.error("No se pudo parsear el error del servidor.");
      }
    }
  });
}
;

//let productosGlobal = [];
//
//function cargarProductos() {
//  fetch('http://localhost:3000/api/productos')
//          .then(response => response.json())
//          .then(data => {
//            productosGlobal = data;
//
//            // Mostrar el primer tipo (dinámico)
//            const primerTipo = document.querySelector('.hm-tab-link')?.dataset.tipo || 'Cortadoras';
//            mostrarProductosFiltrados(primerTipo);
//          });
//}


//function mostrarProductosFiltrados(tipo) {
//  // Buscamos la pestaña activa (la que tiene tab-active)
//  const tabsContentActiva = document.querySelector('.tabs-content.tab-active');
//
//  // Ahora dentro de esa pestaña, buscamos su grid-product
//  const grid = tabsContentActiva?.querySelector('.grid-product');
//
//  if (!grid) {
//    console.error('No se encontró grid-product en la pestaña activa');
//    return;
//  }
//
//  grid.innerHTML = '';
//
//  const tipoNormalizado = tipo.trim().toLowerCase();
//
//  const filtrados = productosGlobal.filter(p =>
//    p.TIPO && p.TIPO.trim().toLowerCase() === tipoNormalizado
//  );
//
//  if (filtrados.length === 0) {
//    grid.innerHTML = `<p>No hay productos en esta categoría.</p>`;
//    return;
//  }
//
//  filtrados.forEach(p => {
//    grid.innerHTML += `
//        <div data-id="${p.ID}" class="product-item">
//          <div class="p-portada">
//            <img src="${p.IMG}" alt="">
//          </div>
//          <div class="p-info">
//            <h3>${p.NOMBRE}</h3>
//            <div class="precio">
//              <span>S/ ${p.PRECIO}</span>
//            </div>
//            <a href="#" class="hm-btn btn-primary uppercase add-to-cart"
//               data-id="${p.ID}"
//               data-name="${p.NOMBRE}"
//               data-price="${p.PRECIO}"
//               data-img="${p.IMG}">AGREGAR AL CARRITO</a>
//          </div>
//        </div>
//      `;
//  });
//}




//const headerMenu = document.querySelector('.hm-header');
//
//console.log(headerMenu.offsetTop);
//
//window.addEventListener('scroll', () => {
//  if (window.pageYOffset > 80) {
//    headerMenu.classList.add('header-fixed');
//  } else {
//    headerMenu.classList.remove('header-fixed');
//  }
//})
//
///*=========================================
// Tabs
// ==========================================*/
//document.addEventListener('DOMContentLoaded', () => {
//  cargarProductos();
//
//  // Agregar click a cada tab para filtrar
//  const tabLinks = document.querySelectorAll('.hm-tab-link');
//  const tabsContent = document.querySelectorAll('.tabs-content');
//
//  tabLinks.forEach((tab, i) => {
//    tab.addEventListener('click', () => {
//      // Activar visual del tab
//      tabLinks.forEach(t => t.classList.remove('active'));
//      tab.classList.add('active');
//
//      // Activar contenido del tab (mostrar el grid correcto)
//      tabsContent.forEach(tc => tc.classList.remove('tab-active'));
//      if (tabsContent[i])
//        tabsContent[i].classList.add('tab-active');
//
//      // Filtrar productos
//      const tipo = tab.dataset.tipo;
//      mostrarProductosFiltrados(tipo);
//    });
//  });
//
//  // Activar primero por defecto
//  if (tabLinks[0])
//    tabLinks[0].classList.add('active');
//  if (tabsContent[0])
//    tabsContent[0].classList.add('tab-active');
//});
//
//
//
//
///*=========================================
// MENU
// ==========================================*/
//
//const menu = document.querySelector('.icon-menu');
//const menuClose = document.querySelector('.cerrar-menu');
//
//menu.addEventListener('click', () => {
//  document.querySelector('.header-menu-movil').classList.add('active');
//})
//
//menuClose.addEventListener('click', () => {
//  document.querySelector('.header-menu-movil').classList.remove('active');
//})
//
//// productos despliegue
//
//const dropdown = document.getElementById('dropdown-productos');
//const toggle = dropdown.querySelector('.dropdown-toggle');
//
//// Abrir/cerrar con click
//toggle.addEventListener('click', function (e) {
//  e.stopPropagation(); // No cierra de inmediato
//  dropdown.classList.toggle('show');
//});
//
//// Cerrar al hacer clic fuera del menú
//document.addEventListener('click', function (e) {
//  if (!dropdown.contains(e.target)) {
//    dropdown.classList.remove('show');
//  }
//});
//
//// Mantener abierto mientras se pasa el mouse (para PC)
//dropdown.addEventListener('mouseenter', () => dropdown.classList.add('show'));
//dropdown.addEventListener('mouseleave', () => dropdown.classList.remove('show'));


