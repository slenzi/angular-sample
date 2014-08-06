<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>

	<title>Angular + Jersey + Spring Sample</title>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
	<link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
	<link rel="stylesheet" href="css/app.css"/>
	
	<script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>

	<ul class="menu">
		<li><a href="#/view1">view1</a></li>
		<li><a href="#/view2">view2</a></li>
	</ul>
	
	<!--[if lt IE 7]>
	    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	
	<div ng-view></div>
	
	<div>Angular seed app: v<span app-version></span></div>
	
	<h2>Sample application integrating Angular + Spring + Jersey</h2>
	
	<p>
	<a href="jersey/sample">fetch hello message (jersey/sample)</a>
	</p>
	
	<p>
	<a href="jersey/sample/count">fetch sample count (jersey/sample/count)</a>
	</p>
	
	<p>
	<a href="jersey/sample/1">fetch sample 1 (jersey/sample/1)</a>
	</p>
	
	<p>
	<a href="jersey/sample/samplejson">fetch sample as JSON (jersey/sample/samplejson)</a>
	</p>	
	
	<!-- In production use:
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
	-->
	<script src="bower_components/angular/angular.js"></script>
	<script src="bower_components/angular-route/angular-route.js"></script>
	<script src="js/app.js"></script>
	<script src="js/services.js"></script>
	<script src="js/controllers.js"></script>
	<script src="js/filters.js"></script>
	<script src="js/directives.js"></script>
  
</body>
</html>
