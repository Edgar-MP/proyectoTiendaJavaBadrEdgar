<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Idioma -->
<html lang="es" data-uw-w-loader="">

<head>
    <!-- Conjunto de caracteres -->
    <meta charset="UTF-8">
    <!-- Viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Autor -->
    <meta name="author" content="Edgar Martínez Palmero" />
    <!-- Descripción -->
    <meta name="description"
        content="Gamers for Gamers es una web en la que podras encontrar toda la información necesaria sobre tus videouegos favoritos" />
    <!-- favicon -->
    <link rel="shortcut icon" sizes="any" href="../assets/img/favicon/favicon.ico">
    <!-- Titulo -->
    <title>Inicio | Gaming for Gamers</title>
    <!-- CSS -->
    <link rel="stylesheet" href="../assets/css/style.css" media="screen">
</head>
<body>
<header>
        <a class="skip-link" href="#maincontent">Ir al contenido principal</a>
        <a href="../index.jsp" id="branding">
            <h1>Gaming4Gamers</h1>
            <img src="../assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
        </a>
        <div id="navigation">
            <div id="btnMenu">
                <img src="../assets/img/icons/menu.svg" alt="Abrir menú de navegación">
            </div>
        </div>
        <div id='menu'>
            <div class="logo">
                <c:if test="${usuario.img != null}">
		            <img src="../${usuario.img.ruta }" class="imgUser" alt="${usuario.img }" width="100">
		            <p>${usuario.nombre.toUpperCase() }</p>
	            </c:if>
	            <c:if test="${usuario.img == null}">
	                <img src="../assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
	            </c:if>
            </div>
            <nav>
                <ul>
                    <li>
                        <a id="pc" href="../index.jsp">Inicio</a>
                    </li>
                    <c:if test="${usuario == null}">
                    <li>
                       	<a id="play" href="login.jsp">Login</a>
                    </li>
                    <li>
                        <a id="xbox" href="registro.jsp">Registro</a>
                    </li>
                    </c:if>
					<c:if test="${usuario != null}">
	                    <li>
	                       	<a id="play" href="../ServletLogin?cerrarSesion=html/login.jsp">Cerrar Sesión</a>
	                    </li>
	                    <li>
	                    	<a id="xbox" href="perfilUsuario.jsp">Perfil de usuario</a>
	                    </li>
                    </c:if>
                </ul>
            </nav>

            <div id="background-images">
                <div class="background-image" style='background-image: url(../assets/img/menu/pc.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/play.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/xbox.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/nintendo.jpg)'></div>
            </div>

            <div id="close">
                <img src="../assets/img/icons/close.svg" alt="Cerrar menú de navegación">
            </div>
        </div>
    </header>
    <c:if test="${param.idJuego != null}">
	    <div class="bannerJuego">
	        <div class="imgBannerJuego" id="tlou"></div>
	        <!-- <img src="../../img/videojuegos/banners/TLoU1.webp" alt=""> -->
	    </div>
	    <div class="juego" id="maincontent">
	        <div class="gridJuego">
	            <div class="coverJuego">
	                <img src="../../img/videojuegos/covers/TLoU1.webp" alt="Portada The Last of Us: Parte 1" width="250">
	            </div>
	            <div class="infoJuego">
	                <h2>The Last of Us</h2>
	                <h3>1 de Septiembre, 2022</h3>
	                <a href="https://www.naughtydog.com/" target="_blank">Naughty Dog</a>
	            </div>
	            <div class="resumen">
	                <p>La historia de <b>'The Last of Us'</b> tiene lugar veinte años después de que la civilización moderna
	                    haya sido destruida. <b>Joel</b>, un superviviente de carácter recio, es contratado para sacar de
	                    contrabando a <b>Ellie</b>, una niña de 14 años, fuera de una opresiva zona de cuarentena. Lo que
	                    comienza como un pequeño trabajo pronto se convierte en un viaje brutal y desgarrador, ya que ambos
	                    deben atravesar los EE. UU. y depender el uno del otro para sobrevivir.</p>
	                <div class="caracteristicasMobile">
	                    <ul>
	                        <li>Plataformas: <span><i class="fa-brands fa-playstation fa-lg"></i></span></li>
	                        <li>Genero: <span>Accion, Aventura</span></li>
	                    </ul>
	                </div>
	            </div>
	            <div class="caracteristicas">
	                <ul>
	                    <li>Plataformas: <span><i class="fa-brands fa-playstation fa-lg"></i></span></li>
	                    <li>Genero: <span>Accion, Aventura</span></li>
	                </ul>
	            </div>
	        </div>
	    </div>
	    <div class="trailerJuego">
	        <h2>Trailer</h2>
	        <iframe src="https://www.youtube.com/embed/v/Mel8DZBEJTo?controls=1&allowfullscreen=1&playlist=Mel8DZBEJTo"
	            title="Trailer The Last of Us: Parte 1 PS5" allowfullscreen></iframe>
	    </div>
	    <div class="containerProtagonistas">
	        <h2>Protagonistas</h2>
	        <div class="protas">
	            <div class="prota">
	                <img src="../../img/videojuegos/tlou/ellie.webp" alt="Ellie Williams" width="300" height="224">
	                <p>Ellie Williams</p>
	            </div>
	            <div class="prota">
	                <img src="../../img/videojuegos/tlou/joel.webp" alt="Joel Miller" width="300" height="224">
	                <p>Joel Miller</p>
	            </div>
	            <div class="prota">
	                <img src="../../img/videojuegos/tlou/marlene.webp" alt="Marlene" width="300" height="224">
	                <p>Marlene</p>
	            </div>
	        </div>
	    </div>
    </c:if>
    <c:if test="${param.idJuego == null}">
	    <div class="pageContainer" id="maincontent" style="width: 80vw; height: 60vh;margin-top: 2rem;">
	    	<h2>Creo que te has perdido</h2>
	    	<p><a href="../index.jsp">Volver a Inicio</a></p>
	    </div>
    </c:if>
  
    <footer>
        <img src="../assets/img/logo/logoBlancoLogitech.svg" alt="Logo de Gaming4Gamers" width="150">
        <div class="redes">
            <a class="twitter" href="https://twitter.com/illojuan" target="_blank"
                aria-label="Ir a la página de Twitter"><i class="fa-brands fa-twitter fa-2x"></i></a>
            <a class="youtube" href="https://www.youtube.com/@IlloJuan_" target="_blank"
                aria-label="Ir al canal de YouTube"><i class="fa-brands fa-youtube fa-2x"></i></a>
            <a class="instagram" href="https://www.instagram.com/illojuan/?hl=es" target="_blank"
                aria-label="Ir al perfil de instagram"><i class="fa-brands fa-instagram fa-2x"></i></a>
        </div>
        <div>
            Edgar y Badr | 2022
        </div>
    </footer>

    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
    <script src="../assets/js/script.min.js"></script>
    <script src="https://kit.fontawesome.com/a5ac13e346.js" crossorigin="anonymous"></script>
</body>
</html>