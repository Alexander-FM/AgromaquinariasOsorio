<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Distribuidora Osorio Agromaquinas</title>

    <!-- FUENTE GOOGLE FONTS : Poppins -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700;800&display=swap" rel="stylesheet">

    <!-- ICONS: Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

    <!-- ICONS: Line Awesome -->
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">

    <!-- Animaciones AOS -->
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css">


    <!-- Mis Estilos -->
    <link rel="stylesheet" href="css/estilos_index.css">
    <link rel="stylesheet" href="css/iniciocss.css">

  </head>
  <body>

    <div class="hm-wrapper">

      <!-- =================================
         HEADER MENU
      ================================== -->
      <div class="hm-header">

        <div class="container">
          <div class="header-menu">

            <div class="hm-logo">
              <a href="#">
                <img src="img/logo-sinfondo.png" style="width: 125px; height: auto;">
              </a>
            </div>

            <nav class="hm-menu">
              <ul>
                <li class="dropdown" id="dropdown-productos">
                  <span class="dropdown-toggle">Productos</span>
                  <div class="dropdown-content">
                    <a href="productos/cortadoras.html">Cortadoras</a>
                    <a href="productos/motosierras.html">Motosierras</a>
                    <a href="productos/atomizadores.html">Atomizadores</a>
                    <a href="productos/hidrolavadoras.html">Hidrolavadoras</a>
                    <a href="productos/accesorios.html">Accesorios</a>
                  </div>
                </li>
                <!-- <li><a href="login/login.html">Login</a></li>
                <li><a href="dashboard/dashboard.html">Dashboard</a></li> -->
              </ul>


              <div class="hm-icon-cart">
                <a href="#" id="open-cart">
                  <i class="las la-shopping-cart"></i>
                  <span id="cart-count">0</span>
                </a>
              </div>
              <div class="hm-icon-user">
                <a href="#" id="open-login">
                  <i class="las la-user"></i>
                  <span id="nombre-usuario" style="margin-left: 8px;">Iniciar Sesión</span>
                </a>
              </div>




              <div class="icon-menu">
                <button type="button"><i class="fas fa-bars"></i></button>
              </div>

            </nav>

          </div>
        </div>

      </div>

      <!-- =================================
         HEADER MENU Movil
      ================================== -->
      <div class="header-menu-movil">
        <button class="cerrar-menu"><i class="fas fa-times"></i></button>
        <ul>
          <li><a href="#">Productos</a></li>
          <li><a href="#">Campañas</a></li>
          <li><a href="#">Nosotros</a></li>
          <li><a href="#">Contacto</a></li>
        </ul>
      </div>



      <!-- =================================
         BANNER
      ================================== -->
      <div class="hm-banner">
        <div class="img-banner">
          <img src="img/logo-home-master-s-t-o-r-e-4.jpg" alt="">
        </div>
        <a href=""></a>
      </div>


      <!-- =================================
        HOME PRODUCTOS DESTACADOS
     ================================== -->
      <div id="productos" class="hm-page-block bg-fondo">

        <div class="container">

          <div class="header-title" data-aos="fade-up">
            <h1>Productos populares</h1>
          </div>

          <!-- TABS -->
          <ul class="hm-tabs" data-aos="fade-up" id="categoryTabs">
            <!-- Se cargará el contenido de las categorias mediante JavaScript -->
          </ul>

          <!-- CONTENIDO DE LOS TABS -->
          <!-- Cortadoras -->
          <div class="tabs-content tab-active" data-aos="fade-up">
            <div class="grid-product">
              <div data-id="1" class="product-item">
                <div class="p-portada">
                  <img src="img/cortadoras/cortadora02.png" alt=""/>
                </div>
                <div class="p-info">
                  <h3>Cortadora Lorenzo</h3>
                  <div class="precio">
                    <span>S/. 1200,30</span>
                  </div>
                  <a href="#" class="hm-btn btn-primary uppercase add-to-cart"
                     data-id="1"
                     data-name="Cortadora Lorenzo"
                     data-price="1200,30"
                     data-img="img/cortadoras/cortadora02.png">AGREGAR AL CARRITO</a>
                </div>
              </div>
              <div data-id="1" class="product-item">
                <div class="p-portada">
                  <img src="img/cortadoras/cortadora02.png" alt=""/>
                </div>
                <div class="p-info">
                  <h3>Cortadora Lorenzo</h3>
                  <div class="precio">
                    <span>S/. 1200,30</span>
                  </div>
                  <a href="#" class="hm-btn btn-primary uppercase add-to-cart"
                     data-id="1"
                     data-name="Cortadora Lorenzo"
                     data-price="1200,30"
                     data-img="img/cortadoras/cortadora02.png">AGREGAR AL CARRITO</a>
                </div>
              </div>
              <div data-id="1" class="product-item">
                <div class="p-portada">
                  <img src="img/cortadoras/cortadora02.png" alt=""/>
                </div>
                <div class="p-info">
                  <h3>Cortadora Lorenzo</h3>
                  <div class="precio">
                    <span>S/. 1200,30</span>
                  </div>
                  <a href="#" class="hm-btn btn-primary uppercase add-to-cart"
                     data-id="1"
                     data-name="Cortadora Lorenzo"
                     data-price="1200,30"
                     data-img="img/cortadoras/cortadora02.png">AGREGAR AL CARRITO</a>
                </div>
              </div>
                            <div data-id="1" class="product-item">
                <div class="p-portada">
                  <img src="img/cortadoras/cortadora02.png" alt=""/>
                </div>
                <div class="p-info">
                  <h3>Cortadora Lorenzo</h3>
                  <div class="precio">
                    <span>S/. 1200,30</span>
                  </div>
                  <a href="#" class="hm-btn btn-primary uppercase add-to-cart"
                     data-id="1"
                     data-name="Cortadora Lorenzo"
                     data-price="1200,30"
                     data-img="img/cortadoras/cortadora02.png">AGREGAR AL CARRITO</a>
                </div>
              </div>
                            <div data-id="1" class="product-item">
                <div class="p-portada">
                  <img src="img/cortadoras/cortadora02.png" alt=""/>
                </div>
                <div class="p-info">
                  <h3>Cortadora Lorenzo</h3>
                  <div class="precio">
                    <span>S/. 1200,30</span>
                  </div>
                  <a href="#" class="hm-btn btn-primary uppercase add-to-cart"
                     data-id="1"
                     data-name="Cortadora Lorenzo"
                     data-price="1200,30"
                     data-img="img/cortadoras/cortadora02.png">AGREGAR AL CARRITO</a>
                </div>
              </div>
            </div>
          </div>

          <!-- Motosierras -->
          <div class="tabs-content" data-aos="fade-up">

            <div class="grid-product">

            </div>

          </div>

          <!-- Atomizadores -->
          <div class="tabs-content" data-aos="fade-up">

            <div class="grid-product">

            </div>

          </div>

          <!-- Hidrolavadora -->
          <div class="tabs-content" data-aos="fade-up">

            <div class="grid-product">


            </div>

          </div>

          <!-- Carrito Slide -->
          <div id="cart-slide" class="cart-slide">
            <div class="cart-header">
              <h4>🛒 Tu Carrito</h4>
              <button onclick="closeCart()" class="close-cart">✕</button>
            </div>

            <div class="cart-items" id="cart-items">
              <!-- Productos se agregarán aquí dinámicamente -->
            </div>

            <!-- NUEVO: Total + Botones -->
            <div class="cart-footer">
              <div class="cart-total">
                <strong>Total a pagar:</strong> S/ <span id="cart-total">0.00</span>
              </div>
              <div class="cart-actions" style="margin-top: 10px;">
                <a href="cart.html" class="hm-btn btn-primary uppercase" style="width: 100%; display: inline-block; text-align: center;">Comprar Ahora</a>
              </div>

            </div>
          </div>
        </div>
      </div>




      <!-- =================================
        FOOTER
     ================================== -->
      <footer>

        <div class="container">

          <div class="foo-row">

            <div class="foo-col">
              <ul>
              </ul>
            </div>

          </div>

        </div>

      </footer>

      <div class="foo-copy">
        <div class="container">
          <p>Distribuidora Osorio Agromaquinas 2025 © Todos los derechos reservados</p>
        </div>
      </div>
    </div>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <!-- Ajax -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <!-- Animaciones : AOS-->
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <!-- Mi Script -->
    <script src="js/inicio.js" type="text/javascript">></script>
    <script src="js/script_index.js" type="text/javascript">></script>
    <script>

      AOS.init({
        duration: 1200
      });


    </script>
  </body>
</html>