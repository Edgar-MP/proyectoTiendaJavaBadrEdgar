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
    <link rel="shortcut icon" sizes="any" href="assets/img/favicon/favicon.ico">
    <!-- Titulo -->
    <title>Inicio | Gaming for Gamers</title>
    <!-- CSS -->
    <link rel="stylesheet" href="assets/css/style.css" media="screen">
</head>

<body>
    <header>
        <a class="skip-link" href="#maincontent">Ir al contenido principal</a>
        <a href="#" id="branding">
            <h1>Gaming4Gamers</h1>
            <img src="assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
        </a>
        <div id="navigation">
            <div id="btnMenu">
                <img src="assets/img/icons/menu.svg" alt="Abrir menú de navegación">
            </div>
        </div>
        <div id='menu'>
            <div class="logo">
                <img src="assets/img/logo/logoBlancoLogitech.svg" alt="Logo de gaming4gamers" width="150">
            </div>
            <nav>
                <ul>
                    <li>
                        <a id="pc" href="./index.jsp">Inicio</a>
                    </li>
                    <li>
                        <a id="play" href="login.jsp">Login</a>
                    </li>
                    <li>
                        <a id="xbox" href="assets/html/consolas/xbox.html">Xbox</a>
                    </li>
                    <li>
                        <a id="nintendo" href="assets/html/contacto.html">Contacto</a>
                    </li>
                </ul>
            </nav>

            <div id="background-images">
                <div class="background-image" style='background-image: url(assets/img/menu/pc.jpg)'></div>
                <div class="background-image" style='background-image: url(assets/img/menu/play.jpg)'></div>
                <div class="background-image" style='background-image: url(assets/img/menu/xbox.jpg)'></div>
                <div class="background-image" style='background-image: url(assets/img/menu/nintendo.jpg)'></div>
            </div>

            <div id="close">
                <img src="assets/img/icons/close.svg" alt="Cerrar menú de navegación">
            </div>
        </div>
    </header>

    <div class="pageContainer" id="maincontent">
    <!--
        <div class="videoJuegosDestacados">
            
	        <div class="videoJuegoCarrusel carrusel1 active">
                <div class="sombra"></div>
                <div class="label">
                    <div class="icon">
                        <i class="fa-brands fa-playstation fa-lg play"></i>
                    </div>
                    <div class="info">
                        <div class="main">The Last of Us</div>
                        <div class="sub"><a href="https://www.youtube.com/watch?v=Mel8DZBEJTo" target="_blank"><i
                                    class="fa-solid fa-play trailer"></i> Ver Trailer</a></div>
                    </div>
                </div>
            </div>
        </div>
            -->
         <div class="videojuegos">
         	<!-- JUEGO -->
         	<div>
                <a href="assets/html/videojuegos/uncharted.html">
                    <picture>
                        <source media="(max-width: 424px)" srcset="assets/img/videojuegos/banners/uncharted1.webp">
                        <source media="(min-width: 600px)" srcset="assets/img/videojuegos/covers/uncharted1.webp">
                        <img src="assets/img/videojuegos/banners/uncharted1.webp"
                            alt="Cover Uncharted: El tesoro de Drake">
                    </picture>
                </a>
                <div class="plataformas">
                    <a href="https://www.playstation.com" target="_blank"
                        aria-label="Enlace a la página oficial de PlayStation"><i
                            class="fa-brands fa-playstation"></i></a>
                </div>
                <div class="detalles">
                    <a href="assets/html/videojuegos/uncharted.html">
                        <div class="titulo">Uncharted</div>
                    </a>
                    <a href="https://www.naughtydog.com/" target="_blank">
                        <div class="Company">Naughty Dog</div>
                    </a>
                </div>
            </div>
         </div>
    </div>
    
    <!-- Cookies -->
    <div id="cookiePopup">
        <strong>Legalidad y RGPD</strong>
        <p>Debes aceptar la <a href="#">Legalidad y RGPD</a></p>
        <button id="acceptCookie">Aceptar</button>
    </div>
    <!-- Footer -->
    <footer>
        <img src="assets/img/logo/logoBlancoLogitech.svg" alt="Logo de Gaming4Gamers" width="150">
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
    <script src="assets/js/script.min.js"></script>
    <script src="https://kit.fontawesome.com/a5ac13e346.js" crossorigin="anonymous"></script>
</body>

</html>
<!-- 
	“Si de alguna manera Dios me diera una segunda oportunidad... Lo haria todo de nuevo ”
				- Joel Miller
	https://www.youtube.com/watch?v=-zOjVJgIVHA 
-->