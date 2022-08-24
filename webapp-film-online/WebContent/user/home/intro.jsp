<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	 @import url('https://fonts.googleapis.com/css?family=Barlow');

        body {
            background: #787878 url(hinh-nen-anime-dep-cho-may-tinh-min.jpg) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            font-family: 'Barlow', sans-serif;
        }

        .container {
            width: 100%;
            position: relative;
            overflow: hidden;
        }

        a {
            text-decoration: none;
        }

        h1.main,
        p.demos {
            -webkit-animation-delay: 10s;
            -moz-animation-delay: 10s;
            -ms-animation-delay: 10s;
            animation-delay: 10s;
        }

        .sp-container {
            position: fixed;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100%;
            z-index: 0;
            background: -webkit-radial-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.3) 35%, rgba(0, 0, 0, 0.7));
            background: -moz-radial-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.3) 35%, rgba(0, 0, 0, 0.7));
            background: -ms-radial-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.3) 35%, rgba(0, 0, 0, 0.7));
            background: radial-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.3) 35%, rgba(0, 0, 0, 0.7));
        }

        .sp-content {
            position: absolute;
            width: 100%;
            height: 100%;
            left: 0px;
            top: 0px;
            z-index: 1000;
        }

        .sp-container h2 {
            position: absolute;
            top: 50%;
            line-height: 100px;
            height: 90px;
            margin-top: -50px;
            font-size: 90px;
            width: 100%;
            text-align: center;
            color: transparent;
            -webkit-animation: blurFadeInOut 2s ease-in backwards;
            -moz-animation: blurFadeInOut 2s ease-in backwards;
            -ms-animation: blurFadeInOut 2s ease-in backwards;
            animation: blurFadeInOut 2s ease-in backwards;
        }

        .sp-container h2.frame-1 {
            -webkit-animation-delay: 0s;
            -moz-animation-delay: 0s;
            -ms-animation-delay: 0s;
            animation-delay: 0s;
        }

        .sp-container h2.frame-2 {
            -webkit-animation-delay: 2s;
            -moz-animation-delay: 2s;
            -ms-animation-delay: 2s;
            animation-delay:2s;
        }

        .sp-container h2.frame-3 {
            -webkit-animation-delay: 5s;
            -moz-animation-delay: 5s;
            -ms-animation-delay: 5s;
            animation-delay: 5s;
        }

        .sp-container h2.frame-4 {
            font-size: 200px;
            -webkit-animation-delay: 6s;
            -moz-animation-delay: 6s;
            -ms-animation-delay: 6s;
            animation-delay: 6s;
        }

        .sp-container h2.frame-5 {
            -webkit-animation: none;
            -moz-animation: none;
            -ms-animation: none;
            animation: none;
            color: transparent;
            text-shadow: 0px 0px 1px #fff;
        }

        .sp-container h2.frame-5 span {
            -webkit-animation: blurFadeIn 3s ease-in 7s backwards;
            -moz-animation: blurFadeIn 1s ease-in 8s backwards;
            -ms-animation: blurFadeIn 3s ease-in 9s backwards;
            animation: blurFadeIn 3s ease-in 10s backwards;
            color: transparent;
            text-shadow: 0px 0px 1px #fff;
        }

        .sp-container h2.frame-5 span:nth-child(2) {
            -webkit-animation-delay: 5s;
            -moz-animation-delay: 5s;
            -ms-animation-delay: 5s;
            animation-delay: 5s;
        }

        .sp-container h2.frame-5 span:nth-child(3) {
            -webkit-animation-delay: 5s;
            -moz-animation-delay: 5s;
            -ms-animation-delay: 5s;
            animation-delay: 5s;
        }

        .sp-globe {
            position: absolute;
            width: 282px;
            height: 273px;
            left: 50%;
            top: 50%;
            margin: -137px 0 0 -141px;
            background: transparent url(http://web-sonick.zz.mu/images/sl/globe.png) no-repeat top left;
            -webkit-animation: fadeInBack 3.6s linear 7s backwards;
            -moz-animation: fadeInBack 3.6s linear 8s backwards;
            -ms-animation: fadeInBack 3.6s linear 9s backwards;
            animation: fadeInBack 3.6s linear 10s backwards;
            -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)";
            filter: alpha(opacity=30);
            opacity: 0.3;
            -webkit-transform: scale(5);
            -moz-transform: scale(5);
            -o-transform: scale(5);
            -ms-transform: scale(5);
            transform: scale(5);
        }

        .sp-circle-link {
            position: absolute;
            left: 50%;
            bottom: 100px;
            margin-left: -50px;
            text-align: center;
            line-height: 100px;
            width: 100px;
            height: 100px;
            background: #fff;
            color: #3f1616;
            font-size: 25px;
            -webkit-border-radius: 50%;
            -moz-border-radius: 50%;
            border-radius: 50%;
            -webkit-animation: fadeInRotate 1s linear 16s backwards;
            -moz-animation: fadeInRotate 1s linear 16s backwards;
            -ms-animation: fadeInRotate 1s linear 16s backwards;
            animation: fadeInRotate 1s linear 16s backwards;
            -webkit-transform: scale(1) rotate(0deg);
            -moz-transform: scale(1) rotate(0deg);
            -o-transform: scale(1) rotate(0deg);
            -ms-transform: scale(1) rotate(0deg);
            transform: scale(1) rotate(0deg);
        }

        .sp-circle-link:hover {
            background: #85373b;
            color: #fff;
        }

        /**/

        @-webkit-keyframes blurFadeInOut {
            0% {
                opacity: 0;
                text-shadow: 0px 0px 40px #fff;
                -webkit-transform: scale(1.3);
            }

            20%,
            75% {
                opacity: 1;
                text-shadow: 0px 0px 1px #fff;
                -webkit-transform: scale(1);
            }

            100% {
                opacity: 0;
                text-shadow: 0px 0px 50px #fff;
                -webkit-transform: scale(0);
            }
        }

        @-webkit-keyframes blurFadeIn {
            0% {
                opacity: 0;
                text-shadow: 0px 0px 40px #fff;
                -webkit-transform: scale(1.3);
            }

            50% {
                opacity: 0.5;
                text-shadow: 0px 0px 10px #fff;
                -webkit-transform: scale(1.1);
            }

            100% {
                opacity: 1;
                text-shadow: 0px 0px 1px #fff;
                -webkit-transform: scale(1);
            }
        }

        @-webkit-keyframes fadeInBack {
            0% {
                opacity: 0;
                -webkit-transform: scale(0);
            }

            50% {
                opacity: 0.4;
                -webkit-transform: scale(2);
            }

            100% {
                opacity: 0.2;
                -webkit-transform: scale(5);
            }
        }

        @-webkit-keyframes fadeInRotate {
            0% {
                opacity: 0;
                -webkit-transform: scale(0) rotate(360deg);
            }

            100% {
                opacity: 1;
                -webkit-transform: scale(1) rotate(0deg);
            }
        }

        /**/

        @-moz-keyframes blurFadeInOut {
            0% {
                opacity: 0;
                text-shadow: 0px 0px 40px #fff;
                -moz-transform: scale(1.3);
            }

            20%,
            75% {
                opacity: 1;
                text-shadow: 0px 0px 1px #fff;
                -moz-transform: scale(1);
            }

            100% {
                opacity: 0;
                text-shadow: 0px 0px 50px #fff;
                -moz-transform: scale(0);
            }
        }

        @-moz-keyframes blurFadeIn {
            0% {
                opacity: 0;
                text-shadow: 0px 0px 40px #fff;
                -moz-transform: scale(1.3);
            }

            100% {
                opacity: 1;
                text-shadow: 0px 0px 1px #fff;
                -moz-transform: scale(1);
            }
        }

        @-moz-keyframes fadeInBack {
            0% {
                opacity: 0;
                -moz-transform: scale(0);
            }

            50% {
                opacity: 0.4;
                -moz-transform: scale(2);
            }

            100% {
                opacity: 0.2;
                -moz-transform: scale(5);
            }
        }

        @-moz-keyframes fadeInRotate {
            0% {
                opacity: 0;
                -moz-transform: scale(0) rotate(360deg);
            }

            100% {
                opacity: 1;
                -moz-transform: scale(1) rotate(0deg);
            }
        }

        /**/

        @keyframes blurFadeInOut {
            0% {
                opacity: 0;
                text-shadow: 0px 0px 40px #fff;
                transform: scale(1.3);
            }

            20%,
            75% {
                opacity: 1;
                text-shadow: 0px 0px 1px #fff;
                transform: scale(1);
            }

            100% {
                opacity: 0;
                text-shadow: 0px 0px 50px #fff;
                transform: scale(0);
            }
        }

        @keyframes blurFadeIn {
            0% {
                opacity: 0;
                text-shadow: 0px 0px 40px #fff;
                transform: scale(1.3);
            }

            50% {
                opacity: 0.5;
                text-shadow: 0px 0px 10px #fff;
                transform: scale(1.1);
            }

            100% {
                opacity: 1;
                text-shadow: 0px 0px 1px #fff;
                transform: scale(1);
            }
        }

        @keyframes fadeInBack {
            0% {
                opacity: 0;
                transform: scale(0);
            }

            50% {
                opacity: 0.4;
                transform: scale(2);
            }

            100% {
                opacity: 0.2;
                transform: scale(5);
            }
        }

        @keyframes fadeInRotate {
            0% {
                opacity: 0;
                transform: scale(0) rotate(360deg);
            }

            100% {
                opacity: 1;
                transform: scale(1) rotate(0deg);
            }
        }
</style>
</head>
<body>
	<form action="DuAn1_QLPA1/edu.com.user.servl/intro" method="post"></form>
	<div class="sp-container">
        <div class="sp-content">
            <div class="sp-globe"></div>
            <h2 class="frame-1">Chao Mung Ban Den Voi </h2>
            <h2 class="frame-2">Anime Hay</h2>
            <h2 class="frame-3">Chuc Ban Xem Phim Vui Ve</h2>
            <h2 class="frame-5">
                <span>Anime</span>
                <span>Hay</span>
            </h2>
            <a class="sp-circle-link" href="http://localhost:8080/DuAn1_QLPA1/HomeServlet">Home page</a>
        </div>
    </div>
</body>
</html>