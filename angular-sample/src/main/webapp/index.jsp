<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>

	<title>AngularJS + Jersey + Spring Sample!</title>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
	<link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
	<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="bower_components/ng-grid/ng-grid.min.css">
	<link rel="stylesheet" href="css/app.css"/>
	
	<script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>

<div class="container">
<div class="col-md-10">
	
	<!-- PAGE TITLE -->
	<div class="page-header">
		<h1><span class="glyphicon glyphicon-tower"></span>Consuming Jersey REST services using AngularJS</h1>
	</div>	

	<ul class="menu">
		<li><a href="#/info">Info</a></li>
		<li><a href="#/consume">REST Consume Test</a></li>
	</ul>
	
	<!--[if lt IE 7]>
	    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	
	<div ng-view></div>
	
	<p>
		<div>Angular seed app: v<span app-version></span></div>
	</p>	
	
	<!-- In production use:
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
	-->
	<script src="bower_components/angular/angular.js"></script>
	<script src="bower_components/angular-route/angular-route.js"></script>
	<script src="bower_components/angular-resource/angular-resource.js"></script>
	<script src="bower_components/jquery/dist/jquery.min.js"></script>
	<!-- angular & jquery must come before ng-grid -->
	<script src="bower_components/ng-grid/ng-grid-2.0.12.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/services.js"></script>
	<script src="js/controllers.js"></script>
	<script src="js/filters.js"></script>
	<script src="js/directives.js"></script>
 
</div>
</div>
  
</body>
</html>
