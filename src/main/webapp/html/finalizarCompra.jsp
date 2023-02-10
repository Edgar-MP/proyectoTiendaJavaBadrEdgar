<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
      <title>Finalizar Compra | Gaming for Gamers</title>
      <!-- CSS -->
      <link rel="stylesheet" href="../assets/css/style.css" media="screen">
      <link rel="stylesheet" href="../assets/css/tarjeta.css" media="screen">
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
            <c:if test="${usuario != null}">
	            <div id="btnCarrito">
	            	<a href="carrito.jsp">
	            	<i class="fa-sharp fa-solid fa-cart-shopping fa-2xl"></i>
	            	</a>
	            </div>
            </c:if>
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
	                       	<a id="play" href="../ServletLogin?cerrarSesion=html/finalizarCompra.jsp">Cerrar Sesión</a>
	                    </li>
	                    <li>
	                    	<a id="xbox" href="perfilUsuario.jsp?idUsuario=${usuario.idUser}">Perfil de usuario</a>
	                    </li>
	                    <c:if test="${usuario.admin == true}">
		                    <li>
		                       	<a id="nintendo" href="listadoDeUsuarios.jsp">Listado de usuarios</a>
		                    </li>
		                    <li>
					        	<a id="pc" href="listadoDeCompanias.jsp">Listado de Compañías</a>
					        </li>
	                    </c:if>
                    </c:if>
                </ul>
            </nav>

            <div id="background-images">
                <div class="background-image" style='background-image: url(../assets/img/menu/pc.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/play.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/xbox.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/nintendo.jpg)'></div>
                <div class="background-image" style='background-image: url(../assets/img/menu/pc.jpg)'></div>
            </div>

            <div id="close">
                <img src="../assets/img/icons/close.svg" alt="Cerrar menú de navegación">
            </div>
        </div>
    </header>
      <div class="pageContainer" id="maincontent">
        <!--  <c:if test="${param.camposVacios != null}">
       <script>
		    alert("Campos vacios");
		</script>
    </c:if>-->
        <div class="wrapper" id="app">
          <div class="card-form">
            <div class="card-list">
              <div class="card-item" v-bind:class="{ '-active' : isCardFlipped }">
                <div class="card-item__side -front">
                  <div class="card-item__focus" v-bind:class="{'-active' : focusElementStyle }"
                    v-bind:style="focusElementStyle" ref="focusElement"></div>
                  <div class="card-item__cover">
                    <img
                      v-bind:src="'https://raw.githubusercontent.com/muhammederdem/credit-card-form/master/src/assets/images/' + currentCardBackground + '.jpeg'"
                      class="card-item__bg">
                  </div>

                  <div class="card-item__wrapper">
                    <div class="card-item__top">
                      <img
                        src="https://raw.githubusercontent.com/muhammederdem/credit-card-form/master/src/assets/images/chip.png"
                        class="card-item__chip">
                      <div class="card-item__type">
                        <transition name="slide-fade-up">
                          <img
                            v-bind:src="'https://raw.githubusercontent.com/muhammederdem/credit-card-form/master/src/assets/images/' + getCardType + '.png'"
                            v-if="getCardType" v-bind:key="getCardType" alt="" class="card-item__typeImg">
                        </transition>
                      </div>
                    </div>
                    <label for="cardNumber" class="card-item__number" ref="cardNumber">
                      <template v-if="getCardType === 'amex'">
                        <span v-for="(n, $index) in amexCardMask" :key="$index">
                          <transition name="slide-fade-up">
                            <div class="card-item__numberItem"
                              v-if="$index > 4 && $index < 14 && cardNumber.length > $index && n.trim() !== ''">*</div>
                            <div class="card-item__numberItem" :class="{ '-active' : n.trim() === '' }" :key="$index"
                              v-else-if="cardNumber.length > $index">
                              {{cardNumber[$index]}}
                            </div>
                            <div class="card-item__numberItem" :class="{ '-active' : n.trim() === '' }" v-else
                              :key="$index + 1">{{n}}</div>
                          </transition>
                        </span>
                      </template>

                      <template v-else>
                        <span v-for="(n, $index) in otherCardMask" :key="$index">
                          <transition name="slide-fade-up">
                            <div class="card-item__numberItem"
                              v-if="$index > 4 && $index < 15 && cardNumber.length > $index && n.trim() !== ''">*</div>
                            <div class="card-item__numberItem" :class="{ '-active' : n.trim() === '' }" :key="$index"
                              v-else-if="cardNumber.length > $index">
                              {{cardNumber[$index]}}
                            </div>
                            <div class="card-item__numberItem" :class="{ '-active' : n.trim() === '' }" v-else
                              :key="$index + 1">{{n}}</div>
                          </transition>
                        </span>
                      </template>
                    </label>
                    <div class="card-item__content">
                      <label for="cardName" class="card-item__info" ref="cardName">
                        <div class="card-item__holder">Titular</div>
                        <transition name="slide-fade-up">
                          <div class="card-item__name" v-if="cardName.length" key="1">
                            <transition-group name="slide-fade-right">
                              <span class="card-item__nameItem" v-for="(n, $index) in cardName.replace(/\s\s+/g, ' ')"
                                v-if="$index === $index" v-bind:key="$index + 1">{{n}}</span>
                            </transition-group>
                          </div>
                          <div class="card-item__name" v-else key="2">Nombre Completo</div>
                        </transition>
                      </label>
                      <div class="card-item__date" ref="cardDate">
                        <label for="cardMonth" class="card-item__dateTitle">Caducidad</label>
                        <label for="cardMonth" class="card-item__dateItem">
                          <transition name="slide-fade-up">
                            <span v-if="cardMonth" v-bind:key="cardMonth">{{cardMonth}}</span>
                            <span v-else key="2">MM</span>
                          </transition>
                        </label>
                        /
                        <label for="cardYear" class="card-item__dateItem">
                          <transition name="slide-fade-up">
                            <span v-if="cardYear" v-bind:key="cardYear">{{String(cardYear).slice(2,4)}}</span>
                            <span v-else key="2">YY</span>
                          </transition>
                        </label>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="card-item__side -back">
                  <div class="card-item__cover">
                    <img
                      v-bind:src="'https://raw.githubusercontent.com/muhammederdem/credit-card-form/master/src/assets/images/' + currentCardBackground + '.jpeg'"
                      class="card-item__bg">
                  </div>
                  <div class="card-item__band"></div>
                  <div class="card-item__cvv">
                    <div class="card-item__cvvTitle">CVV</div>
                    <div class="card-item__cvvBand">
                      <span v-for="(n, $index) in cardCvv" :key="$index">
                        *
                      </span>

                    </div>
                    <div class="card-item__type">
                      <img
                        v-bind:src="'https://raw.githubusercontent.com/muhammederdem/credit-card-form/master/src/assets/images/' + getCardType + '.png'"
                        v-if="getCardType" class="card-item__typeImg">
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="card-form__inner">
              <div class="card-input">
                <label for="cardNumber" class="card-input__label">Número de Tarjeta</label>
                <input type="text" id="cardNumber" name="cardNumber" class="card-input__input"
                  v-mask="generateCardNumberMask" v-model="cardNumber" v-on:focus="focusInput" v-on:blur="blurInput"
                  data-ref="cardNumber" autocomplete="off">
              </div>
              <div class="card-input">
                <label for="cardName" class="card-input__label">Titular</label>
                <input type="text" id="cardName" name="cardName" class="card-input__input" v-model="cardName"
                  v-on:focus="focusInput" v-on:blur="blurInput" data-ref="cardName" autocomplete="off">
              </div>
              <div class="card-form__row">
                <div class="card-form__col">
                  <div class="card-form__group">
                    <label for="cardMonth" class="card-input__label">Fecha de caducidad</label>
                    <select class="card-input__input -select" name="cardMonth" id="cardMonth" v-model="cardMonth"
                      v-on:focus="focusInput" v-on:blur="blurInput" data-ref="cardDate">
                      <option value="" disabled selected>Mes</option>
                      <option v-bind:value="n < 10 ? '0' + n : n" v-for="n in 12" v-bind:disabled="n < minCardMonth"
                        v-bind:key="n">
                        {{n < 10 ? '0' + n : n}} </option>
                    </select>
                    <select class="card-input__input -select" name="cardYear" id="cardYear" v-model="cardYear"
                      v-on:focus="focusInput" v-on:blur="blurInput" data-ref="cardDate">
                      <option value="" disabled selected>Año</option>
                      <option v-bind:value="$index + minCardYear" v-for="(n, $index) in 12" v-bind:key="n">
                        {{$index + minCardYear}}
                      </option>
                    </select>
                  </div>
                </div>
                <div class="card-form__col -cvv">
                  <div class="card-input">
                    <label for="cardCvv" class="card-input__label">CVV</label>
                    <input type="text" class="card-input__input" name="cardCvv" id="cardCvv" v-mask="'####'"
                      maxlength="4" v-model="cardCvv" v-on:focus="flipCard(true)" v-on:blur="flipCard(false)"
                      autocomplete="off">
                  </div>
                </div>
              </div>

              <div class="card-form__button">
                <c:if test="${param.total != null}">
                  <a href="../ServletFinalizarCompra?pagar=si&compraTotal=${param.total}">Pagar ${param.total} €</a>
                </c:if>

              </div>
              <p class=card-item-info>Gaming4Gamers no guarda ninguna información sobre tu tarjeta</p>
            </div>
          </div>
        </div>



      </div>
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
      <!-- partial -->
      <script src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.10/vue.min.js'></script>
      <script src='https://unpkg.com/vue-the-mask@0.11.1/dist/vue-the-mask.js'></script>
      <script src="./script.js"></script>
      <script src='../assets/js/tarjeta.js'></script>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
      <script src="../assets/js/script.min.js"></script>
      <script src="https://kit.fontawesome.com/a5ac13e346.js" crossorigin="anonymous"></script>
    </body>

    </html>