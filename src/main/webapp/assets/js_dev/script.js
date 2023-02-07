$(".videoJuegoCarrusel").click(function () {
  $(".videoJuegoCarrusel").removeClass("active");
  $(this).addClass("active");
});

$(function () {
  $("div#btnMenu").click(function () {
    $("div#menu").addClass("open");
  });

  $("div#close").click(function () {
    $("div#menu").removeClass("open");
  });

  $("div#menu nav ul li").hover(
    function () {
      const index = $(this).index();
      $("div.background-image:eq(" + index + ")").fadeIn(500);
    },
    function () {
      const index = $(this).index();
      $("div.background-image:eq(" + index + ")").fadeOut(500);
    }
  );
});

/* Cookie */
let cookieName = "CodingStatus";
let cookieValue = "Coding Tutorials";
let cookieExpireDays = 30;
let acceptCookie = document.getElementById("acceptCookie");
acceptCookie.onclick = function () {
  createCookie(cookieName, cookieValue, cookieExpireDays);
};
let createCookie = function (cookieName, cookieValue, cookieExpireDays) {
  let currentDate = new Date();
  currentDate.setTime(
    currentDate.getTime() + cookieExpireDays * 24 * 60 * 60 * 1000
  );
  let expires = "expires=" + currentDate.toGMTString();
  document.cookie = cookieName + "=" + cookieValue + ";" + expires + ";path=/";
  if (document.cookie) {
    document.getElementById("cookiePopup").style.display = "none";
  } else {
    alert(
      "Unable to set cookie. Please allow all cookies site from cookie setting of your browser"
    );
  }
};
let getCookie = function (cookieName) {
  let name = cookieName + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(";");
  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == " ") {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
};
let checkCookie = function () {
  let check = getCookie(cookieName);
  if (check == "") {
    document.getElementById("cookiePopup").style.display = "block";
  } else {
    document.getElementById("cookiePopup").style.display = "none";
  }
};
checkCookie();

// Widget de accesibilidad equalweb.com
window.interdeal = {
  sitekey: "4aabec31c3277e78b3e441e3404cedf7",
  Position: "Left",
  Menulang: "ES",
  domains: {
    js: "https://cdn.equalweb.com/",
    acc: "https://access.equalweb.com/",
  },
  btnStyle: {
    vPosition: ["50%", null],
    scale: ["0.8", "0.8"],
    color: {
      main: "#1b1b1b",
      second: "",
    },
    icon: {
      type: 10,
      shape: "semicircle",
      outline: false,
    },
  },
};
(function (doc, head, body) {
  var coreCall = doc.createElement("script");
  coreCall.src = "https://cdn.equalweb.com/core/4.4.1/accessibility.js";
  coreCall.defer = true;
  coreCall.integrity =
    "sha512-tq2wb4PBHqpUqBTfTG32Sl7oexERId9xGHX2O3yF91IYLII2OwM1gJVBXGbEPaLmfSQrIE+uAOzNOuEUZHHM+g==";
  coreCall.crossOrigin = "anonymous";
  coreCall.setAttribute("data-cfasync", true);
  body ? body.appendChild(coreCall) : head.appendChild(coreCall);
})(document, document.head, document.body);

/* Clarity */
(function (c, l, a, r, i, t, y) {
  c[a] =
    c[a] ||
    function () {
      (c[a].q = c[a].q || []).push(arguments);
    };
  t = l.createElement(r);
  t.async = 1;
  t.src = "https://www.clarity.ms/tag/" + i;
  y = l.getElementsByTagName(r)[0];
  y.parentNode.insertBefore(t, y);
})(window, document, "clarity", "script", "fktayco6jo");

/* Hotjar */
(function (h, o, t, j, a, r) {
  h.hj =
    h.hj ||
    function () {
      (h.hj.q = h.hj.q || []).push(arguments);
    };
  h._hjSettings = { hjid: 3346702, hjsv: 6 };
  a = o.getElementsByTagName("head")[0];
  r = o.createElement("script");
  r.async = 1;
  r.src = t + h._hjSettings.hjid + j + h._hjSettings.hjsv;
  a.appendChild(r);
})(window, document, "https://static.hotjar.com/c/hotjar-", ".js?sv=");
