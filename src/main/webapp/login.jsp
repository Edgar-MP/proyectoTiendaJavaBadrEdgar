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
        <a href="index.jsp" id="branding">
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
    
    <form action="ServletLogin" method="post" class="contacto">
    	<input type="hidden" id="todoOk" name="todoOk" value="todoOk">
        
        	<div class="form-input">
                <label for="usuario">Nombre de usuario:</label>
                <input type="text" name="usuario" id="usuario" placeholder="Nombre de usuario" aria-labelledby="nombre de usuario">
            </div>
            <div class="form-input">
                <label for="password">Contraseña:</label>
                <input type="password" name="password" id="contraseña" placeholder="Contraseña" aria-labelledby="Contraseña">
            </div>
        	<div class="form-input enviar">
                <button type="submit">
                    Enviar! <i class="fa-solid fa-paper-plane"></i>
                </button>
            	<label><a href="registro.jsp">Registrarse</a></label>
            </div>
            <!-- <td colspan="2"><a href="registro.jsp">Registrarse</a></td> -->
    </form>
    <c:if test="${param.codError != null}">
    	<c:choose>
    		<c:when test="${param.codError == 1}">
    			<script>
    				alert("Debes introducir el nombre de Usuario");
			  	</script>
    			<p class="error">Debes introducir el nombre de Usuario</p>
    		</c:when>
    		<c:when test="${param.codError == 2}">
    			<script>
    				alert("Debes introducir la contraseña");
    			</script>
    			<p class="error">Debes introducir la contraseña</p>
    		</c:when>
    		<c:when test="${param.codError == 3}">
    			<script>
    				alert("El usuario o la contraseña no son validas");
    			</script>
    			<p class="error">El usuario o la contraseña no son validas</p>
    		</c:when>
    		<c:when test="${param.codError == 12}">
    			<script>
    				alert("Debes introducir el usuario y la contraseña");
    			</script>
    			<p class="error">Debes introducir el usuario y la contraseña</p>
    		</c:when>
    	</c:choose>
    </c:if>
    
    </div>
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